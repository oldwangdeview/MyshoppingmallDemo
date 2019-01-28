package com.shoppingmall.cdz.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.util.UIUtils;

import java.util.List;

/**
 * Created by oldwang on 2019/1/23 0023.
 */

public class ShoppingAdpater extends BaseAdapter {
    Context mContext;
    List<String> listdata;
    public ShoppingAdpater(Context mContext,List<String> listdata){
       this.mContext = mContext;
       this.listdata = listdata;
    }
    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = UIUtils.inflate(mContext, R.layout.item_goods);
        }
        return convertView;
    }
}
