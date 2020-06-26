package com.example.myapplication.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

public class ContextMenuActivity extends AppCompatActivity {

    RecyclerView FriendCircles;
    FriendCircleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        FriendCircles = findViewById(R.id.FirendCircles);
        //给recyclerlayout设置布局管理器
        FriendCircles.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        //给recyclerlayout设置适配器
        adapter = new FriendCircleAdapter(this);
        FriendCircles.setAdapter(adapter);

    }

    //当点击上下文事件中的item时会调用下面的方法
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //getPosition和getNickName方法是自己在adpter中写的
        //点击item时，可以从adapter中获取当前到底是在哪个item上获取的上下文菜单
        int position = adapter.getPosition();
        String nickName = adapter.getNickName(position);

        if(item.getItemId() == R.id.copy){
            ToastUtil.showMsg(this,nickName+"复制");
        }else if(item.getItemId() == R.id.traslate){
            ToastUtil.showMsg(this,nickName+"翻译");
        }
        return super.onContextItemSelected(item);
    }
}

//adptor
class FriendCircleAdapter extends RecyclerView.Adapter<FriendCircleViewHolder>{
    //mPosition用于标记长按的位置
    int mPosition = 0;
    //具体的数据
    int[] imgs = new int[]{R.mipmap.pic1,R.mipmap.pic2,R.mipmap.pic3};
    String[] nicknames = new String[]{"NickName_1","NickName_2","NickName_3"};
    String[] content = new String[]{"content_1","content_2","conten_3"};

    Context mContext;


    public FriendCircleAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public FriendCircleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.activity_friend_circle,parent,false);
        return new FriendCircleViewHolder(view,mContext);
    }

    //当item被长按时要实时更新当前点击的位置信息，所以采用添加长按监听器实现
    @Override
    public void onBindViewHolder(final @NonNull FriendCircleViewHolder holder, final int position) {
        holder.friendCircleImg.setImageResource(imgs[position]);
        holder.friendCirclenickname.setText(nicknames[position]);
        holder.frienCirclecontet.setText(content[position]);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //长按则变更当前位置
                mPosition = holder.getAdapterPosition();
                //这里要返回false否则长按事件就被销毁了，上下文菜单就无法接收响应显示了
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return imgs.length;
    }

    //提供获取position方法
    public int getPosition(){
        return mPosition;
    }
    public String getNickName(int position){
        return nicknames[position];
    }
}

//viewholder
class FriendCircleViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
    ImageView friendCircleImg;
    TextView friendCirclenickname;
    TextView frienCirclecontet;
    Context mcontext;

    //需要给每一个itemview添加contextmenu响应
    public FriendCircleViewHolder(@NonNull View itemView,Context context) {
        super(itemView);
        mcontext = context;
        friendCircleImg = itemView.findViewById(R.id.friendCircleImg);
        friendCirclenickname = itemView.findViewById(R.id.friendCirclenickname);
        frienCirclecontet = itemView.findViewById(R.id.firenCirclecontet);

        //将itemview上放置contextmenu监听器，即长按itemview会弹出来contextmenu
        itemView.setOnCreateContextMenuListener(this);
    }

    //创建contextmenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = new MenuInflater(mcontext);
        menuInflater.inflate(R.menu.contextmenu,menu);
    }
}
