package pingan.com.my_weiying_app;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pingan.com.my_weiying_app.collect.CollectActivity;
import pingan.com.my_weiying_app.fragment.DiscoverFragment;
import pingan.com.my_weiying_app.fragment.MyFragment;
import pingan.com.my_weiying_app.fragment.SpecialFragment;
import pingan.com.my_weiying_app.fragment.SplendidFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mb;
    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //创建SimpleDraweeView对象
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        //创建将要下载的图片的URI
        Uri imageUri = Uri.parse("http://img2.utuku.china.com/500x0/news/20170112/e786dda2-3822-45ef-b6ba-8cc09fd487a7.jpg");
        //开始下载
        simpleDraweeView.setImageURI(imageUri);

        mb = (BottomTabBar) findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("精彩", R.drawable.found, SplendidFragment.class)
                .addTabItem("专题", R.drawable.special, SpecialFragment.class)
                .addTabItem("发现", R.drawable.fancy, DiscoverFragment.class)
                .addTabItem("我的", R.drawable.my, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
//        .setTabBarBackgroundResource(R.drawable.qqq)

    }

    @OnClick({R.id.item_one, R.id.item_tow, R.id.item_three, R.id.item_a, R.id.item_b, R.id.item_c})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_one:
                Intent intent = new Intent(MainActivity.this, CollectActivity.class);
                startActivity(intent);

                break;
            case R.id.item_tow:
                break;
            case R.id.item_three:
                break;
            case R.id.item_a:
                break;
            case R.id.item_b:
                break;
            case R.id.item_c:
                break;
        }
    }


}
