package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MechanismActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanism);
    }

    public void gotToLink1(View view) {
        Intent toLink1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://science.howstuffworks.com/life/cellular-microscopic/question45.htm"));
        startActivity(toLink1);
    }
}
