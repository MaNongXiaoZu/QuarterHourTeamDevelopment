package com.baidu.quarterhour.view.activity;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.quarterhour.R;
import com.baidu.quarterhour.view.base.BaseActivity;
import com.baidu.quarterhour.view.base.BasePresenter;
import com.baidu.quarterhour.view.fragment.CrossTalkFragment;
import com.baidu.quarterhour.view.fragment.RecommendFragment;
import com.baidu.quarterhour.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
/**
 * 主页加侧滑菜单
 * */
public class TotalActivity extends BaseActivity {
    private DrawerLayout total_drawerLayout;
    private BottomTabBar bottomTabBar;
    private SimpleDraweeView title_image_left;
    private TextView title_text;
    private SimpleDraweeView title_image_right;
    private LinearLayout total_linearLayout;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_total;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        total_drawerLayout = findViewById(R.id.total_drawerLayout);
        bottomTabBar = findViewById(R.id.bottomTabBar);
        title_image_left = findViewById(R.id.title_image_left);
        title_text = findViewById(R.id.title_text);
        title_image_right = findViewById(R.id.title_image_right);
        total_linearLayout = findViewById(R.id.total_linearLayout);
    }

    @Override
    protected void getData() {
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .addTabItem("推荐", R.mipmap.tuijian2,R.mipmap.tuijian1, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.duanzi2,R.mipmap.duanzi1, CrossTalkFragment.class)
                .addTabItem("视频", R.mipmap.shipin2,R.mipmap.shipin1, VideoFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        title_text.setText(name);
                    }
                });
        //点击头像监听
        title_image_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_drawerLayout.openDrawer(total_linearLayout);
            }
        });
        //点击编辑监听
        title_image_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TotalActivity.this,"编辑",Toast.LENGTH_LONG).show();
            }
        });
    }
}
