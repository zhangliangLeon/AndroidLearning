package com.example.myapplication.BindService;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MessengerService extends Service {
    //定义message的what
    final int SAY_HELLO = 1;
    final int SAY_GOODBY = 2;

    Messenger messenger;
    MsgHandler msgHandler;

    class MsgHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch(msg.what){
                case SAY_HELLO:
                    Log.d("服务端", "SAY_HELLO");
                    Toast.makeText(getApplicationContext(),"SAY_HELLO",Toast.LENGTH_SHORT).show();
                    break;
                case SAY_GOODBY:
                    Toast.makeText(getApplicationContext(),"SAY_GOODBY",Toast.LENGTH_SHORT).show();
                    break;
                default:
                     break;
            }
        }
    }

    public MessengerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        msgHandler = new MsgHandler();
        messenger = new Messenger(msgHandler);

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("服务端", "onBind");
        Toast.makeText(getApplicationContext(),"Binding....",Toast.LENGTH_SHORT).show();
        return messenger.getBinder();
    }
}
