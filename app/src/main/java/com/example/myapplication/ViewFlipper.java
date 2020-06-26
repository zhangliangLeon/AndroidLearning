package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;

public class ViewFlipper extends AppCompatActivity {

    private android.widget.ViewFlipper viewFlipper;
    private boolean isStart = false;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.setInAnimation(
                AnimationUtils.loadAnimation(ViewFlipper.this,R.anim.slide_in_left));
        viewFlipper.setOutAnimation(
                AnimationUtils.loadAnimation(ViewFlipper.this,R.anim.slide_out_right));


        viewFlipper.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    isStart = isStart == true ? false : true;
                    if(isStart == true){
                        //开启自动播放
                        viewFlipper.setAutoStart(true);
                        //启动控件切换
                        viewFlipper.startFlipping();
                    }else{
                        viewFlipper.stopFlipping();
                        viewFlipper.setAutoStart(false);
                    }
                }
                return true;
            }
        });



    }
}
