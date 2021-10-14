package com.example.wanderlust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class UserProfile extends AppCompatActivity {

    Button update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_profile);

        update_btn = findViewById(R.id.update_btn);
    }

    public void Dashboard(View view) {
        Intent intent = new Intent(UserProfile.this,Dashboard.class);
        startActivity(intent);
    }
}