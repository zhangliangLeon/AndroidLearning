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
    private List<item> list = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_linear_view);
        initData();

        recyclerView =findViewById(R.id.RecycleLinearView);
        RecycleLinearAdaptor adaptor = new RecycleLinearAdaptor(RecycleLinearViewActivity.this,list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adaptor);
    }
    private void initData(){
        for(int i=0 ; i<5 ; i++){
            item item = new item(R.drawable.lion,"title_"+i,"content_"+i);
            list.add(item);
        }
    }
}
