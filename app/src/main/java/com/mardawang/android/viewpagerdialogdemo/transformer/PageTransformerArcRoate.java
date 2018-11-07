package com.mardawang.android.viewpagerdialogdemo.transformer;

import android.view.View;

/**
 * 扇形旋转效果
 */
public class PageTransformerArcRoate extends BasePageTransformer {
    private static final float ROX_MAX = 20.0f;
    private float mRox;

    public PageTransformerArcRoate() {
    }

    @Override
    public void touch2Left(View view, float position) {

        mRox = (position * ROX_MAX);
        view.setPivotX( view.getMeasuredWidth());
        view.setPivotY( view.getMeasuredHeight());
        view.setRotation( mRox);

    }

    @Override
    public void touch2Right(View view, float position) {
        mRox = (position * ROX_MAX);
        view.setPivotX( 0);
        view.setPivotY( view.getMeasuredHeight());
        view.setRotation( mRox);

    }

    @Override
    public void other(View view, float position) {
        //view.setScaleX(mMaxScale);
       // view.setScaleY(mMaxScale);
        view.setRotation( 0);
    }

}