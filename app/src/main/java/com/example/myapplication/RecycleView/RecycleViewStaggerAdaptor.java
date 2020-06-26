package com.example.myapplication.RecycleView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecycleViewStaggerAdaptor extends RecyclerView.Adapter<staggerViewHolder> {
    private Context mContext;
    private ArrayList<String> contentList;
    private ArrayList<Integer> heightList;
    public RecycleViewStaggerAdaptor(Context context,ArrayList<String> contentList,ArrayList<Integer> heightList){
        mContext = context;
        this.contentList = contentList;
        this.heightList = heightList;
    }

    @NonNull
    @Override
    public staggerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.activity_recycler_view_stagger_item,parent,false);
        staggerViewHolder viewHolder = new staggerViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final staggerViewHolder holder, final int position) {
        if(position%2 == 0)
            holder.getContent().setBackgroundColor(Color.parseColor("#EEEE00"));
        else
            holder.getContent().setBackgroundColor(Color.parseColor("#FF00FF"));
        holder.getContent().setText(contentList.get(position));

        holder.getContent().getLayoutParams().height = heightList.get(position);

        holder.getContent().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"This is content_"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }
}
class staggerViewHolder extends RecyclerView.ViewHolder{
    TextView content;
    public staggerViewHolder(@NonNull View itemView) {
        super(itemView);
        content = itemView.findViewById(R.id.RecycleStaggerViewContent);
    }

    public TextView getContent() {
        return content;
    }
}


