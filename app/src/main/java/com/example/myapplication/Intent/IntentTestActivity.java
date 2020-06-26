package com.example.myapplication.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
/*
    测试隐式intent访问
 */
public class IntentTestActivity extends AppCompatActivity {
    private TextView myTel;
    private Button telButton;
    private Button messageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);

        myTel = findViewById(R.id.myTel);
        telButton = findViewById(R.id.telButton);
        messageButton = findViewById(R.id.messageButton);

        String tel = getDigit(myTel.getText().toString());

        telButton.setOnClickListener(new MyClick(tel));
        messageButton.setOnClickListener(new MyClick(tel));

    }
    public String getDigit(String str){
        String res = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res += str.charAt(i);
            }else{
                continue;
            }
        }
        return res;
    }
    class MyClick implements View.OnClickListener {
        String tel;
        public MyClick(String tel){
            this.tel = tel;
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()){
                case R.id.telButton:
                    System.out.println("tel:"+tel+"\n");
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+tel));
                    break;
                case R.id.messageButton:
                    System.out.println("smsto:"+tel+"\n");
                    intent.setAction(Intent.ACTION_SENDTO);//向某人发消息，接收人已经指定
                    intent.setData(Uri.parse("smsto:"+tel));
                    intent.putExtra("sms_body","hello world");
                    break;
            }
            startActivity(intent);
        }
    }

}
