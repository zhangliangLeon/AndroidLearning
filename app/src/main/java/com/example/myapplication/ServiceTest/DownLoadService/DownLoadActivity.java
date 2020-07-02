package com.example.myapplication.ServiceTest.DownLoadService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.example.myapplication.R;

public class DownLoadActivity extends AppCompatActivity {

    private DownLoadService.DownLoadBinder binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);

        Intent intent = new Intent(DownLoadActivity.this,DownLoadService.class);
        startService(intent);
        ServiceConnection con = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (DownLoadService.DownLoadBinder)service;
                binder.startDownload("www.baidu.com");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }
}