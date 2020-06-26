package com.example.myapplication.BindService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ExtendBinderService extends Service {
    MyBinder binder = new MyBinder();

    public ExtendBinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
class MyBinder extends Binder{
    public void function(){
        Log.d("MyBinder", "function");
    }
}
