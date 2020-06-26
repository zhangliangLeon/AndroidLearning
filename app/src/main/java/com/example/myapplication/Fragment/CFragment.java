package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class CFragment extends Fragment {

    private Button ChangeFragmentTextButton;
    private Button ChangeFragmentButton_1;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c,container,false);
        Log.d("CFragment","===============onCreateView()");
        Log.d("CFragment","===============hashCode = " + hashCode());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ChangeFragmentTextButton = view.findViewById(R.id.ChangeFragmentTextButton);
        ChangeFragmentButton_1 = view.findViewById(R.id.ChangeFragmentButton_1);
        textView = view.findViewById(R.id.cFragmentTextView);

        ChangeFragmentTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("I am new msg");
            }
        });

        ChangeFragmentButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AFragment A = new AFragment();
                Fragment CFragment = getFragmentManager().findFragmentByTag("CFragment");
                //getFragmentManager().beginTransaction().replace(R.id.FragmentLayout_1,A).addToBackStack(null).commitAllowingStateLoss();
                if(CFragment != null) {
                    getFragmentManager().beginTransaction().hide(CFragment).add(R.id.FragmentLayout_1,A,"AFragment").addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
