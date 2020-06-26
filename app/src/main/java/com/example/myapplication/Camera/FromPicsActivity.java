package com.example.myapplication.Camera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

public class FromPicsActivity extends AppCompatActivity {


    Button fromPics;
    ImageView PicImageView_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_pics);

        SharedPreferences sharedPreferences = getSharedPreferences("good",MODE_PRIVATE);
        sharedPreferences.getString("key","defalt");



        fromPics.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},301);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 301:
                if(grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent,302);
                }else{
                    new AlertDialog.Builder(this)
                            .setTitle("请允许授权")
                            .setPositiveButton("授权", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    intent.setData(Uri.parse("package:"+getPackageName()));
                                    System.out.println(getPackageName());
                                    startActivity(intent);
                                }
                            }).create().show();
                }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 302){
            Uri uri = data.getData();
            String[] picsPath = new String[]{MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(uri,picsPath,null,null,null);
            cursor.moveToFirst();//指向查询的第一个位置
            int columnIndex = cursor.getColumnIndex(picsPath[0]);
            String imgpath = cursor.getString(columnIndex);

            Bitmap img = BitmapFactory.decodeFile(imgpath);
            PicImageView_2.setImageBitmap(img);
            cursor.close();

        }
    }
}
