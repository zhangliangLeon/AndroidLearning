package com.example.myapplication.Internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Internet.Volley.ImageRequestActivity;
import com.example.myapplication.Internet.Volley.VolleyTestActivity;
import com.example.myapplication.R;

public class InternetMainActivity extends AppCompatActivity {

    private Button VolleyButton;
    private Button VolleyImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_main);

        VolleyButton = findViewById(R.id.VolleyButton);
        VolleyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetMainActivity.this, VolleyTestActivity.class);
                startActivity(intent);
            }
        });

        VolleyImageButton = findViewById(R.id.VolleyImageButton);
        VolleyImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetMainActivity.this, ImageRequestActivity.class);
                startActivity(intent);
            }
        });
    }
}
