package com.example.organicwala.activities;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.alahammad.otp_view.OtpView;
import com.example.organicwala.HomeActivity;
import com.example.organicwala.R;


public class OTPVarificationActivity extends AppCompatActivity {
    @BindView(R.id.otp)
    public OtpView otpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpvarification);
        ButterKnife.bind(this);

        otpView.setOnOtpFinished(s -> {
            startActivity(new Intent(OTPVarificationActivity.this, HomeActivity.class));
            Toast.makeText(OTPVarificationActivity.this, "" + s, Toast.LENGTH_SHORT).show();

        });
    }
}
