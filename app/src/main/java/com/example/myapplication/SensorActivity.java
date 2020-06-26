package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class SensorActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener listener= new SensorEventListener() {
        //传感器数据发生变化时调用
        @Override
        public void onSensorChanged(SensorEvent event) {
            //获取传感器数据
            //不同额传感器会传递回来不同大小的values数组
            float[] values = event.values;

            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                //doSomething
            }
        }

        //传感器精度变化时调用
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        //获取传感器管理类
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //获取具体的传感器
        //获取加速度传感器
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //给传感器添加监听器
        //参数：监听器，传感器，获取传感器数据频率
        sensorManager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener);
    }
}
