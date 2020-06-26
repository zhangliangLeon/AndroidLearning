package com.example.myapplication.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewStaggerActivity extends AppCompatActivity {

    private RecyclerView view ;
    private ArrayList<String> contentList;
    private ArrayList<Integer> heightList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_stagger);

        view = findViewById(R.id.RecyclerStaggerView);
        //初始化数据
        InitData();
        //设置layoutManager
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        //设置Adapter
        view.setAdapter(new RecycleViewStaggerAdaptor(this,contentList,heightList));

    }
    private void InitData(){
        contentList = new ArrayList<>();
        heightList = new ArrayList<>();
        for(int i=0 ; i<20 ; i++){
            contentList.add("Content_" + i);
            Integer height = 80 + (int)(Math.random()*300);
            heightList.add(height);
        }
    }
}
