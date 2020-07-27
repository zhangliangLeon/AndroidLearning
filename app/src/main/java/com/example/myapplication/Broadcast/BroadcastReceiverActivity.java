package com.example.myapplication.Broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private Button BroadcastButton;
    private TextView textView;
    private BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        BroadcastButton = findViewById(R.id.BroadcastButton_1);
        BroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastReceiverActivity.this,BroadcastActivity.class);
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.BroadcastText);

        receiver = new BroadcastReceiver();
        //我需要处理那些广播，添加到intentFilter中
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.leon.broadcast");
        intentFilter.addCategory("aaaaaaA");

        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        //取消receiver的注册，防止内存泄漏
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        super.onDestroy();
    }

    private class BroadcastReceiver extends android.content.BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.leon.broadcast":
                    textView.setText("广播后更改的内容");
                    break;
            }
        }
    }

}
