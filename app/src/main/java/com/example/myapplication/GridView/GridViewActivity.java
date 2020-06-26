package com.example.myapplication.GridView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        GridViewAdaptor myAdaptor = new GridViewAdaptor(this);
        GridView gridView = findViewById(R.id.GridView);
        gridView.setAdapter(myAdaptor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"Position"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
class GridViewAdaptor extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    GridViewAdaptor(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 11;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridHolder holder = new GridHolder();
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.activity_grid_view_item,null);
            holder.setTitle((TextView) convertView.findViewById(R.id.GridViewItemTitle));
            holder.setContent((TextView) convertView.findViewById(R.id.GridViewItemContent));
            convertView.setTag(holder);
        }else{
            holder = (GridHolder) convertView.getTag();
        }
        holder.getTitle().setText("This is Title");
        holder.getContent().setText("This is Content");
        return convertView;
    }
}
class GridHolder{
    TextView title;
    TextView content;
    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getContent() {
        return content;
    }

    public void setContent(TextView content) {
        this.content = content;
    }
}
