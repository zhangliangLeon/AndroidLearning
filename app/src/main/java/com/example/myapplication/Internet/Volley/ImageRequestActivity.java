package com.example.myapplication.Internet.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;

public class ImageRequestActivity extends AppCompatActivity {

    ImageView VolleyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_request);

        VolleyImage = findViewById(R.id.VolleyImage);

        String url = "https://pics7.baidu.com/feed/8b13632762d0f703009c7ed3281bcf3b2797c5ff.jpeg?token=ad5dd8125b4a3a3ecacd03f2acd72102";
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        ImageRequest request = new ImageRequest("", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                VolleyImage.setImageBitmap(response);
            }
        },0,0,ImageView.ScaleType.FIT_CENTER,Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("onErrorResponse","wrong");
                    }
        });
        mQueue.add(request);
    }
}
