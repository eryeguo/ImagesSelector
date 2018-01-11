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
import pingan.com.my_weiying_app.bean.PingLunBean;

/**
 * Created by 迷人的脚毛！！ on 2018/1/1.
 */

public class Video2Adpater extends RecyclerView.Adapter<Video2Adpater.ViewHolder> {



    private Context context;
    private  List<PingLunBean.RetBean.ListBean> list;

    public Video2Adpater(Context context, List<PingLunBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.video_adpate2r, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Uri uri = Uri.parse(list.get(position).getUserPic());

        holder.img.setImageURI(uri);

        holder.name.setText(list.get(position).getPhoneNumber());
        holder.shijian.setText(list.get(position).getTime());
        holder.title.setText(list.get(position).getMsg());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView shijian;
        private TextView title;
        private SimpleDraweeView img;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.video_name);
             shijian=(TextView) itemView.findViewById(R.id.video_shijian);
             title=(TextView) itemView.findViewById(R.id.video_title);
             img=(SimpleDraweeView) itemView.findViewById(R.id.my_image_view);
        }
    }
}
