package com.example.myapplication.FragmentLearning_new.newsclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

public class NewsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);

        //刚进入时只需要初始化NewslistFragment，因为还没有选择新闻，所以详情页为空
        getSupportFragmentManager().beginTransaction().add(R.id.news_list_area,new NewsListFragment()).commit();
    }
}