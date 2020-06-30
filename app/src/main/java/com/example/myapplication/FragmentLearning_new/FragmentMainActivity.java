package com.example.myapplication.FragmentLearning_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class FragmentMainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.LeftFragmentArea,new FragmentLeft()).commit();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        button = findViewById(R.id.FragmentLeftButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.DetailFragmentArea,new FragmentRight()).commit();
            }
        });
    }
}