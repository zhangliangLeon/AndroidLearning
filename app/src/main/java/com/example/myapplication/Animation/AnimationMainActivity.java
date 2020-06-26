package com.example.myapplication.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.myapplication.R;

public class AnimationMainActivity extends AppCompatActivity {

    Button testRotate ;
    Button testScale;
    Button testTranslate;
    Button testAlpha;
    Button testObjectAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_main);

        testRotate = findViewById(R.id.testRotate);
        testRotate.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));

        testScale = findViewById(R.id.testScale);
        testScale.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));

        testTranslate = findViewById(R.id.testTranslate);
        testTranslate.setAnimation(AnimationUtils.loadAnimation(this,R.anim.traslate));

        testAlpha = findViewById(R.id.testAlpha);
        testAlpha.setAnimation(AnimationUtils.loadAnimation(this,R.anim.alpha));

        testObjectAnimator = findViewById(R.id.testObjectAnimator);
        testObjectAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimationMainActivity.this,ObjectAnimatorActivity.class);
                startActivity(intent);
            }
        });
    }

}
