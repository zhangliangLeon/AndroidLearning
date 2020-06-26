package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private Handler handler = new Handler();
    private Runnable task;
    private ArrayAdapter adapter;
    private ArrayList<String> content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);

        //找到控件
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        listView = findViewById(R.id.swipeRefreshListView);


        //设置content内容初值
        content = new ArrayList<String>();
        content.addAll(Arrays.asList("item1","item2","item3"));

        //初始化adapter
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,content);

        //给listview添加适配器
        listView.setAdapter(adapter);


        //设置线程任务
        task = new Runnable() {
            @Override
            public void run() {
                content.addAll(Arrays.asList("item4", "item5", "item6"));
                adapter.notifyDataSetChanged();               //更改适配器中的数据
                swipeRefreshLayout.setRefreshing(false);    //关闭刷新
            }
        };

        //为swipeRefreshLayout设置刷新事件相应
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(task,3000L); //延迟三秒钟执行task
            }
        });

        //为swipeRefreshLayout设置刷新进度条颜色
        //可以设置多种颜色，每次转圈颜色按照顺序显示
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimaryDark,R.color.colorPrimary);
    }
}
