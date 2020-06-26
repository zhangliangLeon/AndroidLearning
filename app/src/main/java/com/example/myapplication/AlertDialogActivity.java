package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Util.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {

    private Button AlertDialog_1;
    private Button AlertDialog_2;
    private Button AlertDialog_3;
    private Button AlertDialog_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);



        AlertDialog_1 = findViewById(R.id.AlertDialog_1);
        AlertDialog_2 = findViewById(R.id.AlertDialog_2);
        AlertDialog_3 = findViewById(R.id.AlertDialog_3);
        AlertDialog_4 = findViewById(R.id.AlertDialog_4);

        AlertDialog_1.setOnClickListener(new OnClick());
        AlertDialog_2.setOnClickListener(new OnClick());
        AlertDialog_3.setOnClickListener(new OnClick());
        AlertDialog_4.setOnClickListener(new OnClick());


    }
    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.AlertDialog_1:
                    final AlertDialog.Builder builder_1 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder_1.setTitle("问题");
                    builder_1.setMessage("你喜欢毛不易吗");
                    builder_1.setPositiveButton("喜欢", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"喜欢");
                            dialog.cancel();
                        }
                    });
                    builder_1.setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"不喜欢");
                            //关闭对话框
                            dialog.cancel();
                        }
                    });
                    builder_1.show();
                    break;
                case R.id.AlertDialog_2:
                    final String[] gender = new String[]{"男","女"};
                    AlertDialog.Builder builder_2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder_2.setTitle("单选框");
                    //builder_2.setMessage("性别:");
                    builder_2.setSingleChoiceItems(gender,1,new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,gender[which]);
                        }
                    });
                    builder_2.show();
                    break;
                case R.id.AlertDialog_3:
                    final String[] habbit = new String[]{"唱歌","跳舞","篮球"};
                    boolean[] checked = new boolean[]{false,false,true};
                    AlertDialog.Builder builder_3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder_3.setTitle("多选框");
                    //builder_3.setMessage("兴趣爱好");
                    builder_3.setMultiChoiceItems(habbit, checked, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(AlertDialogActivity.this,habbit[which]+" is "+isChecked);
                        }
                    });
                    builder_3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder_3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    //点击其他空白地方弹框不会取消
                    builder_3.setCancelable(false);
                    builder_3.show();
                    break;
                case R.id.AlertDialog_4:
                    AlertDialog.Builder builder_4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(AlertDialogActivity.this);
                    final View Login = inflater.inflate(R.layout.activity_edit_text_view,null);

                    Button LoginButton = Login.findViewById(R.id.Login_Button);
                    LoginButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            EditText account = Login.findViewById(R.id.account_text);
                            EditText password = Login.findViewById(R.id.password_text);
                            String msg = "Account : "+account.getText().toString()+"\n"+"Password : "+password.getText().toString();
                            ToastUtil.showMsg(AlertDialogActivity.this,msg);
                        }
                    });
                    builder_4.setView(Login);
                    builder_4.setTitle("Login");
                    builder_4.show();
                    break;
            }

        }
    }
}
