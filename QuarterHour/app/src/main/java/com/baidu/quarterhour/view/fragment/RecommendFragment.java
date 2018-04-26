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
    }

}
