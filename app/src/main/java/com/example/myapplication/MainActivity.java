package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.AIDLTest.AidlActivity;
import com.example.myapplication.ActionBar.ActionBarMainActivity;
import com.example.myapplication.Animation.AnimationMainActivity;
import com.example.myapplication.Broadcast.BroadcastReceiverActivity;
import com.example.myapplication.Camera.CameraMainActivity;
import com.example.myapplication.DataStorage.DataStorageActivity;
import com.example.myapplication.Dialog.DialogMainActivity;
import com.example.myapplication.DiyViews.ActionBar.UseActionBarActivity;
import com.example.myapplication.Drawable.DrawableMainActivity;
import com.example.myapplication.Fragment.FragmentContainerActivity;
import com.example.myapplication.Fragment.FragmentContainer_1Activity;
import com.example.myapplication.Fragment.FragmentTestContainerActivity;
import com.example.myapplication.FragmentLearning_new.FragmentMainActivity;
import com.example.myapplication.FragmentLearning_new.newsclient.NewsMainActivity;
import com.example.myapplication.GridView.GridViewActivity;
import com.example.myapplication.HandlerService.StartServiceTestActivity;
import com.example.myapplication.Intent.IntentFilterMainActivity;
import com.example.myapplication.Intent.IntentPassBackMsgMainActivity;
import com.example.myapplication.Intent.IntentPassForwardMsgMainActivity;
import com.example.myapplication.Intent.IntentTestActivity;
import com.example.myapplication.Internet.InternetMainActivity;
import com.example.myapplication.ListView.ListViewMainActivity;
import com.example.myapplication.Media.MediaMainActivity;
import com.example.myapplication.Menu.MenuMainActivity;
import com.example.myapplication.Paint.DrawMainActivity;
import com.example.myapplication.RecycleView.RecycleViewMainActivity;
import com.example.myapplication.RecycleView_1.RecycleView_1Activity;
import com.example.myapplication.ServiceTest.StartService.StartServiceActivity;
import com.example.myapplication.ServiceTest.bindService.BindServiceTestActivity;
import com.example.myapplication.ServiceTest.intentService.IntentServiceActivity;
import com.example.myapplication.Util.ToastUtil;
import com.example.myapplication.handleTest.ChildThreadChangeUIActivity;
import com.example.myapplication.handleTest.HandleTest_1;

public class MainActivity extends AppCompatActivity {

