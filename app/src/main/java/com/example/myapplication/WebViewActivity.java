package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.WebView);
        webView.getSettings().getJavaScriptEnabled();
        webView.loadUrl("https://m.baidu.com");
        //系统会自动使用系统浏览器打开网站，若希望直接再当前WebView中加载，需要如下的配置
        webView.setWebViewClient(new WebViewClient(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl(request.getUrl().toString());
                return true;
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack() == true ){
            webView.goBack();
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_FORWARD && webView.canGoForward() == true){
            webView.goForward();
            return true;

        }
        return true;
    }
}
