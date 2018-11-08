package com.mardawang.android.viewpagerdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.mardawang.android.viewpagerdialogdemo.transformer.MyTransformer;
import com.mardawang.android.viewpagerdialogdemo.transformer.TransType;

import java.util.ArrayList;
import java.util.List;

/**
 * author mardawang
 * <p>
 * email:wy363681759@163.com
 * <p>
 * date: 06/11/2018
 * <p>
 * desc:
 */

public class PagerDialog extends Dialog {
    private int[] images;
    private ViewPager viewPager = null;
    int type = 0;
    TransType[] type_arr = {TransType.H3D,TransType.H3DINTO,TransType.FADEIN,TransType.TANDEM,TransType.OVERLAP,TransType.ARCROATE};


    public PagerDialog( Context context, int[] images,int type) {
        super(context, R.style.pagerDialog);
        this.images = images;
        this.type = type;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setWindowAnimations(R.style.popupAnimation);
        setContentView(R.layout.layout_dialog);
        viewPager =  findViewById(R.id.dialog_viewpager);
        viewPager.setAdapter(createAdapter());
        viewPager.setPageTransformer(true, MyTransformer.getMyTransformer(type_arr[type]));
        viewPager.setOffscreenPageLimit(images.length);
    }

    private PagerAdapter createAdapter() {

        List<View> views = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            final int j = i;
            ImageView[] mDots = new ImageView[images.length];
            int dp1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, getContext
                    ().getResources().getDisplayMetrics());
            int dp2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getContext
                    ().getResources().getDisplayMetrics());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dp1, dp1);

            View parent = LayoutInflater.from(getContext()).inflate(R.layout.item_pager, null);
            ImageView imageView =  parent.findViewById(R.id.imageView);
            LinearLayout dotsLayout =  parent.findViewById(R.id.dots_layout);
            Glide.with(getContext()).load(images[i]).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });


            if (images.length > 0 && images.length != 1) {
                for (int k = 0; k < images.length; k++) {
                    mDots[k] = new ImageView(getContext());
                    mDots[k].setBackgroundResource(R.drawable.dialog_dots_layout);
                    params.leftMargin = dp2;
                    params.rightMargin = dp2;
                    if (k == i) {
                        mDots[k].setSelected(true);
                    } else {
                        mDots[k].setSelected(false);
                    }
                    mDots[k].setLayoutParams(params);
                    dotsLayout.addView(mDots[k], k);
                }
            }
            views.add(parent);
        }
        return new ImagePagerAdapter(views);

    }

    @Override
    public void show() {
        if (images.length > 0) super.show();
    }
}
