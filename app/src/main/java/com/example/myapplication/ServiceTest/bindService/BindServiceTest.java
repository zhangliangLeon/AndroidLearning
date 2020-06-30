package com.example.myapplication.ServiceTest.bindService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class BindServiceTest extends Service {

    Mybinder mybinder =  new Mybinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("BindServiceTest", "onCreate .........");
        return mybinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("BindServiceTest", "onStartCommand .........");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.d("BindServiceTest", "onCreate .........");
        super.onCreate();
    }
}
class Mybinder extends Binder{
    public void function(String str){
        Log.d("Mybinder", "function String [" + str + " ]");
    }
}
