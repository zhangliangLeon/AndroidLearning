package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Util.ToastUtil;

public class ClickEventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_event);
        button = findViewById(R.id.ClickEventButton);

        //使用匿名内部类
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(ClickEventActivity.this,"我是匿名内部类");
            }
        });

        //使用内部类
        button.setOnClickListener(new MyClick());

        //通过事件源实现click接口
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ClickEventButton:
                ToastUtil.showMsg(ClickEventActivity.this,"我是内部类");
                break;
        }
    }

    //使用内部类实现
    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ClickEventButton:
                    ToastUtil.showMsg(ClickEventActivity.this,"我是内部类");
                    break;
            }
        }
    }

    public void show(View view){
        ToastUtil.showMsg(ClickEventActivity.this,"我是onclick属性");
    }

}
