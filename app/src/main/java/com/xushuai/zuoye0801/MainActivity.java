package com.xushuai.zuoye0801;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;
import com.xushuai.zuoye0801.fragment.FourFragment;
import com.xushuai.zuoye0801.fragment.OneFragment;
import com.xushuai.zuoye0801.fragment.ThreeFragment;
import com.xushuai.zuoye0801.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_main);
        mBottomBar = (BottomTabBar) findViewById(R.id.bottom_bar);

        mBottomBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(15)
                .setTabPadding(4, 6, 10)
                //第一个参数是选中后的颜色，第二个是未选中时的颜色
                .setChangeColor(Color.RED, Color.GRAY)
                .addTabItem("月光茶人", R.mipmap.tab_home_s, OneFragment.class)
                .addTabItem("优惠", R.mipmap.tab_topic_s, TwoFragment.class)
                .addTabItem("购物车", R.mipmap.main_index_cart_pressed, ThreeFragment.class)
                .addTabItem("我的", R.mipmap.main_index_my_pressed, FourFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Log.i("TGA", "位置：" + position + "      选项卡：" + name);
                    }
                });
    }
}