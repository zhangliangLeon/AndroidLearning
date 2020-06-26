package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import com.example.myapplication.Util.ToastUtil;

public class GpsActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        //获取位置管理器
        LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //判断gps是否正常启动
        getPermission(mLocationManager);

        //设置查询条件
        String bestProvider = mLocationManager.getBestProvider(getCriteria(), true);

        //获取位置信息


        //检查是否获得获取精确地址权限
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            return;
        }

        //监听位置
        //新建一个监听器
        LocationListener locationListener = new LocationListener() {
            //位置信息改变时触发
            @Override
            public void onLocationChanged(Location location) {
                //获取经纬度海拔等信息
                location.getAltitude();

            }

            //gps状态变化时触发
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                //按照状态doSomething
                switch (status){

                }
            }

            //gps开启时触发
            @Override
            public void onProviderEnabled(String provider) {

            }

            //gps禁用时触发
            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        //注册监听
        /*
            四个参数：
            参数一：有GPS_PROVIDER和NETWORD_PROVIDER两种
            参数二：位置信息更新周期，以ms为单位
            参数三：位置变化最小距离，当位置变化超过此值时，将更新位置信息
            参数四：监听器
         */
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,1,locationListener);


    }

    private void getPermission(LocationManager mLocationManager){
        if(!mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            ToastUtil.showMsg(this,"请开启Gps导航...");
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(intent,0);
            return;
        }

    }

    private Criteria getCriteria(){
        Criteria criteria = new Criteria();
        //设置定位精度
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        //设置是否要求速度
        criteria.setSpeedRequired(false);
        //设置是否需要方位信息
        criteria.setBearingRequired(false);
        //设置是否允许运营商收费
        criteria.setCostAllowed(false);
        //设置是否需要海拔信息
        criteria.setAltitudeRequired(false);
        //设置对电源的要求
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        return criteria;
    }
}