    private Button TextViewBtn;
    private Button ButtonButton;
    private Button EditTextViewButton;
    private Button RadioButton;
    private Button CheckBoxButton;
    private Button ImgViewButton;
    private Button ListViewButton;
    private Button GridViewButton;
    private Button RecycleViewButton;
    private Button WebViewButton;
    private Button AlertDialogButton;
    private Button StartActivityForResButton;
    private Button FragmentButton;
    private Button FragmentButton_1;
    private Button ClickEventButton;
    private Button MyButtonButton;
    private Button HandlerButton;
    private Button DataStorageButton;
    private Button BroadcastButton;
    private Button SwitchButtonButton;
    private Button ProcessBarButton;
    private Button ImageSwitcherButton;
    private Button SpinnerButton;
    private Button ViewFlipperButton;
    private Button DrawerLayoutButton;
    private Button SwipeRefreshLayoutButton;
    private Button RecycleView_1Button;
    private Button IntentTestButton;
    private Button IntentFilterTestButton;
    private Button IntentPassForwardMsgButton;
    private Button IntentPassBackMsgButton;
    private Button FragmentTestButton;
    private Button OnTouchOnClickDiffButton;
    private Button GuestureButton;
    private Button MenuButton;
    private Button DrawableButton;
    private Button ActionBarButton;
    private Button DialogButton;
    private Button DrawMainButton;
    private Button AnimationButton;
    private Button MediaButton;
    private Button CameraButton;
    private Button StartServiceButton;
    private Button SensorButton;
    private Button Service_1Button;
    private Button InternetButton;
    private Button AdHandlerButton;
    private Button StartServiceButton_1;
    private Button BindServiceButton_1;
    private Button IntentServiceButton;
    private Button ChildThreadChangeUiButton;
    private Button diyActionBarButton;
    private Button FragmentNewButton;
    private Button NewsClientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextViewBtn = findViewById(R.id.TextViewButton);
        TextViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
                startActivity(intent);
            }
        });

        ButtonButton = findViewById(R.id.ButtonButton);
        ButtonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ButtonActivity.class);
                startActivity(intent);
            }
        });

        EditTextViewButton = findViewById(R.id.EditTextViewButton);
        EditTextViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditTextViewActivity.class);
                startActivity(intent);
            }
        });

        RadioButton = findViewById(R.id.RadioButton);
        RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,RadioActivity.class);
                startActivity(intent);
            }
        });

        CheckBoxButton = findViewById(R.id.CheckboxButton);
        CheckBoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,CheckBoxActivity.class);
                startActivity(intent);
            }
        });

        ImgViewButton = findViewById(R.id.ImgViewButton);
        ImgViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ImgViewActivity.class);
                startActivity(intent);
            }
        });

        ListViewButton = findViewById(R.id.ListViewButton);
        ListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewMainActivity.class);
                startActivity(intent);
            }
        });

        GridViewButton = findViewById(R.id.GridViewButton);
        GridViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                startActivity(intent);
            }
        });

        RecycleViewButton = findViewById(R.id.RecycleViewButton);
        RecycleViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecycleViewMainActivity.class);
                startActivity(intent);
            }
        });

        WebViewButton = findViewById(R.id.WebViewButton);
        WebViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });

        AlertDialogButton = findViewById(R.id.AlertDialogButton);
        AlertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlertDialogActivity.class);
                startActivity(intent);
            }
        });

        StartActivityForResButton = findViewById(R.id.StartActivityForResButton);
        StartActivityForResButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StartActivityForResActivity.class);
                //startActivity(intent);
                //传入两个参数，要跳转的intent，以及intent返回值的编码（自定义的）
                startActivityForResult(intent,0);
            }
        });

        FragmentButton = findViewById(R.id.FragmentButton);
        FragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentContainerActivity.class);
                startActivity(intent);
            }
        });

        FragmentButton_1 = findViewById(R.id.FragmentButton_1);
        FragmentButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentContainer_1Activity.class);
                startActivity(intent);
            }
        });

        ClickEventButton = findViewById(R.id.ClickEvent);
        ClickEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ClickEventActivity.class);
                startActivity(intent);
            }
        });

        MyButtonButton = findViewById(R.id.MyButtonButton);
        MyButtonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyButtonActivity.class);
                startActivity(intent);
            }
        });

        HandlerButton = findViewById(R.id.HandlerButton);
        HandlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });

        DataStorageButton = findViewById(R.id.DataStorageButton);
        DataStorageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataStorageActivity.class);
                startActivity(intent);
            }
        });

        BroadcastButton = findViewById(R.id.BroadcastButton);
        BroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BroadcastReceiverActivity.class);
                startActivity(intent);
            }
        });

        SwitchButtonButton = findViewById(R.id.SwitchButtonButton);
        SwitchButtonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SwitchButtonActivity.class);
                startActivity(intent);
            }
        });

        ProcessBarButton = findViewById(R.id.ProcessBarButton);
        ProcessBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProcessBarActivity.class);
                startActivity(intent);
            }
        });

        ImageSwitcherButton = findViewById(R.id.ImageSwitcherButton);
        ImageSwitcherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ImageSwitcherActivity.class);
                startActivity(intent);
            }
        });

        SpinnerButton = findViewById(R.id.SpinnerButton);
        SpinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SpinnerActivity.class);
                startActivity(intent);
            }
        });

        ViewFlipperButton = findViewById(R.id.ViewFlipperButton);
        ViewFlipperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewFlipper.class);
                startActivity(intent);
            }
        });

        DrawerLayoutButton = findViewById(R.id.DrawerLayoutButton);
        DrawerLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DrawerLayoutActivity.class);
                startActivity(intent);
            }
        });

        SwipeRefreshLayoutButton = findViewById(R.id.SwipeRefreshLayoutButton);
        SwipeRefreshLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SwipeRefreshLayoutActivity.class);
                startActivity(intent);
            }
        });

        RecycleView_1Button = findViewById(R.id.RecycleView_1Button);
        RecycleView_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecycleView_1Activity.class);
                startActivity(intent);

            }
        });

        IntentTestButton = findViewById(R.id.IntentTestButton);
        IntentTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentTestActivity.class);
                startActivity(intent);
            }
        });

        IntentFilterTestButton = findViewById(R.id.IntentFilterTestButton);
        IntentFilterTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentFilterMainActivity.class);
                startActivity(intent);
            }
        });

        IntentPassForwardMsgButton = findViewById(R.id.IntentPassForwardMsgButton);
        IntentPassForwardMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentPassForwardMsgMainActivity.class);
                startActivity(intent);
            }
        });


        IntentPassBackMsgButton = findViewById(R.id.IntentPassBackMsgButton);
        IntentPassBackMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentPassBackMsgMainActivity.class);
                startActivity(intent);
            }
        });

        FragmentTestButton = findViewById(R.id.FragmentTestButton);
        FragmentTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentTestContainerActivity.class);
                startActivity(intent);
            }
        });

        OnTouchOnClickDiffButton = findViewById(R.id.OnTouchOnClickDiffButton);
        OnTouchOnClickDiffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClick","点击事件");
            }
        });
        OnTouchOnClickDiffButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.i("onTouch","Action_Down");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    Log.i("onTouch","Action_Up");
                }
                return false;//不消耗掉该事件
            }
        });

        GuestureButton = findViewById(R.id.GuestureButton);
        GuestureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GustureActivity.class);
                startActivity(intent);
            }
        });

        MenuButton = findViewById(R.id.MenuButton);
        MenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Intent intent = new Intent(MainActivity.this, MenuMainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        DrawableButton = findViewById(R.id.DrawableButton);
        DrawableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawableMainActivity.class);
                startActivity(intent);
            }
        });

        ActionBarButton = findViewById(R.id.ActionBarButton);
        ActionBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActionBarMainActivity.class);
                startActivity(intent);
            }
        });

        DialogButton = findViewById(R.id.DialogButton);
        DialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogMainActivity.class);
                startActivity(intent);
            }
        });


        DrawMainButton = findViewById(R.id.DrawMainButton);
        DrawMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawMainActivity.class);
                startActivity(intent);
            }
        });

        AnimationButton = findViewById(R.id.AnimationButton);
        AnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimationMainActivity.class);
                startActivity(intent);
            }
        });

        MediaButton = findViewById(R.id.MediaButton);
        MediaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MediaMainActivity.class);
                startActivity(intent);
            }
        });

        CameraButton = findViewById(R.id.CameraButton);
        CameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraMainActivity.class);
                startActivity(intent);
            }
        });

        StartServiceButton = findViewById(R.id.StartServiceButton);
        StartServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartServiceTestActivity.class);
                startActivity(intent);
            }
        });

        SensorButton = findViewById(R.id.SensorButton);
        SensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SensorActivity.class);
                startActivity(intent);
            }
        });

        Service_1Button = findViewById(R.id.Service_1Button);
        Service_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AidlActivity.class);
                startActivity(intent);
            }
        });

        InternetButton = findViewById(R.id.InternetButton);
        InternetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InternetMainActivity.class);
                startActivity(intent);
            }
        });

        AdHandlerButton = findViewById(R.id.AdHandlerButton);
        AdHandlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HandleTest_1.class);
                startActivity(intent);
            }
        });

        StartServiceButton_1 = findViewById(R.id.StartServiceButton_1);
        StartServiceButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartServiceActivity.class);
                startActivity(intent);
            }
        });

        BindServiceButton_1 = findViewById(R.id.BindServiceButton_1);
        BindServiceButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BindServiceTestActivity.class);
                startActivity(intent);
            }
        });

        IntentServiceButton = findViewById(R.id.IntentServiceButton);
        IntentServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentServiceActivity.class);
                startActivity(intent);
            }
        });

        ChildThreadChangeUiButton = findViewById(R.id.ChildThreadChangeUiButton);
        ChildThreadChangeUiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChildThreadChangeUIActivity.class);
                startActivity(intent);
            }
        });

        diyActionBarButton = findViewById(R.id.diyActionBarButton);
        diyActionBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UseActionBarActivity.class);
                startActivity(intent);
            }
        });

        FragmentNewButton = findViewById(R.id.FragmentNewButton);
        FragmentNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentMainActivity.class);
                startActivity(intent);
            }
        });

        NewsClientButton = findViewById(R.id.NewsClientButton);
        NewsClientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsMainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        ToastUtil.showMsg(MainActivity.this,"ReturnKey:"+data.getStringExtra("ReturnKey"));
        super.onActivityResult(requestCode, resultCode, data);
    }
}
