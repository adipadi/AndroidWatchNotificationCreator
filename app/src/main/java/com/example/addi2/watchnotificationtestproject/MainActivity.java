package com.example.addi2.watchnotificationtestproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    NewMessageNotification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent intent= new Intent(this,CreateNotification.class);
        editText  = (EditText)findViewById(R.id.editText);
        notification = new NewMessageNotification();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 28.10.2017 start acitivtyForResult, to display if new message was created or canceld
                startActivity(intent);
            }
        });
    }

    //600000 gir hvert 10 minutt, 300000 gir hvert 5
    //Todo implement with AlarmManager and service/broadcast reciver
    //todo set intervall time in settings ?
    //todo let user mark whetere or not they are going to to someting presented in the notification
    public void StartNotifications(View view){
        new CountDownTimer(9000000, 60000) {
            int i=0;

            public void onTick(long millisUntilFinished) {
                notification.notify(MainActivity.this,"dette er expm stringen",i);
                editText.setText("1 minutes intervals: "+i+ " gjenstår: " + millisUntilFinished / 300000 + " i sekunder:"+millisUntilFinished);
                i++;
            }

            public void onFinish() {
                editText.setText("done!");
                i=0;
            }
        }.start();
    }



    //tries to create on last notification, in app is not killed after on pause due to memory
    @Override
    protected void onStop() {
        super.onStop();
        //TODO create one last notification if possible,
        notification.notify(MainActivity.this,"Program terminated",9999);
    }

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
