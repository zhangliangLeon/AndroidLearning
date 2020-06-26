package com.example.myapplication.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

public class StateListDrawableActivity extends AppCompatActivity {
    EditText StateListDrawableEditText;
    Button StateListDrawableSearchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list_drawable);

        StateListDrawableEditText = findViewById(R.id.StateListDrawableEditText);
        StateListDrawableSearchButton = findViewById(R.id.StateListDrawableSearchButton);

        StateListDrawableSearchButton.setEnabled(false);

        StateListDrawableEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(StateListDrawableEditText.length() > 0){
                    StateListDrawableSearchButton.setEnabled(true);
                }else{
                    StateListDrawableSearchButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        StateListDrawableSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(StateListDrawableActivity.this,"点击了按钮");
            }
        });

    }
}
