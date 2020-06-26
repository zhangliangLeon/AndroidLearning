package com.example.myapplication.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class IntentPassForwardMsgActivity extends AppCompatActivity {

    TextView show_bundle_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_pass_forward_msg);

        show_bundle_textview = findViewById(R.id.show_bundle_textview);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String name = bundle.get("name").toString();
        String tel = bundle.get("tel").toString();
        person person = (person)bundle.get("person");

        show_bundle_textview.setText("My name is "+name+" and my tel is "+tel);

    }
}
