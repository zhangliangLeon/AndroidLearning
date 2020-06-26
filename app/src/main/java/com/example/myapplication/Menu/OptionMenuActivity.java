package com.example.myapplication.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

public class OptionMenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
    }
    //创建OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //通过MenuInflater，解析菜单文件
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //OptionMenu上的item被点击时触发
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.setting){
            ToastUtil.showMsg(this,"我是setting");
        }else if(item.getItemId() == R.id.regard){
            Toast.makeText(this,"我是regard",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
