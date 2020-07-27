package com.example.myapplication.ViewPager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ad_card_layout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager MyViewPager;
    private LayoutInflater mInflater;
    private ArrayList<ad_card_layout> views;
    private LinearLayout dotLayout;
    private ArrayList<Button> btnList;
    private int mPrePositon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        MyViewPager = findViewById(R.id.MyViewPager);
        mInflater = LayoutInflater.from(this);
        dotLayout = findViewById(R.id.dotLayout);

        ArrayList<String> data  = new ArrayList<>();
        data.add("ONE");
        data.add("TWO");
        data.add("THREE");


        initData(data);
        initDot();
        //dotLayout.invalidate();

        MyViewAdaptor adaptor = new MyViewAdaptor();
        MyViewPager.setAdapter(adaptor);
        MyViewPager.setCurrentItem(0);
        MyViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(dotLayout != null){
                    changePosition(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void initData(ArrayList<String> titles){
        if(views == null)
            views = new ArrayList<>();

        for(int i=0;i<titles.size();i++){
            ad_card_layout t = new ad_card_layout(ViewPagerActivity.this);
            t.getmAdButton().setText(titles.get(i));
            views.add(t);
        }
    }
    public void initDot(){
        if(btnList == null){
            btnList = new ArrayList<>();
        }

        for(int i=0;i<views.size();i++){
            Button b = new Button(ViewPagerActivity.this);
            if(i==0){
                b.setBackgroundResource(R.drawable.button_dot_select);
                mPrePositon = i;
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(18,10);
                params.setMargins(4,0,4,0);
                b.setLayoutParams(params);
            }else{
                b.setBackgroundResource(R.drawable.button_dot);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);
                params.setMargins(4,0,4,0);
                b.setLayoutParams(params);
            }
            btnList.add(b);
            dotLayout.addView(b);
        }
    }
    public void changePosition(int position){
        Button pre =btnList.get(mPrePositon);
        Button now = btnList.get(position);
        LinearLayout.LayoutParams params_select = new LinearLayout.LayoutParams(18,10);
        params_select.setMargins(4,0,4,0);
        LinearLayout.LayoutParams params_not_select = new LinearLayout.LayoutParams(10,10);
        params_not_select.setMargins(4,0,4,0);
        pre.setBackgroundResource(R.drawable.button_dot);
        pre.setLayoutParams(params_not_select);
        now.setBackgroundResource(R.drawable.button_dot_select);
        now.setLayoutParams(params_select);
        mPrePositon = position;
    }






    class MyViewAdaptor extends PagerAdapter {

        public MyViewAdaptor(){

        }
        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return  view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(views.get(position),position);
            return views.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}