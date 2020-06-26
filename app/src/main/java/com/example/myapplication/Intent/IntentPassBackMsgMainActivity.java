package com.example.myapplication.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

public class IntentPassBackMsgMainActivity extends AppCompatActivity {

    ImageView intent_pic;
    Button changePicButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_pass_back_msg_main);

        intent_pic = findViewById(R.id.intent_pic);
        changePicButton = findViewById(R.id.changePicButton);

        changePicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentPassBackMsgMainActivity.this,IntentPassBackMsgActivity.class);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2 && resultCode == 2){
            //处理对了
            Bundle bundle = data.getExtras();
            //获取返回值
            int res = Integer.parseInt(bundle.get("src").toString());
            //更换图片
            intent_pic.setImageResource(res);
        }
    }
}
