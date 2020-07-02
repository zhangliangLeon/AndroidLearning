package com.example.myapplication.FragmentLearning_new.newsclient;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class NewsDetailFragment extends Fragment {
    TextView newsTilte;
    TextView newsContent;

    public static NewsDetailFragment getInstance(String title,String content){
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        bundle.putString("content",content);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_detail,container,false);
        String title = getArguments().get("title").toString();
        String content = getArguments().get("content").toString();

        ((TextView)view.findViewById(R.id.newsTilte)).setText(title);
        ((TextView)view.findViewById(R.id.newsContent)).setText(content);
        return view;
    }
    public void refresh(String title, String content){

        newsTilte = getView().findViewById(R.id.newsTilte);
        newsContent = getView().findViewById(R.id.newsContent);
        newsTilte.setText(title);
        newsContent.setText(content);
    }
}
