package com.example.addi2.watchnotificationtestproject;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Application;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;

import java.util.Random;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    //creates this so that the instance of the service-started broadcast can be called and stopped from mainActivity
    public static MyIntentService myIntentService;
    private static final String ACTION_BROADCAST="com.example.addi2.watchnotificationtestproject.action.BROADCAST";
    private static Intent messageIntent;
    private static PendingIntent pendingIntent;
    private static NewMessageNotification notification;


    public MyIntentService() {
        super("MyIntentService");
        myIntentService=this;
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BROADCAST);
        context.startService(intent);
    }

    //whenever a intent is received, do this and check the action
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_BROADCAST.equals(action)) {
                handleActionFoo();
            }
        }
    }

    /**
     * Handle ACTION_BROADCAST in the provided background thread with the provided
     * parameters.
     */
    @TargetApi(19)
    private void handleActionFoo() {
        //intent to be broadcasted by the system
        messageIntent = new Intent(this, MyReceiver.class);
        //description of intent and action to preforme with it
        pendingIntent = PendingIntent.getBroadcast(this, 0, messageIntent, 0);

        //TODO random selection of notification content from local storage
        final int min = 0;
        final int max = 2;
        Random random = new Random();
        int randomNum = random.nextInt((max - min) + 1) + min;
        String [] list=new String[]{"TIPS 1","TIPS 2","TIPS 3"};

        notification = new NewMessageNotification();
        notification.notify(this,list[randomNum],1);

        AlarmManager manager = (AlarmManager) getSystemService(this.ALARM_SERVICE);
        //every 10 min, change last var to adjust this
        long interval = 1000 * 60 * 10;
        //time to next broadcast
        long nextBroadcastTime=System.currentTimeMillis()+interval;
        //this alarmManager schedules the time interval of the pending intent to be executed
        manager.setWindow(AlarmManager.RTC_WAKEUP,nextBroadcastTime,interval,pendingIntent);
    }

    //cancel broadcast, flag makes sure it is canceled if it exist
    protected void CancelBroadcast() {
        PendingIntent.getBroadcast(this, 0, messageIntent, PendingIntent.FLAG_UPDATE_CURRENT).cancel();
    }
}
