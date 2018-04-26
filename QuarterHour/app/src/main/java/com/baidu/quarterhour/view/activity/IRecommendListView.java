package com.baidu.quarterhour.view.activity;

import com.baidu.quarterhour.view.bean.RecommendListSuperClass;

import java.util.List;

/**
 * 推荐里列表v层实现类
 */

public interface IRecommendListView {
    void onFailed(String msg);

    void onSuccessData(List<RecommendListSuperClass.DataBean> data);
}
