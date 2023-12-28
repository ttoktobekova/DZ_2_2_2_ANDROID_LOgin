package com.example.dz_2_2_2_android;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private MaterialButton loginButton;
    private TextView welcomeTextView;
    private LinearLayout loginContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.loginButton1);
        loginButton = findViewById(R.id.loginButton);
        loginContainer = findViewById(R.id.loginContainer);
        welcomeTextView = findViewById(R.id.welcomeTextView);

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButtonColor();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButtonColor();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Вызов метода для проверки учетных данных при входе
                checkLogin();
            }
        });
    }
    private void checkLogin() {
        String enteredEmail = emailEditText.getText().toString();
        String enteredPassword = passwordEditText.getText().toString();

        if ("ad".equals(enteredEmail) && "123".equals(enteredPassword)) {
            Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
            updateUI();
        } else {
            Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI() {
        welcomeTextView.setText("Добро пожаловать");

        emailEditText.setVisibility(View.GONE);
        passwordEditText.setVisibility(View.GONE);
        loginButton.setVisibility(View.GONE);
        loginContainer.setVisibility(View.GONE);
        welcomeTextView.setVisibility(View.VISIBLE);
    }


    private void updateButtonColor() {
        Context context = MainActivity.this;
        String emailText = emailEditText.getText().toString().trim();
        String passwordText = passwordEditText.getText().toString().trim();

        if (!emailText.isEmpty() || !passwordText.isEmpty()) {
            loginButton.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.orange));
        } else {
            loginButton.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.grais));
        }
    }
}
