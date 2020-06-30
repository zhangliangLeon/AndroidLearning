package com.example.myapplication.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ListView.Diff.DiffListViewActivity;
import com.example.myapplication.ListView.Simple.SimpleListViewActivity;
import com.example.myapplication.R;

public class ListViewMainActivity extends AppCompatActivity implements View.OnClickListener {

    Button SimpleListViewButton;
    Button DiffListViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);
        initView();
    }
    public void initView(){
        SimpleListViewButton = findViewById(R.id.SimpleListViewButton);
        SimpleListViewButton.setOnClickListener(this);
        DiffListViewButton = findViewById(R.id.DiffListViewButton);
        DiffListViewButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.SimpleListViewButton:
                intent = new Intent(ListViewMainActivity.this, SimpleListViewActivity.class);
                break;
            case R.id.DiffListViewButton:
                intent = new Intent(ListViewMainActivity.this, DiffListViewActivity.class);
                break;

        }
        startActivity(intent);
    }

}