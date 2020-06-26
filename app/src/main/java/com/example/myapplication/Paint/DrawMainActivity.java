package com.example.myapplication.Paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class DrawMainActivity extends AppCompatActivity {

    private Button CanvasTestButton;
    private Button DrawARobotButton;
    private Button DrawText;
    private Button DrawBitmap;
    private Button DrawPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_main);

        CanvasTestButton = findViewById(R.id.CanvasTestButton);
        DrawARobotButton = findViewById(R.id.DrawARobotButton);
        DrawText = findViewById(R.id.DrawText);
        DrawBitmap = findViewById(R.id.DrawBitmap);
        DrawPath = findViewById(R.id.DrawPath);

        MyListener listener = new MyListener();

        CanvasTestButton.setOnClickListener(listener);
        DrawARobotButton.setOnClickListener(listener);
        DrawText.setOnClickListener(listener);
        DrawBitmap.setOnClickListener(listener);
        DrawPath.setOnClickListener(listener);

    }

    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.CanvasTestButton:
                    intent = new Intent(DrawMainActivity.this,CanvasActivity.class);
                    break;
                case R.id.DrawARobotButton:
                    intent = new Intent(DrawMainActivity.this,DrawARobotActivity.class);
                    break;
                case R.id.DrawText:
                    intent = new Intent(DrawMainActivity.this,DrawTextActivity.class);
                    break;
                case R.id.DrawBitmap:
                    intent = new Intent(DrawMainActivity.this,DrawBitmapActivity.class);
                    break;
                case R.id.DrawPath:
                    intent = new Intent(DrawMainActivity.this,DrawBoardActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
