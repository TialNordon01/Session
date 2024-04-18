package com.example.sessionone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText email = findViewById(R.id.email);
        Button sendotp = findViewById(R.id.sendotp);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Проверяем, заполнены ли все поля
                if (!TextUtils.isEmpty(email.getText())) {
                    // Если все поля заполнены, изменяем цвет кнопки
                    sendotp.setBackgroundColor(Color.BLUE);
                } else {
                    // Если хотя бы одно поле не заполнено, возвращаем цвет кнопки к исходному
                    sendotp.setBackgroundColor(Color.GRAY);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

            // Добавляем TextWatcher к каждому EditText
        email.addTextChangedListener(textWatcher);
    }

    public void SignIn(View view) {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    public void SendOTP(View view) {
        Intent intent = new Intent(this, OTPVerification.class);
        startActivity(intent);
    }
}