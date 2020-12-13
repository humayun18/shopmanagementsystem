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


public class LoginPageActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Password = "PasswordKey";
    public static final String Email = "emailKey";
    private EditText email,password;
    private Button btn;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        email = (EditText) findViewById(R.id.textemail);
        password = (EditText) findViewById(R.id.textPassword);
        btn = (Button) findViewById(R.id.btnLogin);
        textView = (TextView) findViewById(R.id.lnkRegister);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences sharedpreferences;
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                String emailget =sharedPreferences.getString(Email,"nafishafarjana80@gmail.com");
                String passget = sharedPreferences.getString(Password,"123456");
                if((emailget.equals(email.getText().toString()) && (passget.equals(password.getText().toString()))))
                {
                    Intent intent=new Intent(LoginPageActivity.this,OptionActivity.class);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    Toast.makeText(LoginPageActivity.this, "Wrong User Name or Password id", Toast.LENGTH_SHORT).show();

                }


            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=(new Intent(LoginPageActivity.this,RegisterActivity.class));
                startActivity(intent);
            }
        });


    }
}
