package com.example.sessionone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Загрузка первого фрагмента по умолчанию
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new Home_Fragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.navigation_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new Home_Fragment()).commit();
            return true;
        } else if (itemId == R.id.navigation_wallet) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new Wallet_Fragment()).commit();
            return true;
        } else if (itemId == R.id.navigation_track) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new Track_Fragment()).commit();
            return true;
        } else if (itemId == R.id.navigation_profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new Profile_Fragment()).commit();
            return true;
        }
        return false;
    }

    public void card_pay(View view) {
        Intent intent = new Intent(Home.this, Add_payment_method.class);
        startActivity(intent);
    }

    public void notifications(View view) {
        Intent intent = new Intent(Home.this, Notification.class);
        startActivity(intent);
    }

    public void gotosendpackage(View view) {
        Intent intent = new Intent(Home.this, Send_3.class);
        startActivity(intent);
    }


}