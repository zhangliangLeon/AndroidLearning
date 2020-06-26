package com.example.myapplication.ActionBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;

import com.example.myapplication.R;

public class ActionBarBackActivity extends AppCompatActivity {

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_back);

        actionBar = getSupportActionBar();
        //如果有父intent，则显示back按钮
        if(NavUtils.getParentActivityIntent(ActionBarBackActivity.this)!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
