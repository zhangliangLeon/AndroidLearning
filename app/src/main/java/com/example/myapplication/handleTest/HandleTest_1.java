package com.example.myapplication.handleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class HandleTest_1 extends AppCompatActivity {

    private TextView textView;
    private LinearLayout adArea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_test_1);

        final Handler handler = new Handler();
        textView = findViewById(R.id.count);
        adArea = findViewById(R.id.adArea);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacksAndMessages(null);
                Intent intent = new Intent(HandleTest_1.this,NewPageActivity.class);
                startActivity(intent);
            }
        });

        adArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacksAndMessages(null);
                Intent intent = new Intent(HandleTest_1.this,AdActivity.class);
                startActivity(intent);
            }
        });

        new Thread(new Runnable() {
            int i = 3;
            @Override
            public void run() {
                while(true){
                    if(i == 0)
                        break;
                    textView.setText(i +"");
                    textView.setTextSize(20);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i--;

                }

            }
        }).start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandleTest_1.this,NewPageActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}