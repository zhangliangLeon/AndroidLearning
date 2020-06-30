package com.example.myapplication.handleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class ChildThreadChangeUIActivity extends AppCompatActivity {

    private TextView textView;
    private Button ChangeUiButton;

    private Handler mHandler ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_thread_change_u_i);

        //Looper.prepare(); 主线程中会自动创建一个looper所以此处不需要再创建looper否则会报错
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0){
                    textView.setText("456");
                }
            }
        };
        //Looper.loop();
        textView = findViewById(R.id.ChildChangeUi);
        ChangeUiButton = findViewById(R.id.ChangeUiButton);


        ChangeUiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.sendEmptyMessage(0);
                    }
                }).start();
            }
        });

    }


}