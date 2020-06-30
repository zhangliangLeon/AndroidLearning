package com.example.myapplication.ListView.Simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class SimpleListViewActivity extends AppCompatActivity {

    String[] data = {"one","two","three","four","five"};
    ListView simpleListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        simpleListView = findViewById(R.id.simpleListView);

        /**
         * Constructor. This constructor will result in the underlying data collection being
         * immutable, so methods such as {@link #clear()} will throw an exception.
         *
         * @param context The current context.————————————上下文
         * @param resource The resource ID for a layout file containing a TextView to use when
         *                 instantiating views.——————————————item项的layoutId
         * @param objects The objects to represent in the ListView.————————数据
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.activity_simple_list_view_item,data);
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((TextView)view).getText().toString();
                String msg = "I'm position_"+position+" ,my content is "+name;
                Toast.makeText(SimpleListViewActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });



        simpleListView.setAdapter(adapter);
    }

}