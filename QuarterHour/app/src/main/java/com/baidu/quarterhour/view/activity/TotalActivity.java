package com.baidu.quarterhour.view.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.quarterhour.R;
import com.baidu.quarterhour.view.base.BaseActivity;
import com.baidu.quarterhour.view.base.BasePresenter;
import com.baidu.quarterhour.view.fragment.CrossTalkFragment;
import com.baidu.quarterhour.view.fragment.RecommendFragment;
import com.baidu.quarterhour.view.fragment.VideoFragment;
import com.hjm.bottomtabbar.BottomTabBar;
/**
 * 主页加侧滑菜单
 * */
public class TotalActivity extends BaseActivity {
    private BottomTabBar bottomTabBar;
    private TextView title_text;
    private LinearLayout total_drawerLayout;
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
        bottomTabBar = findViewById(R.id.bottomTabBar);
        title_text = findViewById(R.id.title_text);
        total_drawerLayout = findViewById(R.id.total_drawerLayout);
    }

    @Override
    protected void getData() {
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(150,150)
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
    }
}
