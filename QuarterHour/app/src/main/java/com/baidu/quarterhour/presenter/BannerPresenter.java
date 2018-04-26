package com.baidu.quarterhour.presenter;

import com.baidu.quarterhour.model.ITotalModle;
import com.baidu.quarterhour.model.TotalModle;
import com.baidu.quarterhour.view.activity.IBannerView;
import com.baidu.quarterhour.view.base.BasePresenter;
import com.baidu.quarterhour.view.bean.BannerSuperClass;

import java.util.List;

/**
 * 轮播图p层类
 */

public class BannerPresenter extends BasePresenter<IBannerView> implements IBannerPresenter {
    private ITotalModle iTotalModle;
    public BannerPresenter(IBannerView iBannerView) {
        super.attachView(iBannerView);
        iTotalModle = new TotalModle();
    }

    @Override
    public void banner(String path) {
        iTotalModle.banner(path,this);
    }

    @Override
    public void onFailed(String msg) {
        if (view != null){
            view.onFailed(msg);
        }
    }

    @Override
    public void onSuccess(List<BannerSuperClass.DataBean> data) {
        if (view != null){
            view.onSuccess(data);
        }
    }

    @Override
    public void onDestrry() {
        if (view != null){
            view = null;
        }
    }
}
