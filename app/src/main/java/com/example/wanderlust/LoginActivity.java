package com.example.wanderlust;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button login, signupcall;
    ImageView logo;
    TextView welcome, desc;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.signin_btn);
        signupcall = findViewById(R.id.signin_btn);
        logo = findViewById(R.id.logo_img);
        welcome = findViewById(R.id.hello_msg);
        desc = findViewById(R.id.signin_msg);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
    }

    public void Dashboard(View view) {

        Intent intent = new Intent(LoginActivity.this, UserProfile.class);
        startActivity(intent);


    }

    public void ForgetPassword(View view) {


    }

    public void SignUp(View view) {

        Intent intent = new Intent(LoginActivity.this,SignUp.class);

        Pair[] pairs = new Pair[7];

        pairs[0] = new Pair<View,String>(logo ,"logo_img");
        pairs[1] = new Pair<View,String>(signupcall , "signup_btn");
        pairs[2] = new Pair<View,String>(login , "signin_btn");
        pairs[3] = new Pair<View,String>(welcome , "logo_text");
        pairs[4] = new Pair<View,String>(desc , "logo_text");
        pairs[5] = new Pair<View,String>(password , "password_tran");
        pairs[6] = new Pair<View,String>(username , "username_tran");


        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
        startActivity(intent, options.toBundle());



    }
}