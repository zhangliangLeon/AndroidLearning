package com.example.myapplication.ActionBar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ActionBarMainActivity extends AppCompatActivity {

    private Button ActionbarButton;
    private Button ActionbarActionItemButton;
    private Button ActionBarBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_main);

        ActionbarButton = findViewById(R.id.ActionbarButton);
        ActionbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionBarMainActivity.this,ActionBarTestActivity.class);
                startActivity(intent);
            }
        });

        ActionbarActionItemButton = findViewById(R.id.ActionbarActionItemButton);
        ActionbarActionItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionBarMainActivity.this,ActionItemActivity.class);
                startActivity(intent);
            }
        });
        ActionBarBackButton= findViewById(R.id.ActionBarBackButton);
        ActionBarBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionBarMainActivity.this,ActionBarBackActivity.class);
                startActivity(intent);
            }
        });

    }
}
