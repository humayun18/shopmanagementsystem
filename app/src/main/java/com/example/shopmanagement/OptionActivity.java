package com.example.shopmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


public class OptionActivity extends AppCompatActivity {

    private CardView addcard,viewcard,updatecard,sellcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        addcard = findViewById(R.id.addcardviewid);
        viewcard = findViewById(R.id.viewcardviewid);
        updatecard = findViewById(R.id.updatecardviewid);
        sellcard = findViewById(R.id.sellcardviewid);



        addcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OptionActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });
        viewcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OptionActivity.this,ViewActivity.class);
                startActivity(intent);
            }
        });
        updatecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OptionActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });

        sellcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OptionActivity.this,OthersActivity.class);
                startActivity(intent);
            }
        });



    }
}
