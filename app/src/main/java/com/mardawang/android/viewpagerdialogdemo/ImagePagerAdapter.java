package com.mardawang.android.viewpagerdialogdemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

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

public class ImagePagerAdapter extends PagerAdapter {
    private List<View> views;

    public ImagePagerAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position), 0);
        //添加页卡
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position)); //删除页卡
    }

}
