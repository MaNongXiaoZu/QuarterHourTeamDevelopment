package com.baidu.quarterhour.view.api;

import com.baidu.quarterhour.view.bean.BannerSuperClass;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 实现类
 */

public interface ApiService {
    //广告轮播图
    @POST("/quarter/getAd")
    Flowable<BannerSuperClass> getBannerData();
}
