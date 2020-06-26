package com.example.myapplication.Paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class CanvasActivity extends AppCompatActivity {

    LinearLayout CanvasLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        CanvasLayout = findViewById(R.id.CanvasLayout);
       // CanvasLayout.addView(new testView(this));

        CanvasLayout.addView(new PathView(this));
     }
}
class testView extends View{

    public testView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        /*
            创建一个渐变色，渐变色从（x0,y0）开始到（x1,y1）结束，从红色变为绿色，当控件大小大于渐变色区域的时候以什么方式填充
         */
        Shader shader = new LinearGradient(0,0,100,0, Color.RED,Color.GREEN, Shader.TileMode.MIRROR);
        paint.setShader(shader);
        /*
            canvas画一个矩形,位置为left,top,right,bottom
            原点为左上角，y轴向下为正，x轴向右为正，left为矩形左边距离y轴的距离
         */
        canvas.drawRect(100,100,300,300,paint);
    }
}

class PathView extends View{

    public PathView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        Path path = new Path();

        path.moveTo(350,350);//设置第一条边的起始位置
        path.lineTo(400,400);//设置第一条边的结束点，同时也是第二条边的开始点
        path.lineTo(350,450);//设置第二条边的结束位置
        canvas.drawPath(path,paint);
    }
}
