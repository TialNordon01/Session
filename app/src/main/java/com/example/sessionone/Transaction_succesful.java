package com.example.sessionone;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Transaction_succesful extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_succesful);

        ImageView animation = findViewById(R.id.animat);

        animation.setBackgroundResource(R.drawable.animation);

        AnimationDrawable frameAnimation = (AnimationDrawable) animation.getBackground();

        new CountDownTimer(1250, 1000) {

            public void onTick(long millisUntilFinished) {
                frameAnimation.start();
            }

            public void onFinish() {
                frameAnimation.stop();
                animation.setBackground(getDrawable(R.drawable.sucsesfulsecond));
                TextView suc = findViewById(R.id.confirm);
                suc.setText("Transaction Successful");
            }

        }.start();
    }
    public void gohome (View view){
        Intent intent = new Intent(Transaction_succesful.this, Home_Fragment.class);
        startActivity(intent);
    }

    public void tracking (View view){
        Intent intent = new Intent(Transaction_succesful.this, Home.class);
        startActivity(intent);
    }

}