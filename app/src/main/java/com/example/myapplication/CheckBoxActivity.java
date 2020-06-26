package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox checkBox_1,checkBox_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        checkBox_1 = findViewById(R.id.checkbox_1);
        checkBox_2 = findViewById(R.id.checkbox_2);
        checkBox_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true)
                    Toast.makeText(CheckBoxActivity.this,buttonView.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        checkBox_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true)
                    Toast.makeText(CheckBoxActivity.this,buttonView.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
