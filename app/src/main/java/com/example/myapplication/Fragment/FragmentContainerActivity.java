package com.example.myapplication.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
public class FragmentContainerActivity extends AppCompatActivity {

    boolean flag = false;
    private Button ChangeFragmentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        ChangeFragmentButton = findViewById(R.id.ChangeFragmentButton);
        ChangeFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == false){
                    Fragment B = new BFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,B).commitAllowingStateLoss();
                    flag = true;
                }else{
                    Fragment A = new AFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,A).commitAllowingStateLoss();
                    flag = false;
                }
            }
        });


        //getSupportFragmentManager().beginTransaction().add(需要添加的组件id,Fragment实例)
        Fragment A = new AFragment().newInstance("我是AFragmeent自定义标题");
        getSupportFragmentManager().beginTransaction().add(R.id.FragmentLayout,A).commitAllowingStateLoss();
    }
}
