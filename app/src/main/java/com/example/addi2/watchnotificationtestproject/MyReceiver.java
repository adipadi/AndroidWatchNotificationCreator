package com.example.addi2.watchnotificationtestproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String ACTION_BROADCAST="com.example.addi2.watchnotificationtestproject.action.BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "ON RECIVED", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(context,MyIntentService.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //i.putExtra("fromBroadcaster","startNewMethod");
        //context.startActivity(i);
        i.setAction(ACTION_BROADCAST);
        context.startService(i);
    }
}
