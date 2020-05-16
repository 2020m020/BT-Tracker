package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HandlingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handling);
    }

    public void goToLink2(View view) {
        Intent toLink2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/how-to-break-a-fever"));
        startActivity(toLink2);
    }
}
