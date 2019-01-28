package com.shoppingmall.cdz.view;


import android.content.Context;
import android.graphics.Color;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

/**
 * Author yichao
 * Time  2018/4/3 15:48
 * Dest  商品推荐
 */

public class RecommandDividerItemDecoration extends Y_DividerItemDecoration {
    public RecommandDividerItemDecoration(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        Y_Divider divider=null;

    divider = new Y_DividerBuilder()
            .setRightSideLine(true, Color.rgb(246,246,246), 12, 0, 0)
            .setBottomSideLine(true,  Color.rgb(246,246,246), 12, 0, 0)
            .create();

        return divider;
    }
}
