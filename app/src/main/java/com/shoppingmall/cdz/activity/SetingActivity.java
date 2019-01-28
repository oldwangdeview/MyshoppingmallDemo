package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.base.BaseActivity;
import com.shoppingmall.cdz.contans.Contans;
import com.shoppingmall.cdz.eventbus.FinishMainActivity_Event;
import com.shoppingmall.cdz.util.DataCleanManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oldwang on 2019/1/26 0026.
 */

public class SetingActivity extends BaseActivity {
    @BindView(R.id.tv_title_activity_baseperson)
    TextView tv_title_activity_baseperson;
    @BindView(R.id.gc_data)
    TextView gc_data;
    @Override
    protected void initView() {
            setContentView(R.layout.activity_seting);
    }

    @Override
    protected void initData() {
        super.initData();
        tv_title_activity_baseperson.setText("设置");
        try {
            gc_data.setText(DataCleanManager.getTotalCacheSize(SetingActivity.this));
        }catch (Exception e){

        }
    }

    public static void startactivity(Context mCOntext){
        Intent mIntent = new Intent(mCOntext,SetingActivity.class);
        mCOntext.startActivity(mIntent);
    }

    @OnClick(R.id.iv_back_activity_basepersoninfo)
    public void finishactivity(){
        finish();
    }

    /**
     * 检查更新
     */
    @OnClick(R.id.checknewapp_layout)
    public void gotoChecknewApp(){
        Check_NewAppActivity.startactivity(this);
    }
    /**
     * 更换手机号
     */
    @OnClick(R.id.change_phonenum_layout)
    public void gotochangephonenum(){
        BandingPhoneActivity.startactivity(this, Contans.rows);
    }

    /**
     * 退出登录
     */
    @OnClick(R.id.login_out_btn)
    public void login_out(){
        EventBus.getDefault().post(new FinishMainActivity_Event());
        Login_infoActivity.startactivity(this,Contans.cow);
        finish();
    }

    /**
     * 清除缓存
     */
    @OnClick(R.id.clcen_gcdata)
    public void clecn_gcdata(){
        AlertView alertView = new AlertView("提示", "确定清除缓存", null, null, new String[]{"取消", "确定"}, this, AlertView.Style.Alert, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                if (position==1){
                    DataCleanManager.clearAllCache(SetingActivity.this);
                    try {
                        gc_data.setText(DataCleanManager.getTotalCacheSize(SetingActivity.this));
                    } catch (Exception e) {

//                        mItenmyviewCleanBufferActiviytSet.setDetails("0k");
                    }
                }

            }
        });
        alertView.show();
    }
    @OnClick(R.id.add_goodspath)
    public void setgoodpath()
    {
        AlertView alertView = new AlertView("", "你还没有添加收货地址喔～", null, null, new String[]{"取消", "确定"}, this, AlertView.Style.Alert, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                if (position==1){
                    DataCleanManager.clearAllCache(SetingActivity.this);
                    try {
//                        gc_data.setText(DataCleanManager.getTotalCacheSize(SetingActivity.this));
                    } catch (Exception e) {

//                        mItenmyviewCleanBufferActiviytSet.setDetails("0k");
                    }
                }

            }
        });
        alertView.show();
    }


    @OnClick(R.id.repalce_password)
    public void gotorepalcepassword(){
        RepalcePasswordActivity.startactivity(this);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getKeyCode()== KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
