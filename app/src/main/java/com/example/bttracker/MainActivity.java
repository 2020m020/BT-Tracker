package com.example.bttracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    public void goToLogActivity(View view) {
        Intent toLog = new Intent(this,LogActivity.class);
        startActivity(toLog);
    }

    public void goToNormalActivity(View view) {
        Intent toNormal = new Intent(this,NormalActivity.class);
        startActivity(toNormal);
    }

    public void goToMechanism(View view) {
        Intent toMechanism = new Intent(this,MechanismActivity.class);
        startActivity(toMechanism);
    }

    public void goToHandle(View view) {
        Intent toHandle = new Intent(this,HandlingActivity.class);
        startActivity(toHandle);
    }

    public void SetReminder(View view) {
        Toast.makeText(this,"Reminder set!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ReminderBroadcastReceiver.class);
        PendingIntent pd = PendingIntent.getBroadcast(this,0,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        long interval = 1000*6;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),interval,pd);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelID ="BT_Tracker_Channel";
            String channelName="BTTrackerReminderChannel";
            String channelIDescription="Channel for BT Tracker reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel= new NotificationChannel(channelID,channelName,importance);
            channel.setDescription(channelIDescription);
            NotificationManager notificationManager= getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);



        }
    }
}
