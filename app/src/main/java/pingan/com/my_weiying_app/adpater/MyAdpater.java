package pingan.com.my_weiying_app.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.my.LishiJiLu;

/**
 * Created by 迷人的脚毛！！ on 2018/1/2.
 */

public class MyAdpater extends RecyclerView.Adapter<MyAdpater.ViewHolder> {
    //定义一个接口点击事件
    public interface OnRecyclerViewItemClickLintemet{
        void onItemClick(int position);
    }
    //定义接口对象         单击事件
    private OnRecyclerViewItemClickLintemet listener;
    //定义接口方法         单击事件
    public void setOnRecyclerViewItemClickLintemet(OnRecyclerViewItemClickLintemet listener){

        this.listener=listener;
    };
    private Context context;
    private List<LishiJiLu> list;

    public MyAdpater(Context context, List<LishiJiLu> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.my_view, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //条目单击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
//        Uri uri = Uri.parse(list.get(position).getPic());
//        holder.img.setImageURI(uri);

        Glide.with(context).load(list.get(position).getPic()).into(holder.img);
        holder.name.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.nameaa);
            img=(ImageView) itemView.findViewById(R.id.imgaa);
        }
    }
}
