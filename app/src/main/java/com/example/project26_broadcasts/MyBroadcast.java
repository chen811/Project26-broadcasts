package com.example.android26_broadcasts;

import static com.example.android26_broadcasts.MainActivity.Intent01;
import static com.example.android26_broadcasts.MainActivity.Intent02;
import static com.example.android26_broadcasts.MainActivity.MyFilter01;
import static com.example.android26_broadcasts.MainActivity.MyFilter02;

import android.content.Context;
import android.content.Intent;

public class MyBroadcast {
    public MyBroadcast(int buttonId, Context context) {
        Intent intent = new Intent();
        /**發出廣播*/
        switch (buttonId){
            case R.id.btAction01:
                intent.setAction(MyFilter01);
                intent.putExtra(Intent01,"這邊是Action01");
                context.sendBroadcast(intent);
                break;
            case R.id.btAction02:
                intent.setAction(MyFilter02);
                intent.putExtra(Intent02,"這邊是Action02");
                context.sendBroadcast(intent);
                break;
        }
    }
}
