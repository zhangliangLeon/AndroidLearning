package com.example.myapplication.RecycleView_1.Stagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.myapplication.R;

public class StaggerRecycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger_recycle);

        recyclerView = findViewById(R.id.StaggerRecycleView);
        //设置布局管理器
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //设置适配器
        recyclerView.setAdapter(new StaggerAdaptor(this));
    }
}
