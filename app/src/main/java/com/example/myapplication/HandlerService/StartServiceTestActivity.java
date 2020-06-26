package com.example.myapplication.HandlerService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class StartServiceTestActivity extends AppCompatActivity {

    Button StartService;
    Button CloseService;
    Button BindService;
    Button UnBindService;

    MyBinder myBinder ;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("ServiceConn", "onServiceConnected");
            myBinder = (MyBinder)service;
            myBinder.funtion();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("ServiceConn", "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service_test);

        StartService = findViewById(R.id.StartService);
        CloseService = findViewById(R.id.CloseService);
        BindService = findViewById(R.id.BindService);
        UnBindService = findViewById(R.id.UnBindService);

        ServiceButtonListner listner = new ServiceButtonListner();

        StartService.setOnClickListener(listner);
        CloseService.setOnClickListener(listner);
        BindService.setOnClickListener(listner);
        UnBindService.setOnClickListener(listner);
    }

    class ServiceButtonListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent service = new Intent(StartServiceTestActivity.this,StartServiceTest.class);
            switch (v.getId()){
                case R.id.StartService:
                    startService(service);
                    break;
                case R.id.CloseService:
                    stopService(service);
                    break;
                case R.id.BindService:
                    bindService(service,conn,BIND_AUTO_CREATE);

                    break;
                case R.id.UnBindService:
                    Log.d("UnBind按钮点击","执行unbind");
                    unbindService(conn);
                    break;
            }
        }
    }
}
