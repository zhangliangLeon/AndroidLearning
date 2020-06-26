package com.example.myapplication.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class MenuMainActivity extends AppCompatActivity {

    private Button OptionMenuButton;
    private Button ContextMenuButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
        OptionMenuButton = findViewById(R.id.OptionMenuButton);
        ContextMenuButton = findViewById(R.id.ContextMenuButton);

        OptionMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMainActivity.this,OptionMenuActivity.class);
                startActivity(intent);
            }
        });

        ContextMenuButton = findViewById(R.id.ContextMenuButton);
        ContextMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMainActivity.this,ContextMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
