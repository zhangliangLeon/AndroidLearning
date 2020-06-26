package com.example.myapplication.Paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class DrawTextActivity extends AppCompatActivity {

    LinearLayout DrawTextLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_text);

        DrawTextLayout = findViewById(R.id.DrawTextLayout);
        DrawTextLayout.addView(new DrawText(this));
    }
    class DrawText extends View{

        public DrawText(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setTextSize(100);
            canvas.drawText("我是Draw出来的文字",100,100,paint);
        }
    }
}
