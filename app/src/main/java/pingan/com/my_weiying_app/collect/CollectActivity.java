package pingan.com.my_weiying_app.collect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pingan.com.my_weiying_app.PersonDao;
import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.adpater.LishiAdpater;
import pingan.com.my_weiying_app.my.LishiJiLu;
import pingan.com.my_weiying_app.publica.MessageEventa;
import pingan.com.my_weiying_app.user.DbHelper;
import pingan.com.my_weiying_app.user.Person;
import pingan.com.my_weiying_app.video.VideoActivity;
import pingan.com.my_weiying_app.zidingyi.AddDelView;

import static android.widget.GridLayout.VERTICAL;
import static com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype.Shake;

public class CollectActivity extends AppCompatActivity {
    @BindView(R.id.recye)
    RecyclerView recye;
    private List<LishiJiLu> data = new ArrayList<>();
    private LishiAdpater myAdpater;
    private PersonDao dao;
    private List<Person> list;
    private AddDelView ade;
    private static final String TAG = "CollectActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);

        ade = (AddDelView) findViewById(R.id.ada);
        dao = DbHelper.getInstance(this).getPersonDao();
        ade.setOnAddDelClickLinstener(new AddDelView.OnAddDelClickLinstener() {

            private NiftyDialogBuilder dialogBuilder;

            @Override
            public void onAddClick(View v) {
            }
            @Override
            public void onDelClick(View v) {
                dialogBuilder = NiftyDialogBuilder.getInstance(CollectActivity.this);
                dialogBuilder
                        .withTitle("请选择")                                  //.withTitle(null)  no title
                        .withTitleColor("#FFFFFF")                                  //def
                        .withDividerColor("#11000000")                              //def
                        .withMessage("确定清空吗？")                     //.withMessage(null)  no Msg
                        .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                        .withDialogColor("#0077ff")                               //def  | withDialogColor(int resid)
                        .withIcon(getResources().getDrawable(R.drawable.like))
                        .withDuration(700)                                          //def
                        .withEffect(Shake)                                         //def Effectstype.Slidetop
                        .withButton1Text("OK")                                      //def gone
                        .withButton2Text("No")                                  //def gone
                        .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                        .setCustomView(R.layout.custom_view,v.getContext())         //.setCustomView(View or ResId,context)
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //删除所有
                                dao.deleteAll();


                                //设置适配器
                                if (data!=null){
                                    data.clear();
                                    initView();
                                    myAdpater.notifyDataSetChanged();
                                }
                                dialogBuilder.dismiss();
                            }
                        })
                        .setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBuilder.dismiss();
                                Toast.makeText(v.getContext(),"拜拜",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


        List<Person> persons = dao.loadAll();
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            String title = person.getTitle();
            String dataId = person.getDataId();
            String pic = person.getPic();
            LishiJiLu lishiJiLu = new LishiJiLu();
            lishiJiLu.setDataId(dataId);
            lishiJiLu.setPic(pic);
            lishiJiLu.setTitle(title);
            data.add(lishiJiLu);
        }
        //设置适配器
        if (data!=null){
            initView();
            myAdpater.notifyDataSetChanged();
        }
    }

    private void initView() {
        myAdpater = new LishiAdpater(this, data);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3 ,VERTICAL,false);
        recye.setLayoutManager(gridLayoutManager);
        recye.setAdapter(myAdpater);
        //点击事件     调用接口方法
        myAdpater.setOnRecyclerViewItemClickLintemet(new LishiAdpater.OnRecyclerViewItemClickLintemet() {
            @Override
            public void onItemClick(int position) {
                String dataId = data.get(position).getDataId();
                String pic = data.get(position).getPic();
                String title = data.get(position).getTitle();
                if (dataId!=null&&dataId!=""){
                    Intent intent = new Intent(CollectActivity.this,VideoActivity.class);

                    MessageEventa messageEventa1 = new MessageEventa();
                    messageEventa1.setPic(pic);
                    messageEventa1.setTitle(title);
                    messageEventa1.setDataId(dataId);
                 //   发送事件
                    EventBus.getDefault().postSticky(messageEventa1);
                    startActivity(intent);
                    CollectActivity.this.overridePendingTransition(R.anim.activity_open, R.anim.activity_open_close);
                }

            }
        });
        myAdpater.notifyDataSetChanged();

    }
}
