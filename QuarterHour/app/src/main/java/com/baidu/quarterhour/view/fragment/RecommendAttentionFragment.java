package com.baidu.quarterhour.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.baidu.quarterhour.R;
import com.baidu.quarterhour.view.base.BaseFragment;
import com.baidu.quarterhour.view.base.BasePresenter;

/**
 * 推荐-->关注
 */

public class RecommendAttentionFragment extends BaseFragment {

    private ImageView attention_imageView;
    private RecyclerView attention_recycle_view;

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_attention_fragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        attention_imageView = view.findViewById(R.id.attention_imageView);
        attention_recycle_view = (RecyclerView) view.findViewById(R.id.attention_recycle_view);
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getDestory() {

    }
}
