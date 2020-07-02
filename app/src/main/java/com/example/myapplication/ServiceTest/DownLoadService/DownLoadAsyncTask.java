package com.example.myapplication.ServiceTest.DownLoadService;

import android.content.Intent;
import android.os.AsyncTask;
import android.webkit.DownloadListener;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

import kotlin.Result;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


//真正的下载业务
public class DownLoadAsyncTask  extends AsyncTask<String,Integer,Integer> {
    final int SUCCUSS = 1;
    final int FAIL = 2;
    final int PAUSE = 3;
    final int CANCLE = 4;
    boolean isCancle = false;
    boolean isPause = false;

    int lastProgress;

    private MyDownLoadListener listener;

    public DownLoadAsyncTask(MyDownLoadListener listener){
        this.listener = listener;
    }
    //真正的下载业务
    @Override
    protected Integer doInBackground(String... urls) {
        File file = null;

        String downLoadUrl = urls[0];
        String fileName = downLoadUrl.substring(downLoadUrl.lastIndexOf("/"));
        String directory = "";

        Long loadedLength = 0L;

        file = new File(directory+fileName);
        if(file.exists()){
            loadedLength = file.length();
        }


        try {

            Long contentLenth = getContentLength(downLoadUrl);

            if(contentLenth == 0){
                return FAIL;
            } else if(contentLenth == loadedLength){
                return SUCCUSS;
            }

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(downLoadUrl)
                    .addHeader("RANGE", "bytes=" + loadedLength + "-")
                    .build();
            Response response = client.newCall(request).execute();
            if (response != null) {
                InputStream in = response.body().byteStream();
                RandomAccessFile savaFile = new RandomAccessFile(file, "rw");
                savaFile.seek(loadedLength);
                byte[] b = new byte[1000];
                int len=0;
                while((len = in.read(b)) != -1){
                    if(isCancle == true){
                        return CANCLE;
                    }else if(isPause){
                        return PAUSE;
                    }else{
                        savaFile.write(b);
                        loadedLength += len;
                        int progress = (int) (loadedLength * 100 / contentLenth);
                        publishProgress(progress);
                    }
                }//endwhile
                return SUCCUSS;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //如果response为空，下载失败
        return FAIL;

    }
    public Long getContentLength(String url) throws Exception{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().contentLength();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if(progress > lastProgress){
            listener.onProgress(progress);
            lastProgress = progress;
        }
    }

    @Override
    protected void onPostExecute(Integer integer) {
        switch (integer){
            case SUCCUSS:
                listener.succuss();
                break;
            case CANCLE:
                listener.cancle();
                break;
            case PAUSE:
                listener.pause();
                break;
            case FAIL:
                listener.fail();
                break;
        }
    }

    public void onPause(){
        isPause = true;
    }

    public void onCancle(){
        isCancle = true;
    }
}
