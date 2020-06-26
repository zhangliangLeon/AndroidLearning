
package com.example.permissiontest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button permissionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionButton = findViewById(R.id.permissionButton);
        permissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //安卓版本大于6.0时，需要获取权限授权
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    //判断是否没有授权定位权限
                    //checkSelfPermission 未授权返回-1 ; 授权了返回0(PackageManager.PERMISSION_GRANTED = 0)
                    if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED){
                        //若未授权
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
                    }else{
                        //已授权
                        Toast.makeText(MainActivity.this,"定位权限已授权",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //requestPermission方法调用完毕后，会自动调用本回调方法
        //requestCode为调用requestPermission方法时传入的标记code
        //grantResult用于存放授权结果
        switch(requestCode){
            case 1://当回调的requstcode == 1 时
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //用户同意授权，授权成功
                    Toast.makeText(this,"用户同意授权",Toast.LENGTH_SHORT).show();
                }else{
                    //用户未同意授权
                    new AlertDialog.Builder(this)
                            .setTitle("提醒")
                            .setMessage("当前应用缺少必要权限，该功能暂时无法使用"+
                                    "点击【确定】前往设置中心进行权限授权")
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //doSomething
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //设置intent Action
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    System.out.println("package:" + getPackageName() + "\n");
                                    intent.setData(Uri.parse("package:"+getPackageName()));
                                    startActivity(intent);
                                }
                            }).show();
                }
                break;

        }
        return;
    }

}
