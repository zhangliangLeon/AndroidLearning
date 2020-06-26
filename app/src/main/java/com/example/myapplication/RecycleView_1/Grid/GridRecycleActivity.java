package com.example.myapplication.RecycleView_1.Grid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

public class GridRecycleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle);

        recyclerView = findViewById(R.id.GridReCycleView);
        //设置布局管理器
        RecyclerView.LayoutManager gridManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridManager);
        //设置适配器
        recyclerView.setAdapter(new GridAdapter(this));

    }
}
