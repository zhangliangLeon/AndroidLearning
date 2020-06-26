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

public class TestAFragment extends Fragment {
    public static TestAFragment getNewInstance(String input){
        TestAFragment aFragment = new TestAFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text",input);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    //为fragment创建view
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if(args != null && args.size() != 0){
            TextView textView = view.findViewById(R.id.TestFragmentAText);
            textView.setText(args.get("text").toString());
        }
    }

}
