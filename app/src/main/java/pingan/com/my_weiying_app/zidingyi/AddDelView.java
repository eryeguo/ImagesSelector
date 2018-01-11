package pingan.com.my_weiying_app.zidingyi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import pingan.com.my_weiying_app.R;

/**
 * Created by 迷人的脚毛！！ on 2018/1/2.
 */

public class AddDelView extends LinearLayout {




    //定义接口
   public interface OnAddDelClickLinstener{
        void onAddClick(View v);
        void onDelClick(View v);

    }
    //定义接口方法
    private OnAddDelClickLinstener linsanter;
    //定义接口方法
    public void setOnAddDelClickLinstener(OnAddDelClickLinstener linsanter){
        this.linsanter=linsanter;
    }

    public AddDelView(Context context) {
        this(context,null);
    }

    public AddDelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AddDelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {

        View view = View.inflate(context, R.layout.layout_del_add, this);

        TextView add=(TextView) findViewById(R.id.add);
        final TextView del=(TextView) findViewById(R.id.shoucan);

       //自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AddDelViewStyle);
        String leftText = typedArray.getString(R.styleable.AddDelViewStyle_left_text);
        String rightText = typedArray.getString(R.styleable.AddDelViewStyle_right_text);

        int color = typedArray.getColor(R.styleable.AddDelViewStyle_left_text_color, Color.RED);

        //自定义属性设置
        add.setText(leftText);

        del.setText(rightText);

//        因为是数组，所以需要回收
        typedArray.recycle();





        del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                linsanter.onDelClick(view);
                del.setBackgroundResource(R.drawable.collection_select);

            }
        });
    }



}