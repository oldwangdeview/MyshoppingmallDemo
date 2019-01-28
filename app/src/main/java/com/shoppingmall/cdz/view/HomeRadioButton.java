package com.shoppingmall.cdz.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.util.UIUtils;


/**
 * Author yichao
 * Time  2018/4/28 13:40
 * Dest  ${TODO}
 */

public class HomeRadioButton extends RadioButton {
    public HomeRadioButton(Context context) {
        this(context,null);
    }

    public HomeRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);


    }


    @Override
    public void setCompoundDrawables(@Nullable Drawable left, @Nullable Drawable top, @Nullable Drawable right, @Nullable Drawable bottom) {
        try {
        top.setBounds(0,0, UIUtils.getDimens(R.dimen.dp_22), UIUtils.getDimens(R.dimen.dp_22));
        }catch (Exception e){

        }
        super.setCompoundDrawables(left, top, right, bottom);
    }

    public HomeRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
