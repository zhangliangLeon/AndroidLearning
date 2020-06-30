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
    private View currentView;
    TextView newsTilte;
    TextView newsContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_detail,container,false);
        Log.d("NewsDetailFragment","onCreateView");
        Log.d("NewsDetailFragment","view = " + view);
        currentView = view;
        return view;
    }
    public void refresh(String title, String content){
        Log.d("NewsDetailFragment","refresh方法 tilte = " +title+ " ,content = "+content);
        Log.d("NewsDetailFragment","view =  " + getView());

        newsTilte = getView().findViewById(R.id.newsTilte);
        newsTilte = getView().findViewById(R.id.newsContent);
        newsTilte.setText(title);
        newsContent.setText(content);
    }
}
