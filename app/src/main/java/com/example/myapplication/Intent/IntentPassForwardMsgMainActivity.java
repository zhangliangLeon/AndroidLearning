package com.example.myapplication.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import java.io.Serializable;

public class IntentPassForwardMsgMainActivity extends AppCompatActivity {

    private Button intent_pass_forward_button;
    private EditText name;
    private EditText tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_pass_forward_msg_main);

        intent_pass_forward_button = findViewById(R.id.intent_pass_forward_button);
        name = findViewById(R.id.intent_test_name);
        tel = findViewById(R.id.intent_test_tel);

        intent_pass_forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intent_name = name.getText().toString();
                String intent_tel = tel.getText().toString();
                person obj = new person(1);

                Bundle bundle = new Bundle();
                bundle.putString("name",intent_name);
                bundle.putString("tel",intent_tel);
                bundle.putSerializable("person",obj);

                Intent intent = new Intent(IntentPassForwardMsgMainActivity.this,IntentPassForwardMsgActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

}
class person implements Serializable {
    int age;
    public person(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
