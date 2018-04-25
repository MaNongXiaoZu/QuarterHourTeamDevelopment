package com.baidu.quarterhour.view.myapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 初始化
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
