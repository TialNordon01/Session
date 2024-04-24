package com.example.sessionone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Send_a_package extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_apackage);
    }

    public void next_event(View view) {
        Intent intent = new Intent(Send_a_package.this, Send_a_package_2.class);
        startActivity(intent);
    }
    public void backtohome(View view) {
        Intent intent = new Intent(Send_a_package.this, Home.class);
        startActivity(intent);
    }


}