package com.example.myapplication.Camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

public class Camera_1Activity extends AppCompatActivity {
    Button TakePic_1;
    ImageView PicImageView_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_1);

        PicImageView_1 = findViewById(R.id.PicImageView_1);
        TakePic_1 = findViewById(R.id.TakePic_1);
        TakePic_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,300);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300 && resultCode == Activity.RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");

            PicImageView_1.setImageBitmap(bitmap);
        }else{
            ToastUtil.showMsg(Camera_1Activity.this,"没有拍到照片");
        }
    }
}
