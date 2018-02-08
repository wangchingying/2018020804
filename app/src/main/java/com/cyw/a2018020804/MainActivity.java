package com.cyw.a2018020804;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
    }
    //註冊reciever
    public void click1(View v)
    {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);//觸發不是按click3,是打開螢幕
        filter.addAction("actionon");
        filter.setPriority(500);
        registerReceiver(receiver, filter);
    }
    //解除Reciever
    public void click2(View v)
    {
        unregisterReceiver(receiver);
    }
    //觸發事件
    public void click3(View v)
    {
        Intent intent = new Intent("actionon");//這個是用按鈕觸發自己設定的action
        sendBroadcast(intent);
    }
}
