package com.example.myapplication;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.Util.ToastUtil;

public class MyButton extends AppCompatButton {


    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton","---onTouchEvent---");
                ToastUtil.showMsg(getContext(),"onTouchEvent");
                break;
        }
        //返回false表示我处理了还要继续交由上层处理
        return false;
    }
}

