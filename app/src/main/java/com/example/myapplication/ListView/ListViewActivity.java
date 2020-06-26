package com.example.myapplication.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = findViewById(R.id.ListView);
        MyAdaptor adaptor = new MyAdaptor(this);
        listView.setAdapter(adaptor);
    }
}
class MyAdaptor extends BaseAdapter{

    private Context context = null;
    private LayoutInflater layoutInflater=null;

    MyAdaptor(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 4;
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
    public View getView(int position, View convertView, ViewGroup parent) {//获取单个view
        Holder holder = new Holder();

        if(convertView == null) {
            //让获取的layoutInflater实例去加载ListViewItem
            convertView = layoutInflater.inflate(R.layout.activity_list_view_item, null);
            holder.setImg((ImageView) convertView.findViewById(R.id.ListViewItemImg));
            holder.setTilte((TextView) convertView.findViewById(R.id.ListViewItemTitle));
            holder.setContent((TextView) convertView.findViewById(R.id.ListViewItemContent));
            holder.setData((TextView) convertView.findViewById(R.id.ListviewItemData));
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        //设置holder内容
        holder.getTilte().setText("This is Title");
        holder.getContent().setText("This is Content");
        holder.getData().setText("This is Data");
        String imgUrl = "https://www.baidu.com/img/PCpad_bc531b595cf1e37c3907d14b69e3a2dd.png";
        Glide.with(context).load(imgUrl).into(holder.getImg());

        return convertView;
    }
}
class Holder{
    ImageView img;
    TextView tilte;
    TextView content;
    TextView data;
    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public TextView getTilte() {
        return tilte;
    }

    public void setTilte(TextView tilte) {
        this.tilte = tilte;
    }

    public TextView getContent() {
        return content;
    }

    public void setContent(TextView content) {
        this.content = content;
    }

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }
}
