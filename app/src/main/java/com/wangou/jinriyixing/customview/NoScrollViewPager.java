package com.wangou.jinriyixing.customview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends ViewPager {

    private boolean isCanScroll = false;

    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!isCanScroll){
            return false;
        }else {
            return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!isCanScroll){
            return false;
        }else {
            return super.onTouchEvent(ev);
        }
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }
}
