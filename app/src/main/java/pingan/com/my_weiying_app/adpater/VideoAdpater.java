package pingan.com.my_weiying_app.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pingan.com.my_weiying_app.R;
import pingan.com.my_weiying_app.video.ListUrel;

/**
 * Created by 迷人的脚毛！！ on 2018/1/1.
 */

public class VideoAdpater extends RecyclerView.Adapter<VideoAdpater.ViewHolder> {



    private Context context;
    private List<ListUrel> list;

    public VideoAdpater(Context context, List<ListUrel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.video_adpater, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.daoyan.setText("导演："+list.get(position).getDaoyan());
        holder.zhuytan.setText("主演："+list.get(position).getZhuyan());
        holder.jianjie.setText("简介："+list.get(position).getJianjie());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView daoyan;
        private TextView zhuytan;
        private TextView jianjie;
        public ViewHolder(View itemView) {
            super(itemView);
            daoyan=(TextView) itemView.findViewById(R.id.daoyan);
             zhuytan=(TextView) itemView.findViewById(R.id.zhuytan);
             jianjie=(TextView) itemView.findViewById(R.id.jianjie);
        }
    }
}
