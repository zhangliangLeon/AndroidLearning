package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.myapplication.Util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);


//        //使用handler延迟3000秒跳转至主页面
//        Handler mHandler  = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandlerActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        },3000);

        //使用handler执行线程间通信
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                String val = bundle.get("key").toString();
                switch (val){
                    case "val_1":
                        ToastUtil.showMsg(HandlerActivity.this,"我是HandlerActivity主线程");
                        break;
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("key","val_1");
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }).start();

    }
}
