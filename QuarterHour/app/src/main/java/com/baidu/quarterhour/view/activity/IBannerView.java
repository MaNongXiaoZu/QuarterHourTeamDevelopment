package com.baidu.quarterhour.view.activity;

import com.baidu.quarterhour.view.bean.BannerSuperClass;

import java.util.List;

/**
 * 轮播图v层实现类
 */

public interface IBannerView {
    void onFailed(String msg);

    void onSuccess(List<BannerSuperClass.DataBean> data);
}
