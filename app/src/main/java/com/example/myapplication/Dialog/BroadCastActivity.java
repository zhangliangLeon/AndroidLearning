package com.example.myapplication.Dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Broadcast.BroadcastActivity;
import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

public class BroadCastActivity extends AppCompatActivity {

    private Button sendBroadCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

        IntentFilter intentFilter = new IntentFilter("com.leon");
        MyReceiver myReceiver = new MyReceiver();
        registerReceiver(myReceiver,intentFilter);

        sendBroadCast = findViewById(R.id.sendBroadCast);
        sendBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.leon");
                Bundle bundle = new Bundle();
                bundle.putString("key","val");
                intent.putExtras(bundle);

                sendBroadcast(intent);
            }
        });

    }
    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.leon":
                    Bundle bundle = intent.getExtras();
                    String val = bundle.get("key").toString();
                    ToastUtil.showMsg(BroadCastActivity.this,"我接受到了广播，广播内容为"+val);

            }
        } 
    }
}
