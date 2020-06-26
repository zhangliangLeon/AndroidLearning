package com.example.myapplication.HandlerService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class StartServiceTest extends Service {
    MyBinder myBinder = new MyBinder();

    public StartServiceTest() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("StatService","onBind");
        return myBinder;
    }

    @Override
    public void onCreate() {
        Log.d("StartService","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("StartService","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("StartService","onDestroy");
        super.onDestroy();
    }
}
class MyBinder extends Binder {
    public void funtion(){
        Log.d("MyBinder", "funtion");
    }
}
