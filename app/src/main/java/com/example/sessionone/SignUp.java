package com.example.sessionone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText confirm = findViewById(R.id.confirm);
        CheckBox checkbox = findViewById(R.id.checkbox);
        Button signup = findViewById(R.id.signup);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Проверяем, заполнены ли все поля
                if (!TextUtils.isEmpty(name.getText()) &&
                    !TextUtils.isEmpty(phone.getText()) &&
                    !TextUtils.isEmpty(email.getText()) &&
                    !TextUtils.isEmpty(password.getText()) &&
                    !TextUtils.isEmpty(confirm.getText()) &&
                    checkbox.isChecked()) {
                    // Если все поля заполнены, изменяем цвет кнопки
                    signup.setBackgroundColor(Color.BLUE);
                } else {
                    // Если хотя бы одно поле не заполнено, возвращаем цвет кнопки к исходному
                    signup.setBackgroundColor(Color.GRAY);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!TextUtils.isEmpty(name.getText()) &&
                    !TextUtils.isEmpty(phone.getText()) &&
                    !TextUtils.isEmpty(email.getText()) &&
                    !TextUtils.isEmpty(password.getText()) &&
                    !TextUtils.isEmpty(confirm.getText()) &&
                    checkbox.isChecked()) {
                // Если все поля заполнены, изменяем цвет кнопки
                signup.setBackgroundColor(Color.BLUE);
            } else {
                // Если хотя бы одно поле не заполнено, возвращаем цвет кнопки к исходному
                signup.setBackgroundColor(Color.GRAY);
            }
        });

        // Добавляем TextWatcher к каждому EditText
        name.addTextChangedListener(textWatcher);
        phone.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        confirm.addTextChangedListener(textWatcher);
    }

    public void Home(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


    public void SignIn(View view) {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }
}