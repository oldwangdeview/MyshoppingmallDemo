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

public class Check_NewAppActivity extends BaseActivity {
    @BindView(R.id.tv_title_activity_baseperson)
    TextView tv_title_activity_baseperson;
    @Override
    protected void initView() {
         setContentView(R.layout.activity_checknewapp);
    }
    @Override
    protected void initData() {
        super.initData();
        tv_title_activity_baseperson.setText("检查更新");
    }

    public static void startactivity(Context mCOntext){
        Intent mIntent = new Intent(mCOntext,Check_NewAppActivity.class);
        mCOntext.startActivity(mIntent);
    }

    @OnClick(R.id.iv_back_activity_basepersoninfo)
    public void finishactivity(){
        finish();
    }
}
