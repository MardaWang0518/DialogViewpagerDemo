package com.mardawang.android.viewpagerdialogdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv_show;
    private int[] imageList = new int[]{R.drawable.other,R.drawable.kobe01,R.drawable.kobe02,R.drawable.kobe03,R.drawable.kobe04 };
    private PagerDialog pagerDialog;
    private TextView mTv_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        mTv_show = findViewById(R.id.tv_show);
        mTv_content = findViewById(R.id.tv_content);
        mTv_content.setText("什么是曼巴精神？每个人有自己的答案。\nKobeBryant自己的解读是：passionate、obsessive、relentless" +
                "、resilient、fearless，热情，执着，严厉，回击和无惧，这五个关键词就是曼巴精神的内涵所在。\n\n" +
                "热情——科比认为，热情来自于爱，他说：我爱球的味道，我爱球鞋的味道。\n\n" +
                "执着——科比对于篮球、对于胜利都很执着。\n\n" +
                "严厉——科比严于律己也严于律人。\n\n" +
                "回击——科比职业生涯最后几年，受过几次大伤。每次他都有积极的态度回击伤病。\n\n" +
                "无惧——科比认为，一个人最大的恐惧，是来源于自己。不是外部的，不是超自然的，而是来自自己的。\n\n");
        mTv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagerDialog = new PagerDialog(MainActivity.this, imageList);
                pagerDialog.show();
            }
        });
    }


}
