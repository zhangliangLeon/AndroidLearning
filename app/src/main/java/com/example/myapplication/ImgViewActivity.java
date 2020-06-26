package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImgViewActivity extends AppCompatActivity {

    ImageView ImgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_view);
        ImgView = findViewById(R.id.imgView_4);
        String imgUrl = "https://www.baidu.com/img/PCpad_bc531b595cf1e37c3907d14b69e3a2dd.png";
        Glide.with(this).load(imgUrl).into(ImgView);
    }
}
