package com.baidu.quarterhour.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.quarterhour.R;
import com.baidu.quarterhour.view.base.BaseActivity;
import com.baidu.quarterhour.view.base.BasePresenter;

import java.util.Timer;
import java.util.TimerTask;
/**
 * 三秒跳转页面
 * */
public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,TotalActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
