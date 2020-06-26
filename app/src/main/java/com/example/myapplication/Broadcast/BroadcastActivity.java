package com.example.myapplication.Broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class BroadcastActivity extends AppCompatActivity {

    private Button StartBroadcastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        StartBroadcastButton = findViewById(R.id.StartBroadcastButton);
        StartBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.leon.broadcast");
                LocalBroadcastManager.getInstance(BroadcastActivity.this).sendBroadcast(intent);


            }
        });

    }
}
