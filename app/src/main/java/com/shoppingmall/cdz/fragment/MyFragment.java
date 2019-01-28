package com.shoppingmall.cdz.fragment;

import android.content.Context;
import android.view.View;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.activity.SetingActivity;
import com.shoppingmall.cdz.activity.UserInfoActivity;
import com.shoppingmall.cdz.base.BaseFragment;
import com.shoppingmall.cdz.util.UIUtils;

import butterknife.OnClick;

/**
 * Created by oldwang on 2019/1/22 0022.
 * 我的
 */

public class MyFragment extends BaseFragment {
    @Override
    public View initView(Context context) {
        return UIUtils.inflate(mContext, R.layout.fragment_my);
    }

    /**
     * 个人信息
     */
    @OnClick({R.id.userin_layout,R.id.heand_image,R.id.nickname})
    public void gotouserinfoactivity(){
        UserInfoActivity.startactivity(mContext);
    }

    /**
     * 设置
     */
    @OnClick(R.id.seting_image)
    public void gotosetingactivity(){SetingActivity.startactivity(mContext);}
}