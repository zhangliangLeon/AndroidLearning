package com.example.myapplication.Paint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class DrawBitmapActivity extends AppCompatActivity {

    private LinearLayout DrawBitmapLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_bitmap);

        DrawBitmapLayout = findViewById(R.id.DrawBitmapLayout);
        DrawBitmapLayout.addView(new DrawBitmap(this));

    }
    class DrawBitmap extends View{

        public DrawBitmap(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lion);

            //把bitmap绘制再画板上
            canvas.drawBitmap(bitmap,0,0,paint);


            //从原bitmap上截取一部分，并画在画布上
            //src为从原画上挖取的区域
            Rect src = new Rect(0,0,1000,1000);
            //dst为画在画板上的区域
            Rect dst = new Rect(1000,1000,2000,2000);
            canvas.drawBitmap(bitmap,src,dst,paint);


        }
    }
}
