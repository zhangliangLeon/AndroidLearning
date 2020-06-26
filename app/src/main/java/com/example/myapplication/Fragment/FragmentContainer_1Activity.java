package com.example.myapplication.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import com.example.myapplication.R;

public class FragmentContainer_1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container_1);

        Fragment C = new CFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.FragmentLayout_1,C,"CFragment").commitAllowingStateLoss();
    }
}
