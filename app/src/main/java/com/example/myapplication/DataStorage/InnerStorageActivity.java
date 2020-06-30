package com.example.myapplication.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InnerStorageActivity extends AppCompatActivity {

    private final String mFile = "test.txt";
    private EditText EnterMsg,ShowMsg;
    private Button StoreButton,ShowButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_storage);


        EnterMsg = findViewById(R.id.EnterMsg_1);
        ShowMsg = findViewById(R.id.ShowMsg_1);

        StoreButton = findViewById(R.id.StoreButton_1);
        ShowButton = findViewById(R.id.ShowButton_1);

        StoreButton.setOnClickListener(new onClick());
        ShowButton.setOnClickListener(new onClick());
    }
    class onClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.StoreButton_1:
                    FileOutputStream outputStream = null;
                    try {
                        outputStream = openFileOutput(mFile,MODE_PRIVATE);
                        outputStream.write(EnterMsg.getText().toString().getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case R.id.ShowButton_1:
                    FileInputStream inputStream = null;
                    StringBuilder str = new StringBuilder();
                    try {
                        byte[] buff = new byte[1024];
                        inputStream = openFileInput(mFile);
                        int len = 0;
                        while((len = inputStream.read(buff)) > 0){
                            str.append(new String(buff,0,len));
                        }
                        ShowMsg.setText(new String(str));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

            }


        }
    }
    public String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine()) != null){
                content.append(line);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  content.toString();
    }

    public void putDataToSharedPreferences(){
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("key","val");
        editor.apply();
    }
}
