package com.baidu.quarterhour.model;

import android.util.Log;

import com.baidu.quarterhour.presenter.IBannerPresenter;
import com.baidu.quarterhour.view.api.ApiService;
import com.baidu.quarterhour.view.bean.BannerSuperClass;
import com.baidu.quarterhour.view.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 全部的Modle类
 */

public class TotalModle implements ITotalModle {

    private RetrofitUtils retrofitUtils;

    @Override
    public void banner(String path, final IBannerPresenter iBannerPresenter) {
        retrofitUtils = RetrofitUtils.getInData();
        ApiService apiService = retrofitUtils.getRetrofit(path, ApiService.class);
        Flowable<BannerSuperClass> flowable = apiService.getBannerData();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<BannerSuperClass>() {
                    @Override
                    public void onNext(BannerSuperClass bannerSuperClass) {
                        iBannerPresenter.onSuccess(bannerSuperClass.getData());
                    }

                    @Override
                    public void onError(Throwable t) {
                        iBannerPresenter.onFailed(t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
