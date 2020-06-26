package com.example.myapplication.AIDLTest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AIDLService extends Service {

    TestObject object = null;

    TestObjectManager.Stub manager = new TestObjectManager.Stub() {
        @Override
        public TestObject getObject() throws RemoteException {
            synchronized (this){
                if(object != null)
                    return object;
                return new TestObject(1,"second");
            }
        }

        @Override
        public void addObject(TestObject obj) throws RemoteException {
            synchronized (this){
                object = obj;
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return  manager;
    }

    @Override
    public void onCreate() {
        object = new TestObject(0,"start");
    }
}
