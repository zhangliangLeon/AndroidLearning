package com.example.myapplication.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class IntentFilterMainActivity extends AppCompatActivity {
    private Button intentFilterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter_main);

        intentFilterButton = findViewById(R.id.intentFilterButton);
        intentFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }
}
