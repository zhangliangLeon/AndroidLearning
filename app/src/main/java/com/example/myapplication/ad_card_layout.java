package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.Util.ToastUtil;

public class ad_card_layout extends ConstraintLayout implements View.OnClickListener {
    private ImageView mAdIcon;
    private TextView mAdName;
    private TextView mAdDesc;
    private Button mAdButton;
    private View mView;
    private Context mContext;
    private LinearLayout layout;

    public ad_card_layout(final Context context) {
        super(context);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.ad_card_layout,this);
        mAdDesc = findViewById(R.id.ad_desc);
        mAdButton = findViewById(R.id.ad_button);
        mAdIcon = findViewById(R.id.ad_img);
        mAdName = findViewById(R.id.ad_name);
        mAdDesc = findViewById(R.id.ad_desc);
        mAdButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.setVisibility(GONE);
            }
        });


        mView.setVisibility(VISIBLE);

    }

    public ad_card_layout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.ad_card_layout,this);
        mAdDesc = findViewById(R.id.ad_desc);
        mAdButton = findViewById(R.id.ad_button);
        mAdIcon = findViewById(R.id.ad_img);
        mAdName = findViewById(R.id.ad_name);
        mAdDesc = findViewById(R.id.ad_desc);
        mView.setVisibility(VISIBLE);
        layout = findViewById(R.id.ad_button_layout);
        mAdButton.setOnClickListener(this);
        layout.setOnClickListener(this);
    }


    public Button getmAdButton(){
        return mAdButton;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ad_button_layout){
            ToastUtil.showMsg(mContext,"我是View");
        }else{
            ToastUtil.showMsg(mContext,"我是button");
        }
    }
}
