package com.example.myapplication.DiyViews.ActionBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class MyActionBar_1Activity extends LinearLayout {

    public MyActionBar_1Activity(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //LayoutInflater.from(context)创建一个LayoutInflater
        //inflate两个参数分别为 需要加载的布局，给加载好的布局添一个父布局
        LayoutInflater.from(context).inflate(R.layout.activity_my_action_bar_1,this);

        Button backButton = findViewById(R.id.backButton_1);
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
}