package com.example.ashiagrawal.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent edit = new Intent(LoginActivity.this, ScrollActivity.class);
                startActivity(edit);
            }
        });

//        final Button forgot = (Button) findViewById(R.id.btnForgot);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
////                int duration = 5;
////                Toast toast = Toast.makeText(getApplicationContext(), "We'll send an email to you with a" +
////                        " password reset link.", duration);
////                toast.show();
//
//            }
//        });
    }
}
