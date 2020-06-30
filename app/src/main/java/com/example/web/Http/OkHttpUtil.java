package com.example.web.Http;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(address)
                        .build();
                try {//执行成功
                    Response response = client.newCall(request).execute();
                    callback.onFinish(response.toString());
                } catch (IOException e) {//执行出错
                    callback.onError();
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
interface HttpCallback{
        public void onFinish(String response);
    public void onError();
}
class MainActicity extends Activity{

    private String httpResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpUtil.sendHttpRequest("http://www.baidu.com", new HttpCallback() {
            @Override
            public void onFinish(String response) {
                httpResponse = response;
            }

            @Override
            public void onError() {
                Log.d("HttpUtilResquest", "onError: httpRequest Error");
            }
        });

    }
}
