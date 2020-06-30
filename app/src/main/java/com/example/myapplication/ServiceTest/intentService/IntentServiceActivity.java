package com.example.myapplication.ServiceTest.intentService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        Intent intenteService = new Intent(IntentServiceActivity.this,IntentServiceTest.class);
        Bundle bundle = new Bundle();
        bundle.putString("param","opt_1");
        intenteService.putExtras(bundle);
        startService(intenteService);

        Intent intenteService2 = new Intent(IntentServiceActivity.this,IntentServiceTest.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString("param","opt_2");
        intenteService2.putExtras(bundle2);
        startService(intenteService2);

    }
}