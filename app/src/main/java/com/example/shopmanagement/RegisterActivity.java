package com.example.shopmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    private EditText email,password;
    private Button btn;
    private TextView textView;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Password = "PasswordKey";
    public static final String Email = "emailKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPwd);
        btn = findViewById(R.id.btnLogin);
        textView = findViewById(R.id.lnkLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnLogin) ;
                {
                    String username = email.getText().toString();
                    String passward = password.getText().toString();
                    if (username.equals("")) {
                        Toast.makeText(RegisterActivity.this, "Please Enter Your User Name First", Toast.LENGTH_SHORT).show();

                    } else if (passward.equals("")) {
                        Toast.makeText(RegisterActivity.this, "Please Enter Your Passward First", Toast.LENGTH_SHORT).show();

                    } else {
                        SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(Password, password.getText().toString());
                        editor.putString(Email, email.getText().toString());
                        editor.commit();
                        Intent intent = new Intent(RegisterActivity.this,OptionActivity.class);
                        startActivity(intent);

                    }


                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.lnkLogin) ;
                {
                    Intent intent = new Intent(RegisterActivity.this,LoginPageActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    }
