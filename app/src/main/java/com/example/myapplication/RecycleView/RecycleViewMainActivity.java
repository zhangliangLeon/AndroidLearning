package com.example.myapplication.RecycleView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class RecycleViewMainActivity extends AppCompatActivity {

    private Button RecycleLinearViewButton ;
    private Button RectcleStaggerViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_main);

        RecycleLinearViewButton = findViewById(R.id.RecycleLinearViewButton);
        RecycleLinearViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewMainActivity.this, RecycleLinearViewActivity.class);
                startActivity(intent);
            }
        });

        RectcleStaggerViewButton = findViewById(R.id.RecycleStaggerViewButton);
        RectcleStaggerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewMainActivity.this,RecyclerViewStaggerActivity.class);
                startActivity(intent);
            }
        });
    }
}
