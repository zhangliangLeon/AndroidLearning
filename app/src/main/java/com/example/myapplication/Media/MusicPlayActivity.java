package com.example.myapplication.Media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.io.IOException;

public class MusicPlayActivity extends AppCompatActivity {

    Button MusicControlButton;
    MediaPlayer mediaPlayer;
    boolean playing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);

        mediaPlayer = MediaPlayer.create(this,R.raw.music);

        MusicControlButton = findViewById(R.id.MusicControlButton);

        MusicControlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing == true){
                    try {
                        mediaPlayer.prepareAsync();//预加载音乐
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
                    playing = false;

                    MusicControlButton.setText("暂停");
                }else{
                    playing = true;
                    mediaPlayer.pause();
                    MusicControlButton.setText("播放");
                }
            }
        });
    }
}
