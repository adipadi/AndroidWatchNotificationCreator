package com.example.addi2.watchnotificationtestproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateNotification extends AppCompatActivity {
    Intent mainAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notification);
        mainAct=new Intent(this,MainActivity.class);
    }

    public void SaveContent(View view){
        //TempDatabase.getInstance().getNotifyList().add();
        startActivity(mainAct);
    }


        public void CancelContent(View view){
        startActivity(mainAct);
    }
}
