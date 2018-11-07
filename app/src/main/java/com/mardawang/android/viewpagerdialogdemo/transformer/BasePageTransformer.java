package com.mardawang.android.viewpagerdialogdemo.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;


public abstract class BasePageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View view, float position) {
        if (position < -1) { //页面不可见
            other(view, position);
        } else if (position < 0) {
            //页面可见，页面的左边界已经画出屏幕
            touch2Left(view, position);
        } else if (position < 1) {
            //页面可见，页面的左边界已经进入屏幕
            touch2Right(view, position);
        } else {//页面不可见
            other(view, position);
        }
    }

    public abstract void touch2Left(View view, float position);

    public abstract void touch2Right(View view, float position);

    public abstract void other(View view, float position);
}