package com.example.myapplication.AIDLTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

public class AidlActivity extends AppCompatActivity {

    TestObjectManager manager;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);

        attempBindService();

    }

    private void addObject() throws RemoteException {
        if(mBound == true){
            TestObject object = new TestObject(3,"third");
            manager.addObject(object);
        }else{
            ToastUtil.showMsg(this,"未能获取到服务");
        }
    }

    private void attempBindService(){
        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                manager = TestObjectManager.Stub.asInterface(service);
                try {
                    TestObject obj = manager.getObject();
                    Log.d("onServiceConnected", "ObjectName: " + obj.getName());
                    mBound = true;

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mBound = false;
            }
        };

        Intent intent = new Intent();
        intent.setAction("com.example.testAidl");
        intent.setPackage(getPackageName());

        bindService(intent,conn,BIND_AUTO_CREATE);


    }
}
