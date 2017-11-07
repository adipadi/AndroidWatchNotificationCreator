package com.example.addi2.watchnotificationtestproject;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    NewMessageNotification notification;
    private static String ACTION_BROADCAST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText  = (EditText)findViewById(R.id.editText);
        ACTION_BROADCAST=this.getString(R.string.ACTION_BROADCAST);

        final Intent intent= new Intent(this,CreateNotification.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 28.10.2017 start acitivtyForResult, to display if new message was created or canceld
                startActivity(intent);
            }
        });
    }

    /*
    Note: If your app targets API level 26 or higher, the system imposes restrictions on running background
    services when the app itself is not in the foreground. In most cases like this, your app should use a
    scheduled job instead. går muligens greit siden jeg kjører en pending broadcast
     */
    //starts the service that will print notifications and then call a pending broadcast, that will call the service again later
    //this is done in a service because if run in a activity with ui, the app will be moved to the foreground whenever broadcast recives
    public void StartNotifications(View view){
        Toast.makeText(MainActivity.this, "Starting service", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this,MyIntentService.class);
        i.setAction(ACTION_BROADCAST);
        startService(i);
    }

    public void StopNotifications(View view){
       MyIntentService.myIntentService.CancelBroadcast();
        //TODO stop the service?
        //TODO does startNotificaiton start several services _> check prosse
        /*
        Services of the same manifest declaration i.e. service name=".MyIntentService"
        (and this is the same for normal Services) run as a singleton within their process,
        so until the Service is killed the same Service will receive additional start requests.

         So i might have to change the description above startNotification and in myIntentService. since this service is declated in
         the manifest file (automaticaly when created in android studio, i can add several broadcasts to a queue, but on stop removes
         them all?
         */
        // TODO does it start several broadcasters -> testable easy enough
    }



    //----------------Menu related-------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
