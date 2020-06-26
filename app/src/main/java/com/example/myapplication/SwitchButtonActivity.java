package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class SwitchButtonActivity extends AppCompatActivity {

    private Switch switchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);

        switchButton = findViewById(R.id.SwitchButton);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchButton.isChecked() == true){
                    Toast.makeText(SwitchButtonActivity.this,"开启横屏",LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SwitchButtonActivity.this,"关闭横屏",LENGTH_SHORT).show();
                }
            }
        });
    }
}
