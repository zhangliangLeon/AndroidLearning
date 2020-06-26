package com.example.myapplication.Media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.io.IOException;

public class VideoPaly_1Activity extends AppCompatActivity {

    SurfaceView VideoPlayArea;
    Button VideoControl;
    Boolean playing = true;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_paly_1);

        VideoPlayArea = findViewById(R.id.VideoPlayArea);
        VideoControl = findViewById(R.id.VideoControl);

        mediaPlayer = MediaPlayer.create(this,R.raw.video);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                SurfaceHolder holder = VideoPlayArea.getHolder();
                mediaPlayer.setDisplay(holder);
            }
        });

        VideoControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing == true){
                    mediaPlayer.start();
                    playing = false;
                    VideoControl.setText("暂停");
                }else{
                    mediaPlayer.pause();
                    VideoControl.setText("播放");
                }
            }
        });
    }
}
