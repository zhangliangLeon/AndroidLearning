package com.example.myapplication.DiyViews.ActionBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class UseActionBarActivity extends AppCompatActivity {

    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_action_bar);

        ActionBar defaultActionBar = getSupportActionBar();
        defaultActionBar.hide();
        /*
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Toast.makeText(UseActionBarActivity.this,"我是backButton",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}