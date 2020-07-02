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

        String title = "";
        String content = "";
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("title") != null)
            title = bundle.getString("title");
        if(bundle.getString("content") != null)
            content = bundle.getString("content");


        NewsDetailFragment fragment = NewsDetailFragment.getInstance(title,content);

        //加载fragment
        FragmentManager manager = getSupportFragmentManager();
        //由于fragmentManager的事务提交后都不是立即执行的而是异步执行，所以需要添加executePendingTransactions立即执行等待事务
        manager.beginTransaction().add(R.id.news_detail_area,fragment).commit();
        manager.executePendingTransactions();

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
