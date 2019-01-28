package com.shoppingmall.cdz.activity;

import android.Manifest;
import android.content.Intent;
import android.view.View;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.util.CheckPermission;

import com.shoppingmall.cdz.base.BaseActivity;
import com.shoppingmall.cdz.contans.Contans;

import com.shoppingmall.cdz.util.UIUtils;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/12/25 0025.
 */

public class FalshActivity extends BaseActivity{

//    @BindView(R.id.back_image)
//    View image;
    static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
            Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
            Manifest.permission.CAMERA,//相机
            Manifest.permission.RECORD_AUDIO,//相机
            Manifest.permission.ACCESS_COARSE_LOCATION,//定位
            Manifest.permission.ACCESS_FINE_LOCATION,//定位
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE

    };
    @Override
    protected void initView() {
        UIUtils.inflate(this, R.layout.layout_backmain);

    }

    @Override
    protected void initData() {
        super.initData();

        if (!UIUtils.isMarshmallow()) {
            LoginActivity.startactivity(this);
//            image.setVisibility(View.GONE);
            finish();
        } else {
            CheckPermission checkPermission = new CheckPermission(this);
            if (checkPermission.permissionSet(PERMISSION)) {
//                startPermissionActivity();
//                image.setVisibility(View.VISIBLE);
                PermissionActivity.startActivityForResult(this, Contans.PERMISSION_REQUST_COND, PERMISSION);
            } else {
//                image.setVisibility(View.GONE);
                LoginActivity.startactivity(this);
                finish();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Contans.PERMISSION_REQUST_COND) {
            if (resultCode == PermissionActivity.PERMISSION_DENIEG) {
;
                finish();
            } else if (resultCode == PermissionActivity.PERMISSION_GRANTED) {
                //有权限

                LoginActivity.startactivity(this);
                finish();
            }
        }
    }

}
