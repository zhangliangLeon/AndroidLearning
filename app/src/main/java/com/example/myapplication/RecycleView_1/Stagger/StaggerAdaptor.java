package com.example.myapplication.RecycleView_1.Stagger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import com.example.myapplication.Util.ToastUtil;

public class StaggerAdaptor extends RecyclerView.Adapter<StaggerAdaptor.MyViewHolder> {
    final int[] imgs = new int[]{R.mipmap.pic1,R.mipmap.pic2,R.mipmap.pic3,R.mipmap.pic4,R.mipmap.pic5,R.mipmap.pic6};
    final int[] names = new int[]{R.string.name_1,R.string.name_2,R.string.name_3,R.string.name_4,R.string.name_5,R.string.name_6};
    final int[] infos = new int[]{R.string.info_1,R.string.info_2,R.string.info_3,R.string.info_4,R.string.info_5,R.string.info_6};

    Context mContext;


    public StaggerAdaptor(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public StaggerAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_recycle_item,parent,false);
        StaggerAdaptor.MyViewHolder holder = new StaggerAdaptor.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaggerAdaptor.MyViewHolder holder, final int position) {
        holder.img.setImageResource(imgs[position]);
        holder.name.setText(names[position]);
        holder.info.setText(infos[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(mContext,"您点击了第"+position+"条记录\n");
            }
        });
        //获取随机高度
        double height = getRandomHeight();
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = (int)height;
        holder.itemView.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
    public double getRandomHeight(){
        return 200 + Math.random()*100;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView info;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_1);
            name = itemView.findViewById(R.id.name_1);
            info = itemView.findViewById(R.id.info_1);
        }
    }
}




