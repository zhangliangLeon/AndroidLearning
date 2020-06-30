package com.example.myapplication.FragmentLearning_new.newsclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;

public class NewsDetailForOnePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DetailForOnePage","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail_for_one_page);


        //加载fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        //由于fragmentManager的事务提交后都不是立即执行的而是异步执行，所以需要添加executePendingTransactions立即执行等待事务
        fragmentManager.beginTransaction().add(R.id.news_detail_area,new NewsDetailFragment()).commit();
        fragmentManager.executePendingTransactions();


        //添加了fragment后还没有数据，需要找到fragment并赋值
        NewsDetailFragment fragment = ((NewsDetailFragment)getSupportFragmentManager().findFragmentById(R.id.news_detail_area));

        String title = "";
        String content = "";
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("title") != null)
            title = bundle.getString("title");
        if(bundle.getString("content") != null)
            content = bundle.getString("content");

        Log.d("DetailForOnePage","onCreate 开始refresh");
        fragment.refresh(title,content);
    }
    public static void actionStart(Context context,String title, String content){

        Log.d("DetailForOnePage","actionStart");
        Intent intent = new Intent(context,NewsDetailForOnePageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        bundle.putString("content",content);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}