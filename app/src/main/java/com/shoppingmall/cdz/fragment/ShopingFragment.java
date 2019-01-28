package com.shoppingmall.cdz.fragment;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.View;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.adpater.Local_adpater;
import com.shoppingmall.cdz.adpater.ShoppingAdpater;
import com.shoppingmall.cdz.base.BaseActivity;
import com.shoppingmall.cdz.base.BaseFragment;
import com.shoppingmall.cdz.util.UIUtils;
import com.shoppingmall.cdz.view.HeaderAndFooterWrapper;
import com.shoppingmall.cdz.view.MyGridView;
import com.shoppingmall.cdz.view.ScrollSpeedLinearLayoutManger;
import com.shoppingmall.cdz.view.YRecycleview;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oldwang on 2019/1/22 0022.
 * 商城
 */

public class ShopingFragment extends BaseFragment {
    @BindView(R.id.recycle_fragment_home)
    YRecycleview recycle_fragment_home;
    private Local_adpater mHome_adpater;
    private View mHeandView;
    private View mFootView;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    private ShoppingAdpater mShoppinageadpater;
    private MyGridView myGridView;
    @Override
    public View initView(Context context) {
        return UIUtils.inflate(mContext, R.layout.fragment_shopping);
    }

    @Override
    protected void initData() {
        super.initData();
        mHeandView = UIUtils.inflate(mContext,R.layout.layout_shoppinghead);
        mFootView =  UIUtils.inflate(mContext,R.layout.layout_footshopping);
        myGridView = mFootView.findViewById(R.id.mygridview);
        mShoppinageadpater = new ShoppingAdpater(mContext, BaseActivity.gettestdata());
        myGridView.setAdapter(mShoppinageadpater);
        recycle_fragment_home.setLayoutManager(new ScrollSpeedLinearLayoutManger(mContext));
        recycle_fragment_home.setItemAnimator(new DefaultItemAnimator());
        mHome_adpater = new Local_adpater(mContext, new ArrayList<String>());
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mHome_adpater);
        mHeaderAndFooterWrapper.addHeaderView(mHeandView);
        mHeaderAndFooterWrapper.addFootView(mFootView);
        recycle_fragment_home.setAdapter(mHeaderAndFooterWrapper);
    }
}