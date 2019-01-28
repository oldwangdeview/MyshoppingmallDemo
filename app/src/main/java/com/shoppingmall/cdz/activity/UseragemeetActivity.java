package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.TextView;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oldwang on 2019/1/21 0021.
 */

public class UseragemeetActivity extends BaseActivity {
    @BindView(R.id.tv_title_activity_baseperson)
    TextView title_name;

    @BindView(R.id.content)
    TextView content;

    @Override
    protected void initView() {
          setContentView(R.layout.activity_useragement);
    }

    @Override
    protected void initData() {
        super.initData();
        title_name.setText("用户协议");
        content.setText("用户协议内容");

    }

    @OnClick(R.id.iv_back_activity_basepersoninfo)
    public void finishactivity(){
        finish();
    }

    public static void startactivity(Context mCOntext){
        Intent mintent = new Intent(mCOntext,UseragemeetActivity.class);
        mCOntext.startActivity(mintent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }
}
