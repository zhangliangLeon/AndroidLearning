package com.example.web.Http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }
    public String getConnection() throws  Exception{
        OkHttpClient client = new OkHttpClient();

        //创建request
        Request request = new Request.Builder()
                .url("http://www.baicu.com")
                .build();

        //发起请求，获得响应
        Response response = client.newCall(request).execute();
        String responseData = response.body().string();
        return responseData;
    }
    public String postConnection() throws Exception{
        OkHttpClient client = new OkHttpClient();

        //请求时需要提交的内容
        RequestBody requestBody = new FormBody.Builder()
                .add("name","bytedance")
                .add("pass","123456")
                .build();
        //请求，采用post方法
        Request request = new Request.Builder()
                .url("http://www.bytedance.com")
                .post(requestBody)
                .build();
        //请求完毕获取响应
        Response response = client.newCall(request).execute();
        String responseData = response.body().string();
        return responseData;
    }
}