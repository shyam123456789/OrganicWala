package com.example.organicwala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.organicwala.HomeActivity;
import com.example.organicwala.R;
import com.example.organicwala.abstractactivity.MyAbstractActivity;

public class LogInScreenActivity extends MyAbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
        initview();
        listners();
    }


    @Override
    public void initview() {

    }

    @Override
    public void listners() {

    }

    public void login(View view) {

        startActivity(new Intent(this, OTPVarificationActivity.class));
    }
}
