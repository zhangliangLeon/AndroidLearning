package com.example.myapplication.ListView.Diff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DiffListViewActivity extends AppCompatActivity {

    ListView DiffListView;
    List<item> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_list_view);

        DiffListView = findViewById(R.id.DiffListView);

        //假装加载数据
        initData();
        //创建适配器
        myAdaptor adaptor = new myAdaptor(DiffListViewActivity.this,R.layout.activity_diff_list_view_item,data);
        //添加适配器
        DiffListView.setAdapter(adaptor);
    }
    public void initData(){
        //初始化数据
        for(int i=0 ; i<5 ; i++){
            item item = new item(R.drawable.lion,"name_"+i,"des_i");
            data.add(item);
        }
    }

}

class myAdaptor extends ArrayAdapter<item> {

    //保存需要加载的layout id
    private int resId;
    public myAdaptor(@NonNull Context context, int textViewResourceId, @NonNull List<item> objects) {
        super(context, textViewResourceId, objects);
        resId = textViewResourceId;
    }

    //参数convertView用于对之前家在好的布局进行缓存
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        viewHolder holder;
        //数据已经通过构造函数保存，这里可以直接通过getItem获取到data中的第position条数据
        item item = getItem(position);
        if(convertView == null){//如果缓存为空
            //创建当前view
            view = LayoutInflater.from(getContext()).inflate(resId,parent,false);
            holder = new viewHolder();
            holder.setImg((ImageView) view.findViewById(R.id.DiffListViewItemImg));
            holder.setName((TextView) view.findViewById(R.id.DiffListViewItemName));
            holder.setDes((TextView) view.findViewById(R.id.DiffListViewItemDes));
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (viewHolder) convertView.getTag();
        }

        holder.img.setImageResource(item.getResId());
        holder.name.setText(item.getName());
        holder.des.setText(item.getDes());

        //返回view
        return  view;
    }


}
class item{
    int resId;
    String name;
    String des;

    public item(int resId, String name, String des) {
        this.resId = resId;
        this.name = name;
        this.des = des;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
class viewHolder{
    ImageView img;
    TextView name;
    TextView des;

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getDes() {
        return des;
    }

    public void setDes(TextView des) {
        this.des = des;
    }
}