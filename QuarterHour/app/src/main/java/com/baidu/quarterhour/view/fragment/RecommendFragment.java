package com.baidu.quarterhour.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baidu.quarterhour.R;
import com.baidu.quarterhour.presenter.BannerPresenter;
import com.baidu.quarterhour.view.activity.IBannerView;
import com.baidu.quarterhour.view.api.Api;
import com.baidu.quarterhour.view.banner.AccordionTransformer;
import com.baidu.quarterhour.view.banner.AutoBanner;
import com.baidu.quarterhour.view.base.BaseFragment;
import com.baidu.quarterhour.view.bean.BannerSuperClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面
 */

public class RecommendFragment extends BaseFragment<BannerPresenter> implements IBannerView {
    /*private AutoBanner mAutoBanner;
    private List<String> mImgUrls;*/

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected BannerPresenter getPresenter() {
        presenter = new BannerPresenter(this);
        return presenter;
    }

    @Override
    protected void initView(View view) {
        /*mAutoBanner = (AutoBanner) view.findViewById(R.id.auto_banner);

        mImgUrls = new ArrayList<>();*/
    }

    @Override
    protected void getData() {
        presenter.banner(Api.HOST_NAME);
    }

    @Override
    protected void getDestory() {
        presenter.onDestrry();
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(List<BannerSuperClass.DataBean> data) {
        Toast.makeText(getContext(),data.size() + "---",Toast.LENGTH_LONG).show();

        /*if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                mImgUrls.add(data.get(i).getIcon());
            }

            //不设置setAuto，不会自动轮播，不设置监听，无法点击,动画转换器可以根据需要设置
            mAutoBanner.load(mImgUrls).setOnAutoBannerListener(this).setAuto(3000).setAutoBannerAnimation(AccordionTransformer.class).display();
        }*/
    }

    /*@Override
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
    }*/
}
