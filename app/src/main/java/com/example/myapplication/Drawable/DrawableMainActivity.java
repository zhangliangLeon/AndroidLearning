package com.example.myapplication.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class DrawableMainActivity extends AppCompatActivity {

    private Button StateListDrawableButton;
    private Button ShapeDrawableButton;
    private Button LevelListDrawableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_main);

        StateListDrawableButton = findViewById(R.id.StateListDrawableButton);
        StateListDrawableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DrawableMainActivity.this,StateListDrawableActivity.class);
                startActivity(intent);
            }
        });

        ShapeDrawableButton = findViewById(R.id.ShapeDrawableButton);
        ShapeDrawableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawableMainActivity.this,ShapeDrawableActivity.class);
                startActivity(intent);
            }
        });

        LevelListDrawableButton = findViewById(R.id.LevelListDrawableButton);
        LevelListDrawableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawableMainActivity.this,LevelListDrawableActivity.class);
                startActivity(intent);
            }
        });
    }
}
