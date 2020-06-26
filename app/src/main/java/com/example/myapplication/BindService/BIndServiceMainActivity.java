package com.example.myapplication.BindService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.example.myapplication.R;

public class BIndServiceMainActivity extends AppCompatActivity {

    /*
    MyBinder myBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service_main);

        //创建ServiceConnection
        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBinder = (MyBinder) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        Intent intent = new Intent(BIndServiceMainActivity.this,ExtendBinderService.class);
        bindService(intent,conn,BIND_AUTO_CREATE);
        myBinder.function();
    }*/

    Messenger messenger;
    Message msg;
    final int SAY_HELLO = 1;
    boolean isBind = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service_main);


        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                messenger = new Messenger(service);
                isBind = true;
                Log.d("客户端", "onServiceConnected: ");
                sayHello();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBind = false;
                messenger = null;
                Log.d("客户端", "onServiceDisconnected: ");

            }
        };

        Intent intent = new Intent();
        intent.setAction("com.service.messengerservice");
        intent.setPackage(getPackageName());

        System.out.println(getPackageName());

        //绑定service
        bindService(intent,conn,BIND_AUTO_CREATE);
    }

    public void sayHello(){
        if(isBind == true){
            msg = Message.obtain();
            msg.what = SAY_HELLO;
            try {
                //发送消息给服务端
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }



}
