package com.mardawang.android.viewpagerdialogdemo.transformer;

import android.support.v4.view.ViewPager;


/**
 * author mardawang
 * <p>
 * email:wy363681759@163.com
 * <p>
 * date: 06/11/2018
 * <p>
 * desc:
 */
public class MyTransformer {

    public static ViewPager.PageTransformer getMyTransformer(TransType type) {
        return getMyTransformer(type, -1000f);
    }

    public static ViewPager.PageTransformer getMyTransformer(TransType type, float maxValue) {
        ViewPager.PageTransformer transformer = null;
        switch (type) {
            case H3D://外侧3D旋转
                transformer = new PageTransformer3D(maxValue);
                break;
            case H3DINTO://内侧3D旋转
                transformer = new PageTransformer3DInTo(maxValue);
                break;
            case FADEIN://渐变
                transformer = new PageTransformerFadeIn(maxValue);
                break;
            case TANDEM://缩放
                transformer = new PageTransformerTandem(maxValue);
                break;
            case OVERLAP://重叠效果
                transformer = new PageTransformerOverlap(maxValue);
                break;
            case ARCROATE://扇形旋转
                transformer = new PageTransformerArcRoate();
                break;

        }
        return transformer;
    }
}


