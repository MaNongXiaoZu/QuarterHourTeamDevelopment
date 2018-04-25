package com.baidu.quarterhour.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.baidu.quarterhour.R;

/**
 * 封住Activity基类
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(getLayoutId());
        presenter = getPresenter();
        initView();
        getData();
    }

    protected abstract int getLayoutId();

    protected abstract T getPresenter();

    protected abstract void initView();

    protected abstract void getData();
}
