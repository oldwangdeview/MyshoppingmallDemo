package com.shoppingmall.cdz.adpater;

import android.content.Context;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.base.BaseRecycleAdapter;
import com.shoppingmall.cdz.help.RecycleViewHolder;

import java.util.List;

/**
 * Created by oldwang on 2019/1/22 0022.
 */

public class Home_adpater extends BaseRecycleAdapter<String> {

    public Home_adpater(Context context, List<String> datas) {
        super(context, datas, R.layout.item_home);
    }

    @Override
    protected void setData(RecycleViewHolder holder, String o, int position) {

    }
}
