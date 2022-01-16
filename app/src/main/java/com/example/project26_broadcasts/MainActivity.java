package com.example.project26_broadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private BroadcastResult broadcast = new BroadcastResult();
    public static final String MyFilter01 = "action01";
    public static final String MyFilter02 = "action02";
    public static final String Intent01 = "intent01";
    public static final String Intent02 = "intent02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**建立廣播過濾器*/
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyFilter01);
        intentFilter.addAction(MyFilter02);
        /**註冊廣播*/
        registerReceiver(broadcast, intentFilter);

        /**Button相關*/
        Button bt01 = findViewById(R.id.btAction01)
                , bt02= findViewById(R.id.btAction02);
        bt01.setOnClickListener(v->{
            new com.example.android26_broadcasts.MyBroadcast(R.id.btAction01,this);
        });

        bt02.setOnClickListener(v->{
            new com.example.android26_broadcasts.MyBroadcast(R.id.btAction02,this);
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        /**取消註冊廣播*/
        unregisterReceiver(broadcast);
    }

    private class BroadcastResult extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            /**這邊接收來自Broadcast回傳*/
            String mAction = intent.getAction();
            TextView tvResult = findViewById(R.id.tvResult);
            assert mAction != null;
            String msg;
            switch (mAction) {
                case MyFilter01:
                    msg = intent.getStringExtra(Intent01);
                    tvResult.setText(msg);
                    break;
                case MyFilter02:
                    msg = intent.getStringExtra(Intent02);
                    tvResult.setText(msg);
                    break;
            }
        }
    }
}