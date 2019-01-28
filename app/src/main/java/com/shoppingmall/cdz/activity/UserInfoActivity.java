package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oldwang on 2019/1/26 0026.
 */

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.tv_title_activity_baseperson)
    TextView tv_title_activity_baseperson;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_userinfo);
    }

    @Override
    protected void initData() {
        super.initData();
        tv_title_activity_baseperson.setText("个人信息");
    }

    public static void startactivity(Context mContext){
        Intent mintent = new Intent(mContext,UserInfoActivity.class);
        mContext.startActivity(mintent);
    }
    @OnClick(R.id.iv_back_activity_basepersoninfo)
    public void finishactivity(){
        finish();
    }
}
