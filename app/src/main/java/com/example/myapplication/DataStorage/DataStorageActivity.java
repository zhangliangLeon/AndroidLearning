package com.example.myapplication.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class DataStorageActivity extends AppCompatActivity {

    Button SharedPreferenceButton;
    Button InnerStorageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        SharedPreferenceButton = findViewById(R.id.SharedPreferenceButton);
        InnerStorageButton = findViewById(R.id.InnerStorageButton);

        SharedPreferenceButton.setOnClickListener(new onClick());
        InnerStorageButton.setOnClickListener(new onClick());

    }
    class onClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.SharedPreferenceButton:
                    intent = new Intent(DataStorageActivity.this,SharedPreferenceActivity.class);
                    break;
                case R.id.InnerStorageButton:
                    intent = new Intent(DataStorageActivity.this,InnerStorageActivity.class);
                    break;
            }
            if(intent   !=  null)
                startActivity(intent);
        }
    }
}
