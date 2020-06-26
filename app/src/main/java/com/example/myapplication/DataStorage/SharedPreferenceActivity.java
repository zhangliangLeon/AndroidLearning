package com.example.myapplication.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
public class SharedPreferenceActivity extends AppCompatActivity {

    private EditText EnterMsg,ShowMsg;
    private Button StoreButton,ShowButton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        sharedPreferences = getSharedPreferences("Test",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        EnterMsg = findViewById(R.id.EnterMsg);
        ShowMsg = findViewById(R.id.ShowMsg);
        StoreButton = findViewById(R.id.StoreButton);
        ShowButton = findViewById(R.id.ShowButton);

        StoreButton.setOnClickListener(new onClick());
        ShowButton.setOnClickListener(new onClick());
    }
    class onClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String msg = "";
            switch (v.getId()){
                case R.id.ShowButton:
                    //获取key为msg的值，若该值不存在则返回一个默认值""
                    msg = sharedPreferences.getString("msg","");
                    ShowMsg.setText(msg);
                    break;
                case R.id.StoreButton:
                    msg = EnterMsg.getText().toString();
                    editor.putString("msg",msg);
                    editor.apply();
                    break;
            }
        }
    }
}
