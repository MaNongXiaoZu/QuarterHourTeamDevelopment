package com.baidu.quarterhour.presenter;

import com.baidu.quarterhour.view.bean.BannerSuperClass;

import java.util.List;

/**
 * 轮播图p层实现类
 */

public interface IBannerPresenter {
    void banner(String path);

    void onFailed(String msg);

    void onSuccess(List<BannerSuperClass.DataBean> data);

    void onDestrry();
}
