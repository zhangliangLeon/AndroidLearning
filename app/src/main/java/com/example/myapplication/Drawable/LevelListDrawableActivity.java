package com.example.myapplication.Drawable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

public class LevelListDrawableActivity extends AppCompatActivity {

    final int MSG_FLAG = 0x005;
    LevelListDrawable levelListDrawable;
    ImageView LevelListDrawableImg;
    int i = 0;
    int a = 0;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == MSG_FLAG){
                a = i % 4;
                a = a == 0 ? a+1 : a;
                levelListDrawable.setLevel(a);
                i++;
            }
            Message msg_1= handler.obtainMessage(MSG_FLAG);
            handler.sendMessageDelayed(msg_1,500);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_list_drawable);

        LevelListDrawableImg = findViewById(R.id.LevelListDrawableImg);

        levelListDrawable = (LevelListDrawable) LevelListDrawableImg.getDrawable();

        Message message = Message.obtain();
        message.what = MSG_FLAG;
        handler.sendMessage(message);

    }

    //界面停止后移除消息
    @Override
    protected void onStop() {
        super.onStop();
        handler.removeMessages(MSG_FLAG);
    }
}
