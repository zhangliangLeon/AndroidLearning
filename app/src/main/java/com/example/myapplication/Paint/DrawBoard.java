package com.example.myapplication.Paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


public class DrawBoard extends View {
    private int view_weight;
    private int view_height;
    //缓存canvas
    private Canvas cacheCanvas;
    //缓存canvas的bitmap
    private Bitmap cacheBitmap;
    private Path path;
    private Paint paint;
    private float preX;
    private float preY;

    public DrawBoard(Context context) {
        this(context,null);
    }

    public DrawBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view_weight = getResources().getDisplayMetrics().widthPixels;
        view_height = getResources().getDisplayMetrics().heightPixels;
        //创建一个缓冲区canvas，并未该canvas添加mBitmap，后续在canvas的绘画其实都是被画在了该mbitmap上
        cacheBitmap = Bitmap.createBitmap(view_weight,view_height,Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);

        path = new Path();

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //由于在缓存的canvas上绘制内容后，内容会被保留在缓存的canvas对应的bitmap中
        //所以直接在真实的canvas上绘制cachebitmap即可
        canvas.drawBitmap(cacheBitmap,0,0,null);
        //实时绘制path，如果不加下面的绘制path操作，每次抬手才会绘制最新的图画内容
        //添加后会实时跟随鼠标移动绘制内容
        canvas.drawPath(path,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX,preY,(x+preX)/2,(y+preY)/2);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                //抬手后，在缓存canvas上绘制路径，绘制的路径会被保存在cacheBitmap中
                cacheCanvas.drawPath(path,paint);
                path.reset();
                break;
        }
        //刷新，重新调用onDraw方法
        invalidate();
        return  true;
    }
}
