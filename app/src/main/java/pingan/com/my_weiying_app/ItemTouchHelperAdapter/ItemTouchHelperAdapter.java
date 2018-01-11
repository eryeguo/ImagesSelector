package pingan.com.my_weiying_app.ItemTouchHelperAdapter;

/**
 * Created by 迷人的脚毛！！ on 2018/1/8.
 */

public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition,int toPosition);
    //数据删除
    void onItemDissmiss(int position);
}