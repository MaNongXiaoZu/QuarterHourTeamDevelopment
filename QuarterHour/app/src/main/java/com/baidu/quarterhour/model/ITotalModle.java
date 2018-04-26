package com.baidu.quarterhour.model;

import com.baidu.quarterhour.presenter.IBannerPresenter;

/**
 * 全部的Modle层实现类
 */

public interface ITotalModle {
    void banner(String path, IBannerPresenter iBannerPresenter);
}
