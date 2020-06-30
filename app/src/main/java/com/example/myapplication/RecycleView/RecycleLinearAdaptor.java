package com.example.myapplication.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleLinearAdaptor extends RecyclerView.Adapter<RecycleLinearViewHolder> {
    List data;
    LayoutInflater inflater;
    public RecycleLinearAdaptor(Context context,List data ){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecycleLinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_recycle_linear_view_item,parent,false);
        final RecycleLinearViewHolder holder = new RecycleLinearViewHolder(view);
        //点击整个item时响应
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"我是 "+holder.titile.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        //点击整个item中的img时响应
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"我是img "+holder.titile.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;

    }

    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecycleLinearViewHolder holder, int position) {
        item i = (item) data.get(position);
        holder.img.setImageResource(i.imgId);
        holder.titile.setText(i.title);
        holder.content.setText(i.content);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class RecycleLinearViewHolder extends RecyclerView.ViewHolder {
    View view;
    ImageView img;
    TextView titile;
    TextView content;

    public RecycleLinearViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        img = itemView.findViewById(R.id.RecycleLinearViewItemImg);
        titile = itemView.findViewById(R.id.RecycleLinearViewItemTitle);
        content = itemView.findViewById(R.id.RecycleLinearViewItemContent);
    }
}

class item{
    int imgId;
    String title;
    String content;

    public item(int imgId, String title, String content) {
        this.imgId = imgId;
        this.title = title;
        this.content = content;
    }
}