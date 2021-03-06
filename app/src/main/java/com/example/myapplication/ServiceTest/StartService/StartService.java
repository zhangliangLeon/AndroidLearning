package com.example.myapplication.ServiceTest.StartService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class StartService extends Service {

    //startService无需返回binder
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("StartService","Service ing....................");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("StartService","onCreate ing....................");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("StartService","onDestroy ing....................");
    }
}
