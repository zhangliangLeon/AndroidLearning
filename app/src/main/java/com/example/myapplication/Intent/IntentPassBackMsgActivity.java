package com.example.myapplication.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.myapplication.R;

public class IntentPassBackMsgActivity extends AppCompatActivity {

    GridView picList;
    int[] pics = new int[]{R.mipmap.pic1,R.mipmap.pic2,R.mipmap.pic3,
            R.mipmap.pic4,R.mipmap.pic5,R.mipmap.pic6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_pass_back_msg);

        picList = findViewById(R.id.picList);
        BaseAdapter adapter = new BaseAdapter() {
            ImageView imageView;
            @Override
            public int getCount() {
                return pics.length;
            }
            @Override
            public Object getItem(int position) {
                return pics[position];
            }
            @Override
            public long getItemId(int position) {
                return position + 1;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    imageView = new ImageView(IntentPassBackMsgActivity.this);
                    imageView.setPadding(5,5,5,5);
                    ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(200,200);
                    imageView.setLayoutParams(param);
                }else{
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(pics[position]);
                return imageView;
            }
        };
        picList.setAdapter(adapter);
        picList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("src",pics[position]);

                Intent intent = new Intent();
                intent.putExtras(bundle);

                setResult(2,intent);

                finish();//关闭当前activity，但不回收资源
            }
        });

    }
}
