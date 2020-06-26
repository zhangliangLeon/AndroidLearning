package com.example.myapplication.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleLinearViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_linear_view);

        List<String> TitleList = new ArrayList<>();
        List<String> ContentList = new ArrayList<>();
        List<Integer> Height = new ArrayList<>();
        for(int i=0 ; i<10 ; i++){
            String title = "Title_"+i;
            String content = "Content_"+i;
            Integer height = 80 + (int) Math.random()*300;
            TitleList.add(title);
            ContentList.add(content);
            Height.add(height);
        }

        RecycleLinearAdaptor adaptor = new RecycleLinearAdaptor(RecycleLinearViewActivity.this,TitleList,ContentList,Height);
        recyclerView = findViewById(R.id.RecycleLinearView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptor);

    }
}
