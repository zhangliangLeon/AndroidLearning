package com.example.myapplication.ActionBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;


//本activity用于演示actionbar的开启与关闭
public class ActionBarTestActivity extends AppCompatActivity {

    private Button CloseActionbarButton;
    private Button OpenActionbarButton;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);

        CloseActionbarButton = findViewById(R.id.CloseActionbarButton);
        OpenActionbarButton =findViewById(R.id.OpenActionbarButton);

        actionBar = getSupportActionBar();

        CloseActionbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionBar.hide();
            }
        });
        OpenActionbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionBar.show();
            }
        });
    }
}
