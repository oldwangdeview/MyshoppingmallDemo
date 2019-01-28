package com.shoppingmall.cdz.activity;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.adpater.MainPagerAdapter;
import com.shoppingmall.cdz.base.BaseActivity;
import com.shoppingmall.cdz.eventbus.FinishLoginAndRejest_Event;
import com.shoppingmall.cdz.eventbus.FinishMainActivity_Event;
import com.shoppingmall.cdz.util.LogUntil;
import com.shoppingmall.cdz.util.UIUtils;
import com.shoppingmall.cdz.view.ForbidScrollViewpager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.viewpager_activity_main)
    public ForbidScrollViewpager mViewPager;
    @BindView(R.id.rg_tab_bar)
    public RadioGroup mRadioGroup;
    @BindView(R.id.rb_shoping)
    RadioButton mshoping;
    @BindView(R.id.rb_addmessage)
    RadioButton maddmessage;
    @BindView(R.id.re_local)
    RadioButton mlocaldata;
    @BindView(R.id.rb_my)
    RadioButton mRbMy;
    @BindView(R.id.rb_home)
    RadioButton mHome;
    private MainPagerAdapter mMainPagerAdapter;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new FinishLoginAndRejest_Event());
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(mMainPagerAdapter);
        mViewPager.setCurrentItem(0);
        mHome.setChecked(true);
        UIUtils.showFullScreen(MainActivity.this,true);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                UIUtils.showFullScreen(MainActivity.this,true);
//                updateactionbar();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.Iv_home_bg)
    public void addmessage(){

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void initEvent() {
        mRadioGroup.setOnCheckedChangeListener(this);


    }
    public static void startactivity(Context mContext){
        Intent mintent = new Intent(mContext,MainActivity.class);
        mContext.startActivity(mintent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void finishthisactivity(FinishMainActivity_Event event){
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                mViewPager.setCurrentItem(0, false);
                new LogUntil(this,TAG,0+"");
                break;
            case R.id.re_local:
                mViewPager.setCurrentItem(1, false);
                new LogUntil(this,TAG,1+"");
                new LogUntil(this,TAG,1+"");
                break;

            case R.id.rb_addmessage:

                break;

            case R.id.rb_shoping:
                mViewPager.setCurrentItem(2, false);
                new LogUntil(this,TAG,2+"");
                break;
            case R.id.rb_my:
                mViewPager.setCurrentItem(3, false);
                new LogUntil(this,TAG,3+"");
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
