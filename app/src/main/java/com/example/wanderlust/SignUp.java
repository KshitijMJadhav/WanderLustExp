package com.example.wanderlust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    ImageView logo;
    TextView welcome,desc;
    TextInputLayout name,username,email,password,phone;
    Button signup,login;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.nameinput);
        username = findViewById(R.id.usernameinput);
        email = findViewById(R.id.emailinput);
        password = findViewById(R.id.passwordinput);
        phone = findViewById(R.id.phoneinput);
        signup = findViewById(R.id.signup_btn2);
        login = findViewById(R.id.signin_btn2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                String name1 = name.getEditText().getText().toString();
                String username1 = username.getEditText().getText().toString();
                String email1 = email.getEditText().getText().toString();
                String phone1 = phone.getEditText().getText().toString();
                String password1 = password.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name1, username1,email1,phone1,password1);
                reference.child(phone1).setValue(helperClass);






            }
        });


    }

    private Boolean validateName(){

        String val = name.getEditText().getText().toString();

        if (val.isEmpty())
        {
            name.setError("Field should not be empty");
            return false;
        }else {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateUsername(){

        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "(?=\\s+$)";

        if (val.isEmpty())
        {
            username.setError("Field should not be empty");
            return false;
        }else if (!val.matches(noWhiteSpace))
        {
            username.setError("Space must not exist");
            return false;
        }

            {
            username.setError(null);
                name.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateEmail(){

        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "(?=\\s+$)";

        if (val.isEmpty())
        {
            username.setError("Field should not be empty");
            return false;
        }else if (!val.matches(noWhiteSpace))
        {
            username.setError("Space must not exist");
            return false;
        }

        {
            username.setError(null);
            name.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePhone(){

        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "(?=\\s+$)";

        if (val.isEmpty())
        {
            username.setError("Field should not be empty");
            return false;
        }else if (!val.matches(noWhiteSpace))
        {
            username.setError("Space must not exist");
            return false;
        }

        {
            username.setError(null);
            name.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePassword(){

        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "(?=\\s+$)";

        if (val.isEmpty())
        {
            username.setError("Field should not be empty");
            return false;
        }else if (!val.matches(noWhiteSpace))
        {
            username.setError("Space must not exist");
            return false;
        }

        {
            username.setError(null);
            name.setErrorEnabled(false);
            return true;
        }

    }


    public void registeruser(View view) {

        String name1 = name.getEditText().getText().toString();
        String username1 = username.getEditText().getText().toString();
        String email1 = email.getEditText().getText().toString();
        String phone1 = phone.getEditText().getText().toString();
        String password1 = password.getEditText().getText().toString();

        UserHelperClass helperClass = new UserHelperClass(name1, username1,email1,phone1,password1);
        reference.child(phone1).setValue(helperClass);

        Intent intent = new Intent(SignUp.this,Dashboard.class);
        startActivity(intent);

    }
}