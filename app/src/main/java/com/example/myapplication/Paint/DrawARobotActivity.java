package com.example.myapplication.Paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class DrawARobotActivity extends AppCompatActivity {

    LinearLayout DrawARobotLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_arobot);

        DrawARobotLayout = findViewById(R.id.DrawARobotLayout);
        DrawARobotLayout.addView(new Robot(this));
    }
}
class Robot extends View{
    public Robot(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //创建一个画笔
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        //绘制机器人的头部
        RectF rectF = new RectF(300,100,800,600);
        canvas.drawArc(rectF,-10,-160,false,paint);
        //绘制机器人眼睛
        paint.setColor(Color.WHITE);
        canvas.drawCircle(450,250,10,paint);
        canvas.drawCircle(650,250,10,paint);
        //绘制机器人身体
        paint.setColor(Color.GREEN);
        canvas.drawRect(300,400,800,800,paint);
        //绘制机器人胳膊
        //左手
        RectF rectF_arm = new RectF(100,400,250,700);
        canvas.drawRoundRect(rectF_arm,10,10,paint);
        //右手，向右偏移即可
        rectF_arm.offset(750,0);
        canvas.drawRoundRect(rectF_arm,10,10,paint);

        //绘制机器人腿
        paint.setColor(Color.BLACK);
        RectF rectF_leg = new RectF(350,800,450,900);
        canvas.drawRoundRect(rectF_leg,10,10,paint);

        rectF_leg.offset(300,0);
        canvas.drawRoundRect(rectF_leg,10,10,paint);



    }
}
