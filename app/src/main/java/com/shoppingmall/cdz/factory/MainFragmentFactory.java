package com.shoppingmall.cdz.factory;

import android.support.v4.app.Fragment;

import com.shoppingmall.cdz.fragment.HomeFragment;
import com.shoppingmall.cdz.fragment.LocalFragment;
import com.shoppingmall.cdz.fragment.MyFragment;
import com.shoppingmall.cdz.fragment.ShopingFragment;

import java.util.HashMap;

/**
 * Created by oldwang on 2019/1/22 0022.
 */

public class MainFragmentFactory {
    public static String TAG="MainFragmentFactory";
    private static final int HOME_FRAGMENT = 0;
    private static final int LOAL_FRAGMENT = 1;
    private static final int GOODS_HOUSE = 2;
    private static final int MY_FRAMENT = 3;
    private static HashMap<Integer,Fragment> mMap=new HashMap();

    public static Fragment getFragment(int index) {
        Fragment fragment=null;
        if (mMap.containsKey(index)){
            fragment=   mMap.get(index);

        }else {
            switch (index) {
                case HOME_FRAGMENT:
                    fragment = new HomeFragment();
                    break;
                case LOAL_FRAGMENT:
                    fragment = new LocalFragment();
                    break;
                case GOODS_HOUSE:
                    fragment = new ShopingFragment();
                    break;
                case MY_FRAMENT:
                    fragment = new MyFragment();
                    break;
            }

            mMap.put(index,fragment);

        }
        return fragment;

    }

}
