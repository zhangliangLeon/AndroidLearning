package com.example.myapplication.Media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MusicPlay_1Activity extends AppCompatActivity {

    //pool最大容量，声音类型，音频品质
    SoundPool soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
    //用于存放音乐信息
    HashMap<Integer,Integer> music = new HashMap<>();

    List<HashMap<String,String>> ItemName = new ArrayList<>();
    String[] names = new String[]{"一生守候","夏天的风"};
    ListView MusicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play_1);

        MusicList = findViewById(R.id.MusicList);

        //初始化itemname,用于适配器的构建
        for(int i=0;i<names.length;i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("name",names[i]);
            ItemName.add(map);
        }

        //key为position,value为sound ID
        music.put(0,soundPool.load(this,R.raw.music,1));
        music.put(1,soundPool.load(this,R.raw.sumerwind,1));

        SimpleAdapter adapter = new SimpleAdapter(this,ItemName,R.layout.musiclist
                ,new String[]{"name"},new int[]{R.id.musicname});
        MusicList.setAdapter(adapter);

        MusicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //音乐id,左声道大小，右声道大小，优先级，循环次数，播放速率
                soundPool.play(music.get(position),1,1,0,0,1);
            }
        });

    }
}
