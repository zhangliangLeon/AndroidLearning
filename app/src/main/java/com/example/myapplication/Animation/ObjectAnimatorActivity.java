package com.example.myapplication.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.TextView;

import com.example.myapplication.R;

//通过属性动画创建动画
public class ObjectAnimatorActivity extends AppCompatActivity {

    TextView testObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        testObject = findViewById(R.id.testObject);
        testObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = getResources().getDisplayMetrics().widthPixels;
                int height = getResources().getDisplayMetrics().heightPixels;
                //平移动画
                ObjectAnimator slid_toRight = ObjectAnimator.ofFloat(testObject,"translationX",0f,width-150);
                //旋转动画
                ObjectAnimator rotate = ObjectAnimator.ofFloat(testObject,"rotation",0f,360f);
                //平移动画
                ObjectAnimator slid_toButtom = ObjectAnimator.ofFloat(testObject,"translationY",0f,height-400);
                //渐变动画
                ObjectAnimator  alpha = ObjectAnimator.ofFloat(testObject,"alpha",1f,0f,0f,1f);
                //平移动画
                ObjectAnimator slid_toLeft = ObjectAnimator.ofFloat(testObject,"translationX",width-150,0f);
                //平移动画
                ObjectAnimator slid_toTop= ObjectAnimator.ofFloat(testObject,"translationY",height-400,0f);

                //创建一个动画集合
                AnimatorSet animatorSet = new AnimatorSet();
                //像动画集合中添加动画，动画会按照添加顺序执行
                animatorSet.playSequentially(slid_toRight,rotate,slid_toButtom,alpha,slid_toLeft,slid_toTop);
                //设置动画集合中每个动画的播放时长
                animatorSet.setDuration(1500);
                animatorSet.start();
            }
        });
    }
}
