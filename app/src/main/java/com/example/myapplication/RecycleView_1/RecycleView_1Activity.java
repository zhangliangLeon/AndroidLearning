package com.example.myapplication.RecycleView_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.RecycleView_1.Grid.GridRecycleActivity;
import com.example.myapplication.RecycleView_1.Linear.LinearRecycleActivity;
import com.example.myapplication.RecycleView_1.Stagger.StaggerRecycleActivity;

public class RecycleView_1Activity extends AppCompatActivity {

    private Button LinearRecycleView_1Button;
    private Button StaggerRecycleView_1Button;
    private Button GridRecycleView_1Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_1);

        LinearRecycleView_1Button = findViewById(R.id.LinearRecycleView_1Button);
        LinearRecycleView_1Button.setOnClickListener(new click());

        GridRecycleView_1Button = findViewById(R.id.GridRecycleView_1Button);
        GridRecycleView_1Button.setOnClickListener(new click());

        StaggerRecycleView_1Button = findViewById(R.id.StaggerRecycleView_1Button);
        StaggerRecycleView_1Button.setOnClickListener(new click());

    }
    class click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent;
            switch(v.getId()){
                case R.id.LinearRecycleView_1Button:
                    intent = new Intent(RecycleView_1Activity.this, LinearRecycleActivity.class);
                    startActivity(intent);
                    break;
                case R.id.GridRecycleView_1Button:
                    intent = new Intent(RecycleView_1Activity.this, GridRecycleActivity.class);
                    startActivity(intent);
                    break;
                case R.id.StaggerRecycleView_1Button:
                    intent = new Intent(RecycleView_1Activity.this, StaggerRecycleActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
