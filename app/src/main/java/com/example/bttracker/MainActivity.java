package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
