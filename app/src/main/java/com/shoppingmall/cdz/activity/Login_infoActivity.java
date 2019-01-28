package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.base.BaseActivity;
import com.shoppingmall.cdz.contans.Contans;
import com.shoppingmall.cdz.eventbus.FinishLoginAndRejest_Event;
import com.shoppingmall.cdz.util.UIUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oldwang on 2019/1/20 0020.
 */

public class Login_infoActivity extends BaseActivity {
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

    @BindView(R.id.passlogin)
    TextView passlogin;
    @BindView(R.id.forget_password)
    TextView forget_password;

    @BindView(R.id.code_layout)
    RelativeLayout code_layout;
    @BindView(R.id.password_layout)
    RelativeLayout passwordlayout;
    public boolean islogin = false;
    public boolean passwordlogin = false;
    private int type = -1;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_logininfo);
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        type = getIntent().getIntExtra(Contans.INTENT_TYPE,-1);
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
                String passworddata = password.getText().toString().trim();
                if(!TextUtils.isEmpty(phonenum)){
                    view.setBackgroundResource(R.color.c_168AE1);
                }else{
                    view.setBackgroundResource(R.color.c_eeeeee);
                }

                if(passwordlogin){
                    if(!TextUtils.isEmpty(phonenum)&&!TextUtils.isEmpty(passworddata)){
                        loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                        islogin = true;
                    }else if(passwordlogin){
                        loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                        islogin = false;
                    }
                }else {
                    if (!TextUtils.isEmpty(phonenum) && !TextUtils.isEmpty(code)) {
                        loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                        islogin = true;
                    } else {
                        loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                        islogin = false;
                    }
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
                }else  if(!passwordlogin){
                    loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                    islogin = false;
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
                }else if(passwordlogin){
                    loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                    islogin = false;
                }
            }
        });

    }

    /**
     * 结束当前界面
     */
    @OnClick({R.id.return_btn})
    public void finfish(){
        finish();
    }

    @OnClick(R.id.login_activity)
    public void gotologinactivity(){
        if(type>1){
            LoginActivity.startactivity(this);
            finish();
        }else{
            finish();
        }
    }

    @OnClick(R.id.passlogin)
    public void passwordloginAndcodelogin(){
        if(passwordlogin){
            passlogin.setText("账号密码登陆");
            passwordlayout.setVisibility(View.GONE);
            view2.setVisibility(View.GONE);
            forget_password.setVisibility(View.GONE);
            code_layout.setVisibility(View.VISIBLE);
            view1.setVisibility(View.VISIBLE);
        }else{
            passlogin.setText("快捷登录");
            code_layout.setVisibility(View.GONE);
            view1.setVisibility(View.GONE);
            passwordlayout.setVisibility(View.VISIBLE);
            view2.setVisibility(View.VISIBLE);
            forget_password.setVisibility(View.VISIBLE);
        }
        passwordlogin = !passwordlogin;
    }

//
//    @OnClick(R.id.forget_password)
//    public void forgetpassword(){
//
//    }

    @BindView(R.id.seepassword)
    ImageView seepasswordimage;
    public  boolean seepassword =false;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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

    @OnClick(R.id.forget_password)
    public void gotoforgetpassword(){
        if(passwordlogin){
            ForGetPasswordActivity.startactivty(this);
        }
    }
    @OnClick(R.id.login_wechart)
    public void gotobangdingphone(){

        UMShareAPI.get(Login_infoActivity.this).getPlatformInfo(Login_infoActivity.this, SHARE_MEDIA.WEIXIN, authListener);
        BandingPhoneActivity.startactivty(this);
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }
        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(Login_infoActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }
        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(Login_infoActivity.this, "失败：" + t.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(Login_infoActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    public static void startactivity(Context mContext){
        Intent mintent = new Intent(mContext,Login_infoActivity.class);
        mContext.startActivity(mintent);
    }
    public static void startactivity(Context mContext,int type){
        Intent mintent = new Intent(mContext,Login_infoActivity.class);
        mintent.putExtra(Contans.INTENT_TYPE,type);
        mContext.startActivity(mintent);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void finishthisactivity(FinishLoginAndRejest_Event event){
        finish();
    }

}
