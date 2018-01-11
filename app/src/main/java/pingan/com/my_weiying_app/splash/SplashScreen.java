package pingan.com.my_weiying_app.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import pingan.com.my_weiying_app.MainActivity;
import pingan.com.my_weiying_app.R;

public class SplashScreen extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;
    //倒计时5秒
    private int aa = 2;


    private static final String TAG = "SplashScreen";
   private int b=0;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        //进行缩放
        ScaleAnimation sa = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa.setDuration(2000);
        sa.setRepeatCount(2);
        sa.setRepeatMode(Animation.REVERSE);
        img.startAnimation(sa);

//===================================================================

        sharedPreferences = getSharedPreferences("aa", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        //存入数据
//        editor.putInt("name", b);

        int name = sharedPreferences.getInt("name", 0);

        if (name%3 == 0){
            img.setBackgroundResource(R.drawable.one);
        }else if (name%3==1){
            img.setBackgroundResource(R.drawable.tow);
        }else if (name%3==2){
            img.setBackgroundResource(R.drawable.three);
        }

        editor.putInt("name", sharedPreferences.getInt("name",0)+1);

        editor.commit();
        Log.d("zzz", "onCreate: "+sharedPreferences.getInt("name",0));
        //===================================================================
        //定时器
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                aa--;
                if (aa == 0) {
                    //进行跳转
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.schedule(task, 1, 1000);


    }


    @Override
    protected void onStart() {
        super.onStart();
//        SharedPreferences sharedPreferences =getSharedPreferences("aaa", Context.MODE_PRIVATE);
//         b = sharedPreferences.getInt("name", 0);
//        Log.i(TAG, "z值: "+b);
//        if(name==3){
//            b=0;
//            if (name==1){
//                img.setBackgroundResource(R.drawable.one);
//            }
//            if (name==2){
//                img.setBackgroundResource(R.drawable.tow);
//            }
//            if (name==3){
//                img.setBackgroundResource(R.drawable.three);
//            }
//        }



    }

}


