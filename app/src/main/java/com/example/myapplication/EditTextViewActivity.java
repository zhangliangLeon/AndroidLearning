package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextViewActivity extends AppCompatActivity {

    private Button Login_Button ;
    private EditText account;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_view);
        Login_Button = findViewById(R.id.Login_Button);
        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = findViewById(R.id.account_text);
                password = findViewById(R.id.password_text);
                String Account = account.getText().toString();
                String Password = password.getText().toString();
                String str = "账号："+Account+"\n密码："+Password+"\n登录成功";
                Toast.makeText(EditTextViewActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });

        account = findViewById(R.id.account_text);
        account.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
