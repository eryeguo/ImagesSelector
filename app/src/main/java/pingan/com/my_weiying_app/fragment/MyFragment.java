package pingan.com.my_weiying_app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.adpater.MyAdpater;
import pingan.com.my_weiying_app.collect.CollectActivity;
import pingan.com.my_weiying_app.my.LishiActivity;
import pingan.com.my_weiying_app.my.LishiJiLu;
import pingan.com.my_weiying_app.my.MessageEventb;
import pingan.com.my_weiying_app.publica.MessageEventa;
import pingan.com.my_weiying_app.video.VideoActivity;

import static android.widget.LinearLayout.HORIZONTAL;

/**
 * Created by 迷人的脚毛！！ on 2017/12/29.
 */

public class MyFragment extends Fragment {
    @BindView(R.id.recyq)
    RecyclerView recyq;
    Unbinder unbinder;
    private List<LishiJiLu> list=new ArrayList<>();
    private MyAdpater myAdpater;
    private String pic1;
    private String title1;
    private String dataId1;
    private boolean is=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my, container, false);
        EventBus.getDefault().register(this);
               unbinder = ButterKnife.bind(this, view);

        //设置适配器

        if (list!=null){
            initView();

            myAdpater.notifyDataSetChanged();
        }

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        if (list!=null){
            myAdpater.notifyDataSetChanged();
            MessageEventb messageEventb = new MessageEventb();
            messageEventb.setList(list);
            EventBus.getDefault().postSticky(messageEventb);
        }
    }

    private void initView() {

        myAdpater = new MyAdpater(getActivity(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),HORIZONTAL,false );
        recyq.setLayoutManager(linearLayoutManager);

        recyq.setAdapter(myAdpater);
        //点击事件     调用接口方法
        myAdpater.setOnRecyclerViewItemClickLintemet(new MyAdpater.OnRecyclerViewItemClickLintemet() {
            @Override
            public void onItemClick(int position) {
                String dataId = list.get(position).getDataId();
                String pic = list.get(position).getPic();
                String title = list.get(position).getTitle();
                if (dataId!=null&&dataId!=""){
                    Intent intent = new Intent(getActivity(),VideoActivity.class);
                    for (int i = 0; i <list.size() ; i++) {
                        if (title.equals(list.get(i).getTitle())){

                             list.remove(position);
                            LishiJiLu lishiJiLu = new LishiJiLu();
                            lishiJiLu.setPic(pic);
                            lishiJiLu.setTitle(title);
                            lishiJiLu.setDataId(dataId);

                            list.add(0,lishiJiLu);
                        }
                    }

                    startActivity(intent);
                }

            }
        });
        myAdpater.notifyDataSetChanged();

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMessageEvent(MessageEventa event) {
        pic1 = event.getPic();
        title1 = event.getTitle();
        dataId1 = event.getDataId();

        if (list!=null){
            for (int i = 0; i <list.size() ; i++) {
                if (title1.equals(list.get(i).getTitle())){

                    Toast.makeText(getActivity(),"哈哈",Toast.LENGTH_SHORT).show();
                    is=false;
                    return;
                }else{

                    is=true;

                }
            }
        }else{
            LishiJiLu lishiJiLu = new LishiJiLu();
            lishiJiLu.setPic(pic1);
            lishiJiLu.setTitle(title1);
            lishiJiLu.setDataId(dataId1);

            list.add(0,lishiJiLu);
        }

        if (is){
            LishiJiLu lishiJiLu = new LishiJiLu();
            lishiJiLu.setPic(pic1);
            lishiJiLu.setTitle(title1);
            lishiJiLu.setDataId(dataId1);

            list.add(0,lishiJiLu);

        }

    };


    @OnClick({R.id.item_c, R.id.item_d, R.id.item_e, R.id.item_f})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_c:

                Intent intent = new Intent(getActivity(),LishiActivity.class);



                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_open, R.anim.activity_open_close);
                break;
            case R.id.item_d:
                Toast.makeText(getActivity(),"敬请期待",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_e:
                Intent intent1 = new Intent(getActivity(), CollectActivity.class);
                startActivity(intent1);

                break;
            case R.id.item_f:
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
