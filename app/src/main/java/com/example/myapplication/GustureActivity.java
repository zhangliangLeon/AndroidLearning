package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class GustureActivity extends AppCompatActivity{

    private ViewFlipper viewFlipper;
    private GestureDetector detector;
    private int[] pics = new int[]{R.mipmap.pic1,R.mipmap.pic2,R.mipmap.pic3};
    private final int distance = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gusture);

        viewFlipper = findViewById(R.id.viewFlipper_1);
        for(int i=0 ; i<pics.length ; i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(pics[i]);
            viewFlipper.addView(imageView);
        }


        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            //当触摸事件按下时触发
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }
            //用户手机在屏上按下，且为移动或者松开时触发
            @Override
            public void onShowPress(MotionEvent e) {

            }
            //用户一次抬起手，轻击抬起
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }
            //用户在屏幕上连续向上或者向下时触发
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }
            //用户在屏幕上长按
            @Override
            public void onLongPress(MotionEvent e) {

            }
            //用户手指在屏幕上划过时触发
            //第一个e为滑动路径起始信息，第二个e为滑动路径终点信息，后面两个参数为划过时在x轴和y轴上的速度
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if(e1.getX() - e2.getX() > distance){
                    //向左滑动且滑动距离大于最小滑动距离，可以触发向左切换图片
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(GustureActivity.this,R.anim.slide_in_right));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(GustureActivity.this,R.anim.slide_out_left));
                    viewFlipper.showNext();
                    return  true;
                }else if(e2.getX() - e1.getX() >distance){
                    //向右滑动且滑动距离大于最小滑动距离，可以触发向右切换图片
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(GustureActivity.this,R.anim.slide_in_left));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(GustureActivity.this,R.anim.slide_out_right));
                    viewFlipper.showPrevious();
                    return  true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将捕捉到的event交给detector
        return detector.onTouchEvent(event);
    }
}
