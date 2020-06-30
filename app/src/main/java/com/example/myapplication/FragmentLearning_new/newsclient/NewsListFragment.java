package com.example.myapplication.FragmentLearning_new.newsclient;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class NewsListFragment extends Fragment {
    private boolean isTwoTab;
    private List<News> data = new ArrayList<>();
    private RecyclerView newsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_list,container,false);
        initData();
        //找到newslist的recycleView
        newsList = view.findViewById(R.id.newslist);

        //创建适配器并添加
        newsAdaptor adaptor = new newsAdaptor(getContext(),data);
        newsList.setAdapter(adaptor);

        //创建布局管理器并添加
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        newsList.setLayoutManager(linearLayoutManager);

        newsList.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //确保与frgment关联的activity被创建时调用
        super.onActivityCreated(savedInstanceState);

        //如果当前活动中包含news_detail_area那么表示为双屏
        if(getActivity().findViewById(R.id.news_detail_area) == null){
            isTwoTab = false;
        }else{
            isTwoTab = true;
        }
    }

    public void initData(){
        for(int i=0 ;i<10;i++){
            data.add(new News("title_"+i,"content_"+i));
        }
    }

    class newsAdaptor extends RecyclerView.Adapter<viewHolder>{

        Context context;
        List<News> data;

        public newsAdaptor(Context context,List<News> data){
            this.context = context;
            this.data = data;
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(context).inflate(R.layout.activity_new_list_item,parent,false);
            final viewHolder holder = new viewHolder(view);
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = data.get(holder.getAdapterPosition());
                    if(isTwoTab){
                        //更改双页详情
                        NewsDetailFragment fragment = (NewsDetailFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.news_detail_area);
                        if(fragment == null){
                            //如果是第一次触发点击事件，那么此时detail的fragment还没有被创建，需要进行创建并赋值
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            //由于fragmentManger的任务都是异步执行的，所以希望立马执行的话需要添加executePendingTransactions
                            fragmentManager.beginTransaction().add(R.id.news_detail_area,new NewsDetailFragment()).commit();
                            fragmentManager.executePendingTransactions();

                            fragment = (NewsDetailFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.news_detail_area);
                        }
                        //刷新fragment数据
                        fragment.refresh(news.getTitle(),news.getContent());
                    }else{
                        //跳转到单页详情
                        Log.d("NewsListFragment", "单页跳转");
                        NewsDetailForOnePageActivity.actionStart(context,news.getTitle(),news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            News item = data.get(position);
            holder.title.setText(item.title);
            holder.content.setText(item.content);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
    class viewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        View view;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            title = itemView.findViewById(R.id.item_title);
            content = itemView.findViewById(R.id.item_content);

        }
    }

}
