package pingan.com.my_weiying_app.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.adpater.SplendidAdpter;
import pingan.com.my_weiying_app.bean.UserBean;
import pingan.com.my_weiying_app.presenter.DataPresenter;
import pingan.com.my_weiying_app.publica.MessageEventa;
import pingan.com.my_weiying_app.search.SearchActivity;
import pingan.com.my_weiying_app.utility.GlideImageLoader;
import pingan.com.my_weiying_app.video.VideoActivity;
import pingan.com.my_weiying_app.view.IView;

import static android.widget.LinearLayout.VERTICAL;

/**
 * Created by 迷人的脚毛！！ on 2017/12/29.
 */

public class SplendidFragment extends Fragment implements IView {
    private static final String TAG = "SplendidFragment";

    Unbinder unbinder;
    private List<String> data = new ArrayList<>();
    private View view;
    private Banner banner;
    private RecyclerView recy;
    private DataPresenter dataPresenter;
    private List<UserBean.RetBean.ListBean.ChildListBean> childList2;
    private EditText etSousuo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Fresco.initialize(getActivity());


        view = inflater.inflate(R.layout.splendid, container, false);


        banner = (Banner) view.findViewById(R.id.banner);
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //查找控件
        initView();
        ActionBar actionbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) getActivity()).onBackPressed();
            }


        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("CollapsingToolbarLayout");

        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色


        dataPresenter = new DataPresenter();
        dataPresenter.attachView(this);
        //http://api.svipmovie.com/front/homePageApi/homePage.do
        dataPresenter.getData("http://api.svipmovie.com/");


        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    private void initView() {
        recy = (RecyclerView) view.findViewById(R.id.recy);
        etSousuo = (EditText) view.findViewById(R.id.et_sousuo);

        etSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_open, R.anim.activity_open_close);
            }
        });
    }

    @Override
    public void success(Object o) {
        UserBean news = (UserBean) o;
        if (news != null) {
            UserBean.RetBean ret = news.getRet();
            if (ret != null) {
                List<UserBean.RetBean.ListBean> list = ret.getList();
//               Log.i(TAG, "解析成功: "+ list.size());
                List<UserBean.RetBean.ListBean.ChildListBean> childList = list.get(0).getChildList();

                for (int i = 0; i < childList.size(); i++) {
                    String pic = childList.get(i).getPic();
                    data.add(pic);
                    Log.i(TAG, "图片: " + data.size());
                }
                if (data != null) {
                    //设置图片加载器
                    banner.setImageLoader(new GlideImageLoader());
                    //设置图片集合
                    banner.setImages(data);
                    //banner设置方法全部调用完毕时最后调用
                    banner.start();
                }
                childList2 = list.get(4).getChildList();


                if (childList2 != null) {
                    SplendidAdpter splendidAdpter = new SplendidAdpter(getActivity(), childList2);
                    //点击事件     调用接口方法
                    splendidAdpter.setOnRecyclerViewItemClickLintemet(new SplendidAdpter.OnRecyclerViewItemClickLintemet() {
                        @Override
                        public void onItemClick(int position) {

//                           intent.putExtra("name",dataId);
                            String pic = childList2.get(position).getPic();
                            String title = childList2.get(position).getTitle();
                            String dataId = childList2.get(position).getDataId();

                            if (dataId != null && dataId != "") {
                                Intent intent = new Intent(getActivity(), VideoActivity.class);
//
                                MessageEventa messageEventa = new MessageEventa();
                                messageEventa.setPic(pic);
                                messageEventa.setTitle(title);
                                messageEventa.setDataId(dataId);

                                //发送事件
                                EventBus.getDefault().postSticky(messageEventa);

                                startActivity(intent);
//                               MainActivity a= (MainActivity) getActivity();
                                getActivity().overridePendingTransition(R.anim.activity_open, R.anim.activity_open_close);
                            }

                        }


                    });

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), VERTICAL, false);
                    recy.setLayoutManager(linearLayoutManager);
                    recy.setAdapter(splendidAdpter);
                    splendidAdpter.notifyDataSetChanged();
                }
            }

        }


    }

    @Override
    public void Failes(Exception e) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dataPresenter != null) {
            dataPresenter.delete();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}