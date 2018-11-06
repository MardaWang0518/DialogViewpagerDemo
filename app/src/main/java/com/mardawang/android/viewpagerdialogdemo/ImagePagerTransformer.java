package com.mardawang.android.viewpagerdialogdemo;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * author mardawang
 * <p>
 * email:wy363681759@163.com
 * <p>
 * date: 06/11/2018
 * <p>
 * desc:
 */

public class ImagePagerTransformer implements ViewPager.PageTransformer {

    private static final float ROX_MAX = 20.0f;
    private float mRox;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            ViewCompat.setRotation(page, 0);

        } else if (position < 0) {
            mRox = (position * ROX_MAX);
            ViewCompat.setPivotX(page, page.getMeasuredWidth());
            ViewCompat.setPivotY(page, page.getMeasuredHeight());
            ViewCompat.setRotation(page, mRox);
        } else if (position < 1) {
            mRox = (position * ROX_MAX);
            ViewCompat.setPivotX(page, 0);
            ViewCompat.setPivotY(page, page.getMeasuredHeight());
            ViewCompat.setRotation(page, mRox);
        } else

        { //页面不可见
            ViewCompat.setRotation(page, 0);
        }
    }
}

