package com.example.myapplication.Media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

public class VideoPlayActivity extends AppCompatActivity {

    VideoView MyVideoView;
    MediaController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        MyVideoView= findViewById(R.id.MyVideoView);
        mController = new MediaController(this);

        String packageName = getPackageName();

        MyVideoView.setVideoURI(Uri.parse("android.resource://"+packageName + "/"+R.raw.video));
        MyVideoView.setMediaController(mController);

        MyVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                ToastUtil.showMsg(VideoPlayActivity.this,"视频准备完毕");
            }
        });

        MyVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ToastUtil.showMsg(VideoPlayActivity.this,"视频播放完毕");
            }
        });
    }
}
