package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivityForResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_res);

        Button button = findViewById(R.id.TestStartButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1 = new Intent();
                intent_1.putExtra("ReturnKey","ReturnVal_1");
                setResult(1,intent_1);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent_1 = new Intent();
        intent_1.putExtra("ReturnKey","ReturnVal_2");
        setResult(1,intent_1);
        finish();
    }
}
