package com.shoppingmall.cdz.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.shoppingmall.cdz.R;
import com.shoppingmall.cdz.bean.NoticeMessageBean;
import com.shoppingmall.cdz.util.StringUtils;
import com.shoppingmall.cdz.util.UIUtils;

import java.util.List;

/**
 * Author yichao
 * Time  2018/4/13 17:15
 * Dest  ${TODO}
 */

public class LooperTextView extends FrameLayout {
    /**  动画间隔  */
    private static final int ANIM_DELAYED_MILLIONS = 3 * 1000;
    /**  动画持续时长  */
    private static final int ANIM_DURATION = 1 * 700;
    /**  默认字体颜色  */
    private static final String DEFAULT_TEXT_COLOR = "#383838";

    private Animation anim_out, anim_in;
    private TextView tv_tip_out, tv_tip_in ;
    /**  循环播放的消息  */
    private List<NoticeMessageBean> tipList;
    /**  当前轮播到的消息索引  */
    private int curTipIndex = 0;
    private long lastTimeMillis ;

    public int getCurTipIndex() {
        return curTipIndex;
    }


    public LooperTextView(Context context) {
        this(context, null);
    }

    public LooperTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LooperTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTipFrame();
        initAnimation();
    }

    private void initTipFrame() {

        tv_tip_out = newTextView();
        tv_tip_in = newTextView();
        addView(tv_tip_in);
        addView(tv_tip_out);
    }

    /**
     *  设置要循环播放的信息
     * @param tipList
     */
    public void setTipList(List<NoticeMessageBean> tipList) {
        this.tipList = tipList;
        curTipIndex = 0;
        updateTip(tv_tip_out);
        updateTipAndPlayAnimation();
    }
    private void initAnimation() {
        anim_out = newAnimation(0, -1);
        anim_in = newAnimation(1, 0);
        anim_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                updateTipAndPlayAnimationWithCheck();
            }
        });
    }

    private void updateTipAndPlayAnimation() {
        if (curTipIndex % 2 == 0) {
            updateTip(tv_tip_out);
            tv_tip_in.startAnimation(anim_out);
            tv_tip_out.startAnimation(anim_in);
            this.bringChildToFront(tv_tip_in);
        } else {
            updateTip(tv_tip_in);
            tv_tip_out.startAnimation(anim_out);
            tv_tip_in.startAnimation(anim_in);
            this.bringChildToFront(tv_tip_out);
        }
    }

    private void updateTipAndPlayAnimationWithCheck() {
        if (System.currentTimeMillis() - lastTimeMillis < 1000 ) {
            return ;
        }
        lastTimeMillis = System.currentTimeMillis();
        updateTipAndPlayAnimation();
    }

    private void updateTip(TextView tipView) {
        String tip = getNextTip();
        if(!TextUtils.isEmpty(tip)) {
            tipView.setText(tip);
        }
    }

    /**
     *  获取下一条消息
     * @return
     */
    private String getNextTip() {
        if (isListEmpty(tipList)) return null;
        String content = "";
        if(StringUtils.isEmpty(tipList.get(curTipIndex % tipList.size()).getTitle())){
            content = tipList.get(curTipIndex % tipList.size()).getType() ;

        }else {
             content = tipList.get(curTipIndex % tipList.size()).getType() + "    |    " + tipList.get(curTipIndex % tipList.size()).getTitle();
        }
        curTipIndex++;
        return content;
    }
    private TextView newTextView(){
        TextView textView = new TextView(getContext());
        LayoutParams lp = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
        textView.setLayoutParams(lp);
        textView.setCompoundDrawablePadding(UIUtils.dip2px(10));
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(Color.parseColor(DEFAULT_TEXT_COLOR));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, UIUtils.px2dip(UIUtils.getDimens(R.dimen.sp_12)));
        return textView;
    }

    private Animation newAnimation(float fromYValue, float toYValue) {
        Animation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,fromYValue,Animation.RELATIVE_TO_SELF, toYValue);
        anim.setDuration(ANIM_DURATION);
        anim.setStartOffset(ANIM_DELAYED_MILLIONS);
        anim.setInterpolator(new DecelerateInterpolator());
        return anim;
    }

    /**
     *  将资源图片转换为Drawable对象
     * @param ResId
     * @return
     */
    private Drawable loadDrawable(int ResId) {
        Drawable drawable = getResources().getDrawable(ResId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth() - 10, drawable.getMinimumHeight() - 10);
        return drawable;
    }

    /**
     *  list是否为空
     * @param list
     * @return true 如果是空
     */
    public static boolean isListEmpty(List list) {
        return list == null || list.isEmpty();
    }
}
