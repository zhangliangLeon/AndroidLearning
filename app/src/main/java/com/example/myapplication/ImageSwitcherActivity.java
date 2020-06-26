package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImageSwitcherActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    private int picIndex;
    private float touchDownX;
    private float touchUpX;
    private int[] picArray = new int[]{R.mipmap.pic1,R.mipmap.pic2,R.mipmap.pic3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        imageSwitcher = findViewById(R.id.imageSwitcher);

        picIndex = 0;

        //为imageSwitcher设置viewFactory
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageSwitcherActivity.this);
                imageView.setImageResource(picArray[picIndex]);
                return imageView;
            }
        });


        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            /*
                onTouch方法返回false：
                    该点击事件被ontouch中的逻辑处理后就不会继续向下传递
                onTouch方法返回true:
                    该点击事件被ontouch中的逻辑处理后，会继续向下传递，
                    若后面存在onclick的监听事件就会继续执行onclick监听器中的逻辑
             */
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //按下手势
                    touchDownX = event.getX();
                    return true;
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //抬手手势

                    touchUpX = event.getX();

                    System.out.println("touchDownX == "+touchDownX+"\n");
                    System.out.println("touchUpX == "+touchUpX+"\n");
                    if(touchUpX - touchDownX > 100){
                        //向右滑动

                        //计算划动后要显示的图片的index
                        picIndex = picIndex == 0 ? picArray.length-1 : picIndex-1;

                        imageSwitcher.setInAnimation(
                                AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_in_left));
                        imageSwitcher.setOutAnimation(
                                AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_out_right));
                        imageSwitcher.setImageResource(picArray[picIndex]);
                    }else if(touchDownX - touchUpX >100){
                        //向左滑动
                        picIndex = picIndex == picArray.length-1 ? 0 : picIndex+1;

                        imageSwitcher.setInAnimation(
                                AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_in_right));
                        imageSwitcher.setOutAnimation(
                                AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_out_left));
                        imageSwitcher.setImageResource(picArray[picIndex]);
                    }
                    return  true;
                }
                return false;
            }
        });
    }
}
