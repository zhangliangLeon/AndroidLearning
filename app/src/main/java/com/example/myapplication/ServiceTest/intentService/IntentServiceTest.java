package com.example.myapplication.ServiceTest.intentService;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class IntentServiceTest extends IntentService {

    public IntentServiceTest(){
        super("IntentServiceTest");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent.getExtras() == null){
            Log.d("IntentServiceTest", "onHandleIntent: opt_0");
        }else{
            String action = intent.getExtras().getString("param");
            if(action.equals("opt_1")){
                Log.d("IntentServiceTest", "onHandleIntent: opt_1");
            }else if(action.equals("opt_2")){
                Log.d("IntentServiceTest", "onHandleIntent: opt_2");
            }
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("IntentServiceTest", "onCreate");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("IntentServiceTest", "onStart");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("IntentServiceTest", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.d("IntentServiceTest", "onDestroy");
        super.onDestroy();
    }
}
