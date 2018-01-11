package pingan.com.my_weiying_app.adpater;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import pingan.com.my_weiying_app.ItemTouchHelperAdapter.ItemTouchHelperAdapter;
import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.search.SearchBean;


/**
 * Created by 迷人的脚毛！！ on 2018/1/4.
 */

public class SouSuoHorizontalRvAdapter extends RecyclerView.Adapter<SouSuoHorizontalRvAdapter.ViewHolder> implements ItemTouchHelperAdapter {

    private static final String TAG = "SouSuoHorizontalRvAdapt";
    private Context context;
    private   List<SearchBean.RetBean.ListBean> list;
    private boolean is=true;



//    //定义一个接口点击事件
//    public interface OnRecyclerViewItemClickLintemet{
//        void onItemClick(int position);
//    }
//    //定义接口对象         单击事件
//    private OnRecyclerViewItemClickLintemet listener;
//    //定义接口方法         单击事件
//    public void setOnRecyclerViewItemClickLintemet(OnRecyclerViewItemClickLintemet listener){
//
//        this.listener=listener;
//    };
    public SouSuoHorizontalRvAdapter(Context context, List<SearchBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.sousuo_view, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //条目单击事件
//        holder.sou_zhankai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onItemClick(position);
//
//            }
//        });
        holder.sou_daoyan.setText("导演"+list.get(position).getDirector());
        holder.sou_zhuytan.setText("主演"+list.get(position).getActors());
        holder.sou_jianjie.setText("简介"+list.get(position).getDescription());
        Uri uri = Uri.parse(list.get(position).getPic());
        holder.sou_jianjie.setVisibility(View.GONE);
        holder.sou_imga.setImageURI(uri);
        holder.sou_zhankai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is){
                    holder.sou_jianjie.setVisibility(View.VISIBLE);
                    holder.sou_zhankai.setText("收缩");
                    is=false;
                }else{
                    holder.sou_jianjie.setVisibility(View.GONE);
                    holder.sou_zhankai.setText("展开");
                    is=true;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

    }

    @Override
    public void onItemDissmiss(int position) {
        //移除数据
        list.remove(position);
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView sou_daoyan;
        private TextView sou_zhuytan;
        private TextView sou_jianjie;
        private TextView sou_zhankai;
        private SimpleDraweeView sou_imga;
        public ViewHolder(View itemView) {
            super(itemView);
            sou_daoyan=(TextView) itemView.findViewById(R.id.sou_daoyan);
            sou_zhuytan=(TextView) itemView.findViewById(R.id.sou_zhuytan);
            sou_jianjie=(TextView) itemView.findViewById(R.id.sou_jianjie);
            sou_zhankai=(TextView) itemView.findViewById(R.id.sou_zhankai);
            sou_imga=(SimpleDraweeView) itemView.findViewById(R.id.sou_imga);
        }
    }
}
