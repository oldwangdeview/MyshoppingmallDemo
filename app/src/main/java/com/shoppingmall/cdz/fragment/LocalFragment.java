package com.shoppingmall.cdz.fragment;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.adpater.Home_adpater;
import com.shoppingmall.cdz.adpater.Local_adpater;
import com.shoppingmall.cdz.base.BaseActivity;
import com.shoppingmall.cdz.base.BaseFragment;
import com.shoppingmall.cdz.util.UIUtils;
import com.shoppingmall.cdz.view.HeaderAndFooterWrapper;
import com.shoppingmall.cdz.view.RecommandDividerItemDecoration;
import com.shoppingmall.cdz.view.ScrollSpeedLinearLayoutManger;
import com.shoppingmall.cdz.view.YRecycleview;

import butterknife.BindView;

/**
 * Created by oldwang on 2019/1/22 0022.
 * 本地
 */

public class LocalFragment extends BaseFragment {
    @BindView(R.id.recycle_fragment_home)
    YRecycleview recycle_fragment_home;
    private Local_adpater mHome_adpater;
    private View mHeandView;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    @Override
    public View initView(Context context) {
        return UIUtils.inflate(mContext, R.layout.fragment_loal);
    }

    @Override
    protected void initData() {
        super.initData();
        mHeandView = UIUtils.inflate(mContext,R.layout.layout_head_local);

        recycle_fragment_home.setLayoutManager(new ScrollSpeedLinearLayoutManger(mContext));
        recycle_fragment_home.setItemAnimator(new DefaultItemAnimator());
        mHome_adpater = new Local_adpater(mContext, BaseActivity.gettestdata());
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mHome_adpater);
        mHeaderAndFooterWrapper.addHeaderView(mHeandView);

        recycle_fragment_home.setAdapter(mHeaderAndFooterWrapper);
    }
}
