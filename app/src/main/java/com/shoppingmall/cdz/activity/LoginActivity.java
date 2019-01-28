package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Created by oldwang on 2019/1/19 0019.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_uagment)
    TextView login_uagment;//注册用户协议
    @BindView(R.id.phone_num)
    EditText phone_num;
    @BindView(R.id.code_num)
    EditText code_num;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.view_1)
    View view;
    @BindView(R.id.view2)
    View view1;
    @BindView(R.id.view3)
    View view2;
    @BindView(R.id.login_btn)
    Button loginbtn;
    @BindView(R.id.ts)
    TextView ts;
    @BindView(R.id.seepassword)
    ImageView seepasswordimage;
    public  boolean seepassword =false;
    public boolean islogin = false;

    private String color = "<font color=\"#168AE1\">";
    private String wb = "</font>";
    @Override
    protected void initView() {
    setContentView(R.layout.activity_login);
    }

    public static void startactivity(Context mContext){
        Intent mintext = new Intent(mContext,LoginActivity.class);
        mContext.startActivity(mintext);
    }

    @OnClick(R.id.return_btn)
    public void finishactivty(){
        finish();
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        String content = "点击立即进入即"+"同意"+color+"用户协议"+wb+"和"+color+"隐私协议"+wb;
        login_uagment.setText(Html.fromHtml(content));
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
             String passdata = password.getText().toString().trim();
             if(!TextUtils.isEmpty(phonenum)){
                 view.setBackgroundResource(R.color.c_168AE1);
             }else{
                 view.setBackgroundResource(R.color.c_eeeeee);
             }

             if(!TextUtils.isEmpty(phonenum)&&!TextUtils.isEmpty(passdata)){
                 loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                 islogin = true;
             }else{
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
              if(!TextUtils.isEmpty(code)){
                  view1.setBackgroundResource(R.color.c_168AE1);
              }else{
                  view1.setBackgroundResource(R.color.c_eeeeee);
              }
            }
        });


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
              String passworddata = password.getText().toString();
              String phone_numdata = phone_num.getText().toString().trim();
              if(!TextUtils.isEmpty(passworddata)){
                  view2.setBackgroundResource(R.color.c_168AE1);
              }else{
                  view2.setBackgroundResource(R.color.c_eeeeee);
              }
              if(!TextUtils.isEmpty(phone_numdata)&&!TextUtils.isEmpty(passworddata)){
                  loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                  islogin = true;
              }else{
                  loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                  islogin = false;
              }
            }
        });
    }

    /**
     * 注册登陆
     */
    @OnClick(R.id.login_btn)
    public void login(){
        if(!islogin){
            return;
        }
        String phone_numdata = phone_num.getText().toString().trim();
        String codedeta = code_num.getText().toString().trim();
        String passworddata = password.getText().toString().trim();
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
        MainActivity.startactivity(this);
    }

    /**
     * 获取验证码
     */
    @OnClick(R.id.getcode)
    public void getcode(){

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void finishthisactivity(FinishLoginAndRejest_Event event){
        finish();
    }

    @OnClick(R.id.seepassword)
    public void seepassword(){
        if(seepassword){

            seepasswordimage.setImageResource(R.mipmap.seepassword);
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else{
            seepasswordimage.setImageResource(R.mipmap.notseepassword);
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        seepassword = !seepassword;
    }

    @OnClick(R.id.login_info)
    public void gotologin_info(){
        Login_infoActivity.startactivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        UIUtils.showFullScreen(LoginActivity.this,false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
//        UIUtils.showFullScreen(LoginActivity.this,true);
    }


    /**
     * 用户协议
     */
    @OnClick(R.id.login_uagment)
    public void gotousercontent(){
          UseragemeetActivity.startactivity(this);
          finish();
    }

}
