package com.example.myapplication.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class ListViewItemActivity extends AppCompatActivity {

    private ImageView ImgView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_item);
        ImgView = findViewById(R.id.ListViewItemImg);
        String imgUrl = "https://www.baidu.com/img/PCpad_bc531b595cf1e37c3907d14b69e3a2dd.png";
        Glide.with(this).load(imgUrl).into(ImgView);
    }
}
