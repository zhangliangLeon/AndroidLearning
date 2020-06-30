package com.example.myapplication.ServiceTest.bindService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.example.myapplication.R;

public class BindServiceTestActivity extends AppCompatActivity {
    Mybinder mybinder ;
    boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service_test);

        Intent intent = new Intent(BindServiceTestActivity.this,BindServiceTest.class);
        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mybinder = (Mybinder) service;
                Log.d("ServiceConnection", "onServiceConnected: 建立绑定 ");
                isBind = true;
                doSomething();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("ServiceConnection", "onServiceDisconnected: 断开绑定");
            }
        };

        bindService(intent,conn,BIND_AUTO_CREATE);
    }
    public void doSomething(){
        if(isBind == true){
            mybinder.function("入参传递");
        }
    }
}