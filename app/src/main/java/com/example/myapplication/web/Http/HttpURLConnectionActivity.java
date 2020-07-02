package com.example.myapplication.web.Http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_u_r_l_connection);
    }

    public String getConnection() throws Exception {
        URL url = new URL("http://www.bytedance.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //设置请求方式
        connection.setRequestMethod("GET");
        //设置连接超时时间
        connection.setConnectTimeout(1000);
        //设置读取超时时间
        connection.setReadTimeout(1000);

        //响应内容读取
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder response = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            response.append(line);
        }

        /*
            //提交数据
            OutputStream out = connection.getOutputStream();
            out.write("我是要提价哦的数据".getBytes());
        */




        reader.close();
        connection.disconnect();

        return response.toString();
    }
}