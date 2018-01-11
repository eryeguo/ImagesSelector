package pingan.com.my_weiying_app.video;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import pingan.com.my_weiying_app.PersonDao;
import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.bean.VideoBean;
import pingan.com.my_weiying_app.my.LishiJiLu;
import pingan.com.my_weiying_app.presenter.DataPresenter;
import pingan.com.my_weiying_app.publica.MessageEventa;
import pingan.com.my_weiying_app.user.DbHelper;
import pingan.com.my_weiying_app.user.Person;
import pingan.com.my_weiying_app.view.IView;
import pingan.com.my_weiying_app.zidingyi.AddDelView;

public class VideoActivity extends AppCompatActivity implements IView{

    private TabLayout tab;
    private ViewPager pa;
    private List<String> list=new ArrayList<String>();
    private AddDelView ade;
    private static final String TAG = "VideoActivity";
    private JCVideoPlayerStandard player;
    private String intent;
    private String pic1;
    private String title1;
    private String dataId1;
    private List<LishiJiLu> data=new ArrayList<>();
    private PersonDao dao;
    private boolean is=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        EventBus.getDefault().register(this);
        ade = (AddDelView) findViewById(R.id.ade);
        //拿到要操作的对象
        dao = DbHelper.getInstance(this).getPersonDao();
        //自定义控件的加减以及EditText 。这三个的回调接口
        ade.setOnAddDelClickLinstener(new AddDelView.OnAddDelClickLinstener() {
            @Override
            public void onAddClick(View v) {
            }
            @Override
            public void onDelClick(View v) {

//插入
                Person p = new Person();
                //selsct * from aa where id=2 and name=lisi
                List<Person> persons = dao.loadAll();
                if (title1!=null){
                    for (int i = 0; i <persons.size() ; i++) {
                        if (title1.equals(persons.get(i).getTitle())){

                            Toast.makeText(VideoActivity.this,"已存在",Toast.LENGTH_SHORT).show();
                            is=false;
                            return;
                        }else{
                            is=true;

                        }

                    }

                }

                if (is){
                    p.setTitle(title1);
                    p.setDataId(dataId1);
                    p.setPic(pic1);
                    long insert = dao.insert(p);
                    Log.i(TAG,"插入了"+insert);
                    Toast.makeText(VideoActivity.this,"收藏",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //查找控件
        tab = (TabLayout) findViewById(R.id.tab);
        pa = (ViewPager) findViewById(R.id.pager);


        //http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=0334e38676d54208b1e6b9da28758a2e
        Map<String,String> map = new HashMap<>();
        map.put("mediaId", dataId1);
        DataPresenter dataPresenter = new DataPresenter();
        dataPresenter.attachView(this);
        dataPresenter.getVideo("http://api.svipmovie.com/",map);

        player = (JCVideoPlayerStandard) findViewById(R.id.player_list_video);

        //tab的标题
        list.add("简介");
        list.add("评论");


        //tablayout和viewpager关联
        tab.setupWithViewPager(pa);

        //设置viewpager适配器
        pa.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //重写这个方法，将设置每个Tab的标题
            @Override
            public CharSequence getPageTitle(int position) {

                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                //一般我们在这个位置对比一下标题是什么,,,然后返回对应的fragment
                //初始化fragment  对应position有多少，fragment有多少
                NewFragment newFragment = new NewFragment();
                Bundle bundle = new Bundle();
                if (list.get(position).equals("简介")){
                    bundle.putString("name", dataId1);
                }else if (list.get(position).equals("评论")){
                    bundle.putString("namea", dataId1);
       }
                //给fragment 加bundle 数据
                //activity与fragment 1.getset，2.接口回调，3.setArguments ,getAraguments
                newFragment.setArguments(bundle);
                return newFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMessageEvent(MessageEventa event) {
        pic1 = event.getPic();
        title1 = event.getTitle();
        dataId1 = event.getDataId();

        LishiJiLu lishiJiLu = new LishiJiLu();

        lishiJiLu.setPic(pic1);
        lishiJiLu.setTitle(title1);
        lishiJiLu.setDataId(dataId1);

        data.add(lishiJiLu);
        Log.i(TAG, "视频页面传递过来的值onMessageEvent: "+dataId1.toString());



    };



    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


    @Override
    public void success(Object o) {
        VideoBean news= (VideoBean) o;
        if (news!=null){
            VideoBean.RetBean ret = news.getRet();
            Log.i(TAG, "视频播放: "+ret.toString());
            String hdurl = ret.getHDURL();
            Log.i(TAG, "视频播放页面: "+hdurl.toString());

            boolean setUp = player.setUp(hdurl, JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        }
    }

    @Override
    public void Failes(Exception e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        finish();
    }
    @Override
    public void finish(){
        //TODOAuto-generatedmethodstub
        super.finish();
        //关闭窗体动画显示
        this.overridePendingTransition(0,R.anim.activity_close);
    }
}
