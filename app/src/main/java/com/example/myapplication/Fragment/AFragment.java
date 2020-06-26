package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class AFragment extends Fragment {
    TextView textView ;

    public static  AFragment newInstance(String title){
        AFragment aFragment = new AFragment();
        System.out.println("我是AFragment.newInstance\n");
        Bundle bundle = new Bundle();
        bundle.putString("Title",title);
        aFragment.setArguments(bundle);
        return  aFragment;
    }
    @Nullable
    @Override
    //为fragment创建view
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("我是AFragment.onCreateView\n");
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        return  view;
    }

    //view创建完毕后做一些什么事情
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("我是AFragment.onViewCreated\n");
        super.onViewCreated(view,savedInstanceState);
        textView = view.findViewById(R.id.FragmentTextView_1);
        if(getArguments() != null && getArguments().getString("Title")!=null){
            textView.setText(getArguments().getString("Title").toString());
        }
    }
}
