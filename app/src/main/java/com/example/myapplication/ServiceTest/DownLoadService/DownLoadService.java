package com.example.myapplication.ServiceTest.DownLoadService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.webkit.DownloadListener;
import android.widget.Toast;

//因为想让下载任务一直在后台运行，所以使用一个service
public class DownLoadService extends Service {
    private DownLoadAsyncTask task;
    private DownLoadBinder binder = new DownLoadBinder();
    private MyDownLoadListener listener = new MyDownLoadListener() {
        @Override
        public void succuss() {
            Toast.makeText(DownLoadService.this,"",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void fail() {
            Toast.makeText(DownLoadService.this,"",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void pause() {
            task = null;
            Toast.makeText(DownLoadService.this,"",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void cancle() {
            task = null;
            Toast.makeText(DownLoadService.this,"",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProgress(int progress) {
            Toast.makeText(DownLoadService.this,"",Toast.LENGTH_SHORT).show();
        }
    };
    public DownLoadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    class DownLoadBinder extends Binder {
        public void startDownload(String url){
            if(task == null){
                task = new DownLoadAsyncTask(listener);
                task.execute(url);
            }
        }
        public void pauseDownload(){
            if(task != null){
                task.onPause();
            }
        }
        public void cancleDownload(){
            if(task != null){
                task.onCancle();
            }
        }
    }
}

