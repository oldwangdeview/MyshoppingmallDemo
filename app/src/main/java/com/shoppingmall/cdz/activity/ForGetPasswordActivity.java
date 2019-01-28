package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.base.BaseActivity;
import com.shoppingmall.cdz.eventbus.FinishLoginAndRejest_Event;
import com.shoppingmall.cdz.util.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oldwang on 2019/1/21 0021.
 */

public class ForGetPasswordActivity extends BaseActivity {
    @BindView(R.id.tv_title_activity_baseperson)
    TextView title_name;
    @BindView(R.id.phone_num)
    EditText phone_num;
    @BindView(R.id.code_num)
    EditText code_num;
    @BindView(R.id.view_1)
    View view;
    @BindView(R.id.view2)
    View view1;
    @BindView(R.id.ts)
    TextView ts;
    @BindView(R.id.login_btn)
    Button loginbtn;
    public boolean islogin = false;
    @Override
    protected void initView() {
       setContentView(R.layout.activity_forgrtpassword);
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        title_name.setText("忘记密码");
        phone_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ts.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
                String phonenum = phone_num.getText().toString().trim();
                String code = code_num.getText().toString().trim();

                if(!TextUtils.isEmpty(phonenum)){
                    view.setBackgroundResource(R.color.c_168AE1);
                }else{
                    view.setBackgroundResource(R.color.c_eeeeee);
                }


                    if(!TextUtils.isEmpty(phonenum)&&!TextUtils.isEmpty(code)){
                        loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                        islogin = true;
                    }else {
                        loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                        islogin = false;
                    }

            }
        });

        code_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ts.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
                String code = code_num.getText().toString().trim();
                String phonenum = phone_num.getText().toString().trim();
                if(!TextUtils.isEmpty(code)){
                    view1.setBackgroundResource(R.color.c_168AE1);
                }else{
                    view1.setBackgroundResource(R.color.c_eeeeee);
                }
                if(!TextUtils.isEmpty(phonenum)&&!TextUtils.isEmpty(code)){
                    loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                    islogin = true;
                }else {
                    loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                    islogin = false;
                }
            }
        });
    }

    /**
     * 按钮点击下一步
     */
    @OnClick(R.id.login_btn)
    public void netdata(){


        if(!islogin){
            return;
        }
        String phone_numdata = phone_num.getText().toString().trim();
        String codedeta = code_num.getText().toString().trim();
        ts.setVisibility(View.VISIBLE);
        if(!UIUtils.isPhoneNumber(phone_numdata)){
            //请输入正确的手机号
            ts.setText("请输入正确的手机号");
            return ;
        }

        if(TextUtils.isEmpty(codedeta)){
            //请输入验证码
            ts.setText("请输入验证码");
            return;
        }

        SetPasswordActivity.startactivity(this);

    }


    @OnClick(R.id.iv_back_activity_basepersoninfo)
    public void finishactivity(){
        finish();
    }


    public static void startactivty(Context mCOntext){
        Intent mintent = new Intent(mCOntext,ForGetPasswordActivity.class);
        mCOntext.startActivity(mintent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void finishthisactivity(FinishLoginAndRejest_Event event){
        finish();
    }

}
