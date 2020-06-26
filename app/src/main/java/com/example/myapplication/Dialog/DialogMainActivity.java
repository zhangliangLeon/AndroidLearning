package com.example.myapplication.Dialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TimePicker;

import com.example.myapplication.R;
import com.example.myapplication.Util.ToastUtil;

import java.util.Calendar;

public class DialogMainActivity extends AppCompatActivity {

    final int NOTIFY_ID = 0x123;
    boolean[] checked = new boolean[]{false,false,false};
    int positon = 0;

    private Button AlertDialogButton_1;//normal
    private Button AlertDialogButton_2;//list
    private Button AlertDialogButton_3;//SingleChoice
    private Button AlertDialogButton_4;
    private Button AlertDialogButton_5;
    private Button TimePickerDialog;
    private Button DatePickerDialog;
    private Button PopupWindow;
    private Button NotificationButton;
    private Button BroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);

        AlertDialogButton_1 = findViewById(R.id.AlertDialogButton_1);
        AlertDialogButton_2 = findViewById(R.id.AlertDialogButton_2);
        AlertDialogButton_3 = findViewById(R.id.AlertDialogButton_3);
        AlertDialogButton_4 = findViewById(R.id.AlertDialogButton_4);
        AlertDialogButton_5 = findViewById(R.id.AlertDialogButton_5);
        TimePickerDialog = findViewById(R.id.TimePickerDialog);
        DatePickerDialog = findViewById(R.id.DatePickerDialog);
        NotificationButton = findViewById(R.id.NotificationButton);
        BroadCast = findViewById(R.id.BroadCast);

        DialogListener listener = new DialogListener();

        AlertDialogButton_1.setOnClickListener(listener);
        AlertDialogButton_2.setOnClickListener(listener);
        AlertDialogButton_3.setOnClickListener(listener);
        AlertDialogButton_4.setOnClickListener(listener);
        AlertDialogButton_5.setOnClickListener(listener);
        TimePickerDialog.setOnClickListener(listener);
        DatePickerDialog.setOnClickListener(listener);
        BroadCast.setOnClickListener(listener);

        PopupWindow = findViewById(R.id.PopupWindow);
        PopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(DialogMainActivity.this).inflate(R.layout.activity_diyalert_dialog,null);
                final EditText editText = view.findViewById(R.id.DIYAlertDialogEditText);
                Button button = view.findViewById(R.id.DIYAlertDialogButton);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showMsg(DialogMainActivity.this,editText.getText().toString());
                    }
                });
                /*
                    创建popupwindow，参数为窗口中的view内容，宽度，高度，是否可聚焦
                 */
                android.widget.PopupWindow popupWindow = new PopupWindow(view,
                        ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT,true);

                /*
                     设置popwindow显示位置，默认会将popupwindow显示再锚定view的左下
                     参数为：锚定view，x偏移，y偏移
                 */
                popupWindow.showAsDropDown(findViewById(R.id.PopupWindow),70,-600);
            }
        });

        NotificationButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                /*
                    Notification实现步骤:
                    1.调用getSystemService方法获取系统的NotificationManager服务
                    2.创建NotificationChannel对象，实现创建通知渠道
                    3.创建一个Notification对象
                    4.为Notification对象设置各种属性
                    5.通过NotificationManager的Notify方法发送Notification
                 */

                //1.调用getSystemService方法获取系统的NotificationManager服务
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //2.创建NotificationChannel对象，实现创建通知渠道 参数：id，name，重要程度
                NotificationChannel notificationChannel =
                        new NotificationChannel("1","Channel1",NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel);
                //3.创建一个Notification对象
                // 参数：Cotnext,ChannelId
                Notification.Builder notification = new Notification.Builder(DialogMainActivity.this,"1");
                //4.为Notification对象设置各种属性
                notification.setSmallIcon(R.drawable.lion);
                notification.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.lion));
                notification.setContentTitle("GoodNews");
                notification.setContentText("点击查看详情");

                notification.setWhen(System.currentTimeMillis());

                Intent intent = new Intent(DialogMainActivity.this,DetailActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(DialogMainActivity.this,0,intent,0);
                notification.setContentIntent(pendingIntent);
                //5.通过NotificationManager的Notify方法发送Notification
                notificationManager.notify(NOTIFY_ID,notification.build());
            }
        });

    }

    class DialogListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.AlertDialogButton_1:
                    AlertDialog.Builder builder_1 = new AlertDialog.Builder(DialogMainActivity.this);
                    builder_1.setIcon(R.drawable.lion)
                            .setTitle("NormalAlertDialog")
                            .setMessage("我是普通的AlertDialog")
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogMainActivity.this,"你点击了是");
                                }
                            })
                            .setNegativeButton("否", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogMainActivity.this,"你点击了否");
                                }
                            }).create().show();
                    break;
                case R.id.AlertDialogButton_2:
                    final String[] arr = new String[]{"info_1","info_2","info_3"};
                    AlertDialog.Builder builder_2 = new AlertDialog.Builder(DialogMainActivity.this);
                    builder_2.setIcon(R.drawable.lion)
                            .setTitle("列表AlertDialog")
                            .setItems(arr, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogMainActivity.this,"您选择的是"+arr[which]);
                                }
                            }).create().show();
                    break;
                case R.id.AlertDialogButton_3:
                    final String[] arr_1 = new String[]{"info_1","info_2","info_3"};
                    AlertDialog.Builder builder_3 = new AlertDialog.Builder(DialogMainActivity.this);
                    builder_3.setIcon(R.drawable.lion)
                            .setTitle("单选AlertDialog")
                            .setSingleChoiceItems(arr_1, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //这个which参数仅在当添加事件的位置为列表、单选框、复选框时可用
                                    //若是给positiveButton添加时which是无效的，必须通过一个额外的字段保存which并读取
                                    positon = which;
                                    ToastUtil.showMsg(DialogMainActivity.this,"您选择了"+arr_1[which]);
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogMainActivity.this,"您最终选择了"+arr_1[positon]);
                                }
                            }).create().show();
                    break;
                case R.id.AlertDialogButton_4:
                    final String[] arr_2 = new String[]{"info_1","info_2","info_3"};
                    AlertDialog.Builder builder_4 = new AlertDialog.Builder(DialogMainActivity.this);
                    builder_4.setIcon(R.drawable.lion)
                            .setTitle("复选AlertDialog")
                            .setMultiChoiceItems(arr_2, checked, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                   //当复选框被点击时触发
                                   //无需手动变更checked状态，会自动变更，isChecked就是当前被点击项是否被选择的状态
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String res = "[";
                                    for(int i=0 ; i<checked.length ; i++){
                                        if(checked[i] == true){
                                            res += " "+arr_2[i];
                                        }
                                    }
                                    res += " ]";
                                    ToastUtil.showMsg(DialogMainActivity.this,"您选择了"+res);
                                }
                            }).create().show();
                    break;
                case R.id.AlertDialogButton_5:
                    AlertDialog.Builder builder_5 = new AlertDialog.Builder(DialogMainActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(DialogMainActivity.this);
                    View diyView = inflater.inflate(R.layout.activity_diyalert_dialog,null);
                    final EditText editText = diyView.findViewById(R.id.DIYAlertDialogEditText);
                    Button button = diyView.findViewById(R.id.DIYAlertDialogButton);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(DialogMainActivity.this,editText.getText().toString());
                        }
                    });
                    builder_5.setTitle("自定义AlertDialog")
                            .setView(diyView)
                            .create().show();
                    break;
                case R.id.TimePickerDialog:
                    Calendar calendar = Calendar.getInstance();
                    new TimePickerDialog(DialogMainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            ToastUtil.showMsg(DialogMainActivity.this,"您选择了"+hourOfDay+"时"+minute+"分");
                        }
                    }
                    ,calendar.get(Calendar.HOUR)
                    ,calendar.get(Calendar.MINUTE)
                    ,true).show();
                    break;
                case R.id.DatePickerDialog:
                    Calendar calendar1 = Calendar.getInstance();
                    new DatePickerDialog(DialogMainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            ToastUtil.showMsg(DialogMainActivity.this,"您选择了"+year+"年"+month+"月"+dayOfMonth+"日");
                        }
                    }
                    ,calendar1.get(Calendar.YEAR)
                    ,calendar1.get(Calendar.MONTH)
                    ,calendar1.get(Calendar.DAY_OF_MONTH)).show();
                    break;
                case R.id.BroadCast:
                    Intent intent = new Intent(DialogMainActivity.this,BroadCastActivity.class);
                    startActivity(intent);
            }
        }
    }
}
