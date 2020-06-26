package com.example.myapplication.HandlerService;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class HandlerTestActivity extends AppCompatActivity {

    TextView HandlerTextView;
    Button HandlerTestButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);

        HandlerTestButton = findViewById(R.id.HandlerTestButton);
        HandlerTextView = findViewById(R.id.HandlerTextView);

        HandlerTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=10 ; i>=0 ; i--){
                    HandlerTextView.setText(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
