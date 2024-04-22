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

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password2);
        Button login = findViewById(R.id.login);

        login.setClickable(false);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Проверяем, заполнены ли все поля
                if (!TextUtils.isEmpty(email.getText()) &&
                    !TextUtils.isEmpty(password.getText())) {
                    // Если все поля заполнены, изменяем цвет кнопки
                    login.setBackgroundColor(Color.BLUE);
                    login.setClickable(true);
                } else {
                    // Если хотя бы одно поле не заполнено, возвращаем цвет кнопки к исходному
                    login.setBackgroundColor(Color.GRAY);
                    login.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        // Добавляем TextWatcher к каждому EditText
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
    }

    public void Home(View view) {
        Intent intent = new Intent(this, HomeNavigation.class);
        startActivity(intent);
    }

    public void SignUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void ForgotPassword(View view) {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }
}