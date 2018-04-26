package com.baidu.quarterhour.view.api;

import com.baidu.quarterhour.view.bean.BannerSuperClass;
import com.baidu.quarterhour.view.bean.RecommendListSuperClass;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 实现类
 */

public interface ApiService {
    //广告轮播图
    @POST("/quarter/getAd")
    Flowable<BannerSuperClass> getBannerData();
    //推荐里的列表
    @FormUrlEncoded
    @POST("/quarter/getVideos")
    Flowable<RecommendListSuperClass> getRecommendListData(@Field("uid")String uid,@Field("type")String type,@Field("page")String page,@Field("source")String android,@Field("appVersion")String appVersion);
}
