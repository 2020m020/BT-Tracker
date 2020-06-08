package com.example.bttracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainButton1 = findViewById(R.id.MainButton1);
        mainButton1.setOnClickListener(this);

        TextView mainButton2 = findViewById(R.id.MainButton2);
        mainButton2.setOnClickListener(this);

        TextView mainButton3 = findViewById(R.id.MainButton3);
        mainButton3.setOnClickListener(this);

        TextView mainButton4 = findViewById(R.id.MainButton4);
        mainButton4.setOnClickListener(this);

        createNotificationChannel();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MainButton1:
                Intent toLog = new Intent(this, LogActivity.class);
                startActivity(toLog);
                break;
            case R.id.MainButton2:
                Intent toNormal = new Intent(this, NormalActivity.class);
                startActivity(toNormal);
                break;
            case R.id.MainButton3:
                Intent toMechanism = new Intent(this, MechanismActivity.class);
                startActivity(toMechanism);
                break;
            case R.id.MainButton4:
                Intent openFeverLink = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.healthline.com/health/how-to-break-a-fever"));
                if (openFeverLink.resolveActivity(getPackageManager()) != null) {
                    startActivity(openFeverLink);
                    break;
                }
        }


    }


    public void SetReminder(View view) {
        Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
        PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long interval = 1000 * 6;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pd);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelIDescription = "Channel for BT Tracker reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID, channelName, importance);
            channel.setDescription(channelIDescription);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


        }
    }
}
