package com.baidu.quarterhour.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.baidu.quarterhour.R;
import com.baidu.quarterhour.presenter.BannerPresenter;
import com.baidu.quarterhour.presenter.IBannerPresenter;
import com.baidu.quarterhour.view.activity.IBannerView;
import com.baidu.quarterhour.view.api.Api;
import com.baidu.quarterhour.view.banner.AccordionTransformer;
import com.baidu.quarterhour.view.banner.AutoBanner;
import com.baidu.quarterhour.view.base.BaseFragment;
import com.baidu.quarterhour.view.base.BasePresenter;
import com.baidu.quarterhour.view.bean.BannerSuperClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐-->热门
 */

public class RecommendHotFragment extends BaseFragment implements IBannerView, AutoBanner.AutoBannerListener {
    private AutoBanner mAutoBanner;
    private RecyclerView hot_recycle_view;
    private List<String> mImgUrls;
    private IBannerPresenter bannerPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_hot_fragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        mAutoBanner = (AutoBanner) view.findViewById(R.id.hot_auto_banner);
        hot_recycle_view = (RecyclerView) view.findViewById(R.id.hot_recycle_view);
        bannerPresenter = new BannerPresenter(this);
        mImgUrls = new ArrayList<>();
    }

    @Override
    protected void getData() {
        bannerPresenter.banner(Api.HOST_NAME);
    }

    @Override
    protected void getDestory() {
        bannerPresenter.onDestrry();
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(List<BannerSuperClass.DataBean> data) {

        for (int i = 0; i < data.size() ; i++){
            mImgUrls.add(data.get(i).getIcon());
        }

        //不设置setAuto，不会自动轮播，不设置监听，无法点击,动画转换器可以根据需要设置
        mAutoBanner.load(mImgUrls).setOnAutoBannerListener(this).setAuto(3000).setAutoBannerAnimation(AccordionTransformer.class).display();


    }

    @Override
    public void onClickListener(int postion) {
        Toast.makeText(getContext(), "点击了：" + postion + "位置", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAutoBanner.startAuto();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAutoBanner.stopAuto();
    }
}
