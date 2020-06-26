package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        textView = findViewById(R.id.TextView_1);
        //文字中间的划线
        //textView.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
        //下划线
        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        

    }
}
