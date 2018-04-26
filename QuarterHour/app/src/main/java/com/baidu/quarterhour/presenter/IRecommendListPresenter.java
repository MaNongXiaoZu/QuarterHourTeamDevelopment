package com.baidu.quarterhour.presenter;

import com.baidu.quarterhour.view.bean.RecommendListSuperClass;

import java.util.List;

/**
 * 列表p层实现类
 */

public interface IRecommendListPresenter {
    void recommendList(String path,String uid,String type,String page,String android,String appVersion);

    void onFailed(String msg);

    void onSuccess(List<RecommendListSuperClass.DataBean> data);

    void onDestrry();
}
