package com.example.myapplication.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class FragmentTestContainerActivity extends AppCompatActivity {

    Boolean flag = true;
    Button TestChangeFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test_container);

        TestChangeFragmentButton = findViewById(R.id.TestChangeFragmentButton);

        TestChangeFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == true){//切换成B
                    getSupportFragmentManager().beginTransaction().replace(R.id.TestFragment,new TestBFragment()).commitAllowingStateLoss();
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.TestFragment,new TestAFragment()).commitAllowingStateLoss();
                }
                flag = flag == true ? false : true;
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.TestFragment,TestAFragment.getNewInstance("A DIY")).commitAllowingStateLoss();
    }
}
