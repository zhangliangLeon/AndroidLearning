package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button btn_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"点击了btn_4",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showToast(View view){
        Toast.makeText(ButtonActivity.this,"点击了btn_5",Toast.LENGTH_SHORT).show();
    }
}
