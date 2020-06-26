package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.Util.ToastUtil;

public class MyButtonActivity extends AppCompatActivity {

    MyButton myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_button);

        myButton = findViewById(R.id.MyButton);

        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        ToastUtil.showMsg(MyButtonActivity.this,"I am Listener");
                        Log.d("MyButtonActivity","---Listner---");
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                ToastUtil.showMsg(MyButtonActivity.this,"I am activity onTouchEvent");
                Log.d("MyButtonActivity","---onTouchEvent---");
                break;
        }
        return false;
    }
}
