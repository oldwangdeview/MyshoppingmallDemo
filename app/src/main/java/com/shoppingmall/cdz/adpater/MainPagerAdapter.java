package com.shoppingmall.cdz.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shoppingmall.cdz.factory.MainFragmentFactory;


/**
 * Author yichao
 * Time  2017/11/30 9:34
 * Dest  主页
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragmentFactory.getFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
