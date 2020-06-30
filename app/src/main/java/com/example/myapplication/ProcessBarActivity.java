package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

public class ProcessBarActivity extends AppCompatActivity {
    ProgressBar progressBar_horrizontal ;
    Integer processState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_bar);

        progressBar_horrizontal = findViewById(R.id.process1);
        processState = progressBar_horrizontal.getProgress();

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){//进度还未到100
                    progressBar_horrizontal.setProgress(processState);
                }else{
                    progressBar_horrizontal.setProgress(100);//进度条100%
                    try{
                        Thread.sleep(200);//保留进度条2毫秒
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //不在显示进度条，且该进度条不在占据布局空间
                    progressBar_horrizontal.setVisibility(View.GONE);
                    Toast.makeText(ProcessBarActivity.this,"已完成相关操作",Toast.LENGTH_SHORT).show();
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    Message msg = new Message();
                    processState = (int)(Math.random()*10) + processState;
                    if(processState < 100){
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }else{
                        msg.what = 2;
                        handler.sendMessage(msg);
                        break;
                    }
                    try{
                        Thread.sleep(200);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();




    }

}
