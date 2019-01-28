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

public class SetPasswordActivity extends BaseActivity {
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.view3)
    View view2;
    @BindView(R.id.seepassword)
    ImageView seepasswordimage;
    @BindView(R.id.login_btn)
    Button loginbtn;
    @BindView(R.id.tv_title_activity_baseperson)
    TextView title_name;
    public  boolean seepassword =false;
    public boolean islogin = false;
    @Override
    protected void initView() {
          setContentView(R.layout.activity_setpassword);
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        title_name.setText("设置密码");
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

                if(!TextUtils.isEmpty(passworddata)){
                    view2.setBackgroundResource(R.color.c_168AE1);
                }else{
                    view2.setBackgroundResource(R.color.c_eeeeee);
                }
                if(!TextUtils.isEmpty(passworddata)&&passworddata.length()>6){
                    loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                    islogin = true;
                }else{
                    loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                    islogin = false;
                }
            }
        });
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

    /**
     * 完成
     */
    @OnClick(R.id.login_btn)
    public void login(){
        if(!islogin){
            return;
        }

        String passworddata = password.getText().toString().trim();
        LoginActivity.startactivity(this);
    }

    @OnClick(R.id.iv_back_activity_basepersoninfo)
    public void finishactivity(){
        finish();
    }

    public static void startactivity(Context mCOntext){
        Intent mintent = new Intent(mCOntext,SetPasswordActivity.class);
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
