package com.example.shopmanagement;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText pcodedittext,pnameedittext,priceedittext,pdetailsedittext;
    private Button padd;

    Shopdatabase shopdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        shopdatabase = new Shopdatabase(this);
        SQLiteDatabase sqLiteDatabase = shopdatabase.getWritableDatabase();

        pcodedittext=(EditText) findViewById(R.id.ad1);
        pnameedittext=(EditText)findViewById(R.id.ad2);
        priceedittext=(EditText)findViewById(R.id.ad3);
        pdetailsedittext=(EditText)findViewById(R.id.ad4);
        padd=(Button) findViewById(R.id.btnadd);

        padd.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String procode= pcodedittext.getText().toString();
        String proname= pnameedittext.getText().toString();
        String proprice= priceedittext.getText().toString();
        String prodetails=  pdetailsedittext.getText().toString();

        if (view.getId()==R.id.btnadd){

            shopdatabase.insertData(procode,proname,proprice,prodetails);

            pcodedittext.setText("");
            pnameedittext.setText("");
            priceedittext.setText("");
            pdetailsedittext.setText("");

        }

    }
}

