package com.baidu.quarterhour.presenter;

import com.baidu.quarterhour.model.ITotalModle;
import com.baidu.quarterhour.model.TotalModle;
import com.baidu.quarterhour.view.activity.IRecommendListView;
import com.baidu.quarterhour.view.base.BasePresenter;
import com.baidu.quarterhour.view.bean.RecommendListSuperClass;

import java.util.List;

/**
 * 列表p层类
 */

public class RecommendListPresenter extends BasePresenter<IRecommendListView> implements IRecommendListPresenter {
    private ITotalModle iTotalModle;

    public RecommendListPresenter(IRecommendListView iRecommendListView) {
        super.attachView(iRecommendListView);
        iTotalModle = new TotalModle();
    }

    @Override
    public void recommendList(String path, String uid, String type, String page, String android, String appVersion) {
        iTotalModle.recommendList(path,uid,type,page,android,appVersion,this);
    }

    @Override
    public void onFailed(String msg) {
        if (view != null){
            view.onFailed(msg);
        }
    }

    @Override
    public void onSuccess(List<RecommendListSuperClass.DataBean> data) {
        if (view != null){
            view.onSuccessData(data);
        }
    }

    @Override
    public void onDestrry() {
        if (view != null){
            view = null;
        }
    }
}
