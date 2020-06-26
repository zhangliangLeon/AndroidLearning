package com.example.myapplication.DiyViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class MyTextView extends View {
    String mText ;
    int mColor;
    Paint mPaint;
    Rect mBound;

    public MyTextView(Context context) {
        this(context,null);
    }
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyTextView,defStyleAttr,0);
        mText = typedArray.getString(R.styleable.MyTextView_mText);
        mColor = typedArray.getColor(R.styleable.MyTextView_mColor,Color.BLACK);
        //回收资源
        typedArray.recycle();

        //创建画笔
        mPaint = new Paint();
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置颜色
        mPaint.setColor(mColor);
        //获取文本的宽和高，文本的宽高信息会被保留在mBound中
        mBound = new Rect();
        mPaint.getTextBounds(mText,0,mText.length(),mBound);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //参数：文字内容，左下角x坐标，左下角y坐标，绘制的style
        canvas.drawText(mText,getWidth()/2 - mBound.width()/2,
                getHeight()/2 + mBound.height()/2,mPaint);

    }

}
