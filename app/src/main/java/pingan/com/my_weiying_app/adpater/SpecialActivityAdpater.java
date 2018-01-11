package pingan.com.my_weiying_app.adpater;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.bean.SpecialBean;

/**
 * Created by 迷人的脚毛！！ on 2017/12/31.
 */

public class SpecialActivityAdpater extends RecyclerView.Adapter<SpecialActivityAdpater.ViewHolder> {


    private Context context;
    private List<SpecialBean.RetBean.ListBean> list;

    public SpecialActivityAdpater(Context context, List<SpecialBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }
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
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.special_activity, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Uri uri = Uri.parse(list.get(position).getPic());
        holder.img.setImageURI(uri);
        holder.name.setText(list.get(position).getTitle());
        //条目单击事件
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private SimpleDraweeView img;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.activity_name);
            img=(SimpleDraweeView) itemView.findViewById(R.id.activity_img);
        }
    }
}
