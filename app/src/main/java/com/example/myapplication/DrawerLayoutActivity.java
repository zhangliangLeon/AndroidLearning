package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Util.ToastUtil;

public class DrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        drawerLayout = findViewById(R.id.drawerlayout);
        listView = findViewById(R.id.drawerlayoutListView);

        String[] arr = new String[]{"item1","item2","item3"};
        //新建ArrayAdaptor适配器，该适配器为baseAdapter的派生类
        //其中第二参数为系统提供的适配样式，simple_list_item_1表示单独一行的文本框
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);

        //设置状态变化监听器
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            //当抽屉位置发生变化时
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            }

            //当抽屉打开时
            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                ToastUtil.showMsg(DrawerLayoutActivity.this,"打开抽屉");
            }

            //当抽屉关闭时
            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                ToastUtil.showMsg(DrawerLayoutActivity.this,"关闭抽屉");
            }

            //当抽屉状态改变时
            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }
}
