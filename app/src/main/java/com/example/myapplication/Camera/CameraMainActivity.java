package com.example.myapplication.Camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class CameraMainActivity extends AppCompatActivity {

    private Button Camera_Pic_1;
    private Button FromPics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_main);

        Camera_Pic_1 = findViewById(R.id.Camera_Pic_1);
        Camera_Pic_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CameraMainActivity.this,Camera_1Activity.class);
                startActivity(intent);
            }
        });

        FromPics = findViewById(R.id.FromPics);
        FromPics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CameraMainActivity.this,FromPicsActivity.class);
                startActivity(intent);
            }
        });
    }
}
