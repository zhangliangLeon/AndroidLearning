package com.example.myapplication.Media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MediaMainActivity extends AppCompatActivity {
    Button MusicPlay;
    Button MusicPlay_1;
    Button VideoPlay;
    Button Video_1Play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_main);

        MusicPlay = findViewById(R.id.MusicPlay);
        MusicPlay_1 = findViewById(R.id.MusicPlay_1);
        VideoPlay = findViewById(R.id.VideoPlay);
        Video_1Play= findViewById(R.id.Video_1Play);

        MediaListner listner = new MediaListner();

        MusicPlay.setOnClickListener(listner);
        MusicPlay_1.setOnClickListener(listner);
        VideoPlay.setOnClickListener(listner);
        Video_1Play.setOnClickListener(listner);
    }
    class MediaListner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.MusicPlay:
                    intent = new Intent(MediaMainActivity.this,MusicPlayActivity.class);
                    break;
                case R.id.MusicPlay_1:
                    intent = new Intent(MediaMainActivity.this,MusicPlay_1Activity.class);
                    break;
                case R.id.VideoPlay:
                    intent = new Intent(MediaMainActivity.this,VideoPlayActivity.class);
                    break;
                case R.id.Video_1Play:
                    intent = new Intent(MediaMainActivity.this,VideoPaly_1Activity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
