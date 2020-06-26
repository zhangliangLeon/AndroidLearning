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

public class RecycleLinearAdaptor extends RecyclerView.Adapter<RecycleLinearViewItem> {

    private Context mContext;
    private List<String> TitleList;
    private List<String> ContentList;
    private List<Integer> HeightList;
    public RecycleLinearAdaptor(Context context,List<String> TitleList,List<String> ContentList,List<Integer> HeightList){
        this.mContext = context;
        this.TitleList = TitleList;
        this.ContentList = ContentList;
        this.HeightList = HeightList;
    }
    @NonNull
    @Override
    public RecycleLinearViewItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_recycle_linear_view_item,parent,false);
        RecycleLinearViewItem holder = new RecycleLinearViewItem(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleLinearViewItem holder, final int position) {//设置item数据
        //设置内容
        holder.getTitle().setText(TitleList.get(position));
        holder.getContent().setText(ContentList.get(position));
        //设置监听器
        holder.getTitle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"click:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return TitleList.size();
    }
}
class RecycleLinearViewItem extends RecyclerView.ViewHolder{

    private ImageView Img;
    private TextView Title;
    private TextView Content;
    public RecycleLinearViewItem(@NonNull View itemView) {//itemView即每一条数据的view
        super(itemView);
        Img = itemView.findViewById(R.id.RecycleLinearViewItemImg);
        Title = itemView.findViewById(R.id.RecycleLinearViewItemTitle);
        Content = itemView.findViewById(R.id.RecycleLinearViewItemContent);
    }

    public ImageView getImg() {
        return Img;
    }

    public TextView getTitle() {
        return Title;
    }

    public TextView getContent() {
        return Content;
    }
}
