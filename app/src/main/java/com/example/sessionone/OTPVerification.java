package com.example.sessionone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
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

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class OTPVerification extends AppCompatActivity implements TextWatcher {

    private int current = 0;
    private ArrayList<EditText> editTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.otpverification);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Установка фильтра для ограничения количества символов
        int maxLength = 1; // максимальное количество символов
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(maxLength);

        TextInputLayout textInputLayout1 = findViewById(R.id.num1);
        EditText editText1 = textInputLayout1.getEditText();
        editText1.setFilters(filters);

        TextInputLayout textInputLayout2 = findViewById(R.id.num2);
        EditText editText2 = textInputLayout2.getEditText();
        editText2.setFilters(filters);

        TextInputLayout textInputLayout3 = findViewById(R.id.num3);
        EditText editText3 = textInputLayout3.getEditText();
        editText3.setFilters(filters);

        TextInputLayout textInputLayout4 = findViewById(R.id.num4);
        EditText editText4 = textInputLayout4.getEditText();
        editText4.setFilters(filters);

        TextInputLayout textInputLayout5 = findViewById(R.id.num5);
        EditText editText5 = textInputLayout5.getEditText();
        editText5.setFilters(filters);

        TextInputLayout textInputLayout6 = findViewById(R.id.num6);
        EditText editText6 = textInputLayout6.getEditText();
        editText6.setFilters(filters);

        // Добавление EditText в список
        editTexts.add(editText1);
        editTexts.add(editText2);
        editTexts.add(editText3);
        editTexts.add(editText4);
        editTexts.add(editText5);
        editTexts.add(editText6);

        // Установка слушателя для каждого EditText
        for (EditText editTextT : editTexts) {
            editTextT.addTextChangedListener(this);
        }

        Button setpassword = findViewById(R.id.setpassword);

        setpassword.setClickable(false);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Проверяем, заполнены ли все поля
                if (!TextUtils.isEmpty(editText1.getText()) &&
                        !TextUtils.isEmpty(editText2.getText()) &&
                        !TextUtils.isEmpty(editText3.getText()) &&
                        !TextUtils.isEmpty(editText4.getText()) &&
                        !TextUtils.isEmpty(editText5.getText()) &&
                        !TextUtils.isEmpty(editText6.getText())) {
                    // Если все поля заполнены, изменяем цвет кнопки
                    setpassword.setBackgroundColor(Color.BLUE);
                    setpassword.setClickable(true);
                } else {
                    // Если хотя бы одно поле не заполнено, возвращаем цвет кнопки к исходному
                    setpassword.setBackgroundColor(Color.GRAY);
                    setpassword.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        for (EditText editTextT : editTexts) {
            editTextT.addTextChangedListener(textWatcher);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() != 0) { // Проверяем, заполнено ли поле
            if (current < editTexts.size() - 1) {
                current++;
                editTexts.get(current).requestFocus();
            }
        }
        if (s.length() == 0) {
            if (current > 0) { // Убедитесь, что текущий индекс больше 0, чтобы избежать выхода за пределы списка
                current--; // Переходим к предыдущему индексу
                editTexts.get(current).requestFocus(); // Переносим фокус на предыдущий EditText
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    public void SetNewPassword(View view) {
        Intent intent = new Intent(this, NewPassword.class);
        startActivity(intent);
    }

}