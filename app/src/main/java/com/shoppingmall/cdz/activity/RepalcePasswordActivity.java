package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oldwang on 2019/1/26 0026.
 */

public class RepalcePasswordActivity extends BaseActivity {
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.view3)
    View view2;
    @BindView(R.id.password1)
    EditText password1;
    @BindView(R.id.view4)
    View view3;
    @BindView(R.id.login_btn)
    Button loginbtn;
    @BindView(R.id.tv_title_activity_baseperson)
    TextView title_name;
    public boolean islogin = false;
    @Override
    protected void initView() {
     setContentView(R.layout.activity_repalcepassword);
    }

    @Override
    protected void initData() {
        super.initData();
        title_name.setText("修改密码");
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
                String passwordatatow = password1.getText().toString().trim();
                if(!TextUtils.isEmpty(passworddata)){
                    view2.setBackgroundResource(R.color.c_168AE1);
                }else{
                    view2.setBackgroundResource(R.color.c_eeeeee);
                }
                if(!TextUtils.isEmpty(passworddata)&&!TextUtils.isEmpty(passwordatatow)&&passworddata.length()>6&&passworddata.equals(passwordatatow)){
                    loginbtn.setBackgroundResource(R.mipmap.btn_lan_login);
                    islogin = true;
                }else{
                    loginbtn.setBackgroundResource(R.drawable.shpe_loginbtn);
                    islogin = false;
                }
            }
        });
        password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String passworddata = password.getText().toString();
                String passwordatatow = password1.getText().toString().trim();
                if(!TextUtils.isEmpty(passworddata)){
                    view3.setBackgroundResource(R.color.c_168AE1);
                }else{
                    view3.setBackgroundResource(R.color.c_eeeeee);
                }
                if(!TextUtils.isEmpty(passworddata)&&!TextUtils.isEmpty(passwordatatow)&&passworddata.length()>6&&passworddata.equals(passwordatatow)){
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
     * 完成
     */
    @OnClick(R.id.login_btn)
    public void login(){
        if(!islogin){
            return;
        }

       finish();

    }

    @OnClick(R.id.iv_back_activity_basepersoninfo)
    public void finishactivity(){
        finish();
    }

    public static void startactivity(Context mCOntext){
        Intent mintent = new Intent(mCOntext,RepalcePasswordActivity.class);
        mCOntext.startActivity(mintent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getKeyCode()== KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
