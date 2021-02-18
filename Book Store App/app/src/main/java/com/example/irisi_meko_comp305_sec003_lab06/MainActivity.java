package com.example.bruno_brasil_irisi_meko_comp305_sec003_lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);
    }
}