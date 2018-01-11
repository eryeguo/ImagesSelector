package pingan.com.my_weiying_app.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.adpater.Video2Adpater;
import pingan.com.my_weiying_app.adpater.Video3Adpater;
import pingan.com.my_weiying_app.bean.PingLunBean;
import pingan.com.my_weiying_app.bean.VideoBean;
import pingan.com.my_weiying_app.presenter.DataPresenter;
import pingan.com.my_weiying_app.view.IView;
import pingan.com.my_weiying_app.view.IViewa;

import static android.widget.LinearLayout.VERTICAL;

/**
 * Created by 迷人的脚毛！！ on 2018/1/1.
 */

public class NewFragment extends Fragment implements IView,IViewa{

    private RecyclerView recy;
    private RecyclerView recy1;
    private DataPresenter dataPresenter;
    private List<ListUrel> list=new ArrayList<>();

    private String stringa;
//    private int isxian=View.GONE;
    private static final String TAG = "NewFragment";
    private View v;
    private int aa;
    private TextView daoyan;
    private TextView zhuytan;
    private TextView jianjie;
    private TextView zhankai;
    private boolean isaa=true;
    private LinearLayout lin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //找到布局文件
        v = View.inflate(getActivity(), R.layout.listview, null);
        daoyan=(TextView) v.findViewById(R.id.daoyan);
        zhuytan=(TextView) v.findViewById(R.id.zhuytan);
        jianjie=(TextView) v.findViewById(R.id.jianjie);
        zhankai=(TextView) v.findViewById(R.id.zhankai);
        lin = (LinearLayout) v.findViewById(R.id.lin);

        //ListView控件
//        recy = (RecyclerView) v.findViewById(R.id.recy);
        recy1 = (RecyclerView) v.findViewById(R.id.recy1);


        dataPresenter = new DataPresenter();
        dataPresenter.attachView(this);
        dataPresenter.attachViewa(this);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        //接收传递过来的值
        String string = bundle.getString("name");
        Log.i(TAG, "onActivityCreated数据1: "+string);
        stringa = bundle.getString("namea");
        aa = bundle.getInt("aa");
        Log.i(TAG, "onActivityCreated数据2: "+stringa);
        //调用解析方法
        Jiexi(string);
        Jiexia(stringa);

    }

    private void Jiexi(String string) {

        Map<String,String> map = new HashMap<>();
        map.put("mediaId",string);
        dataPresenter.getVideo("http://api.svipmovie.com/",map);


    }

    private void Jiexia(String stringa) {
      //  http://api.svipmovie.com/front/Commentary/getCommentList.do?mediaId=5d21bed962f44c8eac068942745187ef
        Map<String,String> map = new HashMap<>();
        map.put("mediaId",stringa);
        dataPresenter.getPingLun("http://api.svipmovie.com/",map);
//        if (stringa.isEmpty()&&stringa!=null){
//            recy1.setVisibility(isxian);
//        }
    }

    @Override
    public void success(Object o) {
        VideoBean news= (VideoBean) o;
        Log.i(TAG, "数据为mm: "+news.toString());
        if (news!=null){
            VideoBean.RetBean ret = news.getRet();

            List<VideoBean.RetBean.ListBean> list = ret.getList();
            for (int i = 0; i <list.size() ; i++) {
                List<VideoBean.RetBean.ListBean.ChildListBean> childList = list.get(i).getChildList();
                Video3Adpater video3Adpater = new Video3Adpater(getActivity(),childList);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3 ,VERTICAL,false);
                recy1.setLayoutManager(gridLayoutManager);
                recy1.setAdapter(video3Adpater);
            }

//            daoyan.setText(ret.getDirector());
//             zhuytan.setText(ret.getDescription());
//              jianjie.setText(ret.getActors());


            ListUrel listUrel = new ListUrel();
            listUrel.setDaoyan(ret.getDirector());
            listUrel.setJianjie(ret.getDescription());
            listUrel.setZhuyan(ret.getActors());
            this.list.add(listUrel);
            Log.i(TAG, "数据为mm: "+ this.list.size());


            daoyan.setText("导演："+ret.getDirector());
            zhuytan.setText("主演："+ret.getActors());
            jianjie.setText("简介："+ret.getDescription());
            jianjie.setVisibility(View.GONE);
            zhankai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (isaa){
                        jianjie.setVisibility(View.VISIBLE);
                        zhankai.setText("收起");
                        isaa=false;
                        Toast.makeText(getActivity(),"点击了",Toast.LENGTH_SHORT).show();
                    }else{
                        jianjie.setVisibility(View.GONE);
                        zhankai.setText("展开");
                        isaa=true;
                    }
                }
            });


        }
    }

    @Override
    public void Failes(Exception e) {

    }

    @Override
    public void successa(Object o) {
        if (o instanceof List){
            List<PingLunBean.RetBean.ListBean> news= (List<PingLunBean.RetBean.ListBean>) o;
            if (news!=null){
                lin.setVisibility(View.GONE);
                Video2Adpater video2Adpater = new Video2Adpater(getActivity(),news);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),VERTICAL,false );
                recy1.setLayoutManager(linearLayoutManager);
                recy1.setAdapter(video2Adpater);

            }
        }
    }

    @Override
    public void Failesa(Exception e) {

    }
}