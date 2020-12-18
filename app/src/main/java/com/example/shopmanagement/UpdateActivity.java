package com.example.shopmanagement;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateActivity extends AppCompatActivity {

    private EditText pcode,pname,price,pdetail;
    private Button update, search;

    Shopdatabase shopdatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        shopdatabase = new Shopdatabase(this);
        final SQLiteDatabase sqLiteDatabase = shopdatabase.getWritableDatabase();

        pcode=(EditText) findViewById(R.id.up1);
        pname=(EditText)findViewById(R.id.up2);
        price=(EditText)findViewById(R.id.up3);
        pdetail=(EditText)findViewById(R.id.up4);
        update=(Button) findViewById(R.id.btnupdate);
        search=(Button) findViewById(R.id.btnsearch);


        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Cursor searchValue = shopdatabase.search();
                if(searchValue.getCount()==0)
                {

                    Toast.makeText(getApplicationContext(),"No product to update",Toast.LENGTH_SHORT).show();


                }
                else {
                    String code = pcode.getText().toString();
                    while(searchValue.moveToNext())
                    {
                        if(searchValue.getString(0).equals(code))
                        {
                            pcode.setText(searchValue.getString(0));
                            pname.setText(searchValue.getString(1));
                            price.setText(searchValue.getString(2));
                            pdetail.setText(searchValue.getString(3));
                        }

                    }
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String procode= pcode.getText().toString();
                String proname= pname.getText().toString();
                String proprice= price.getText().toString();
                String prodetails=  pdetail.getText().toString();


                Boolean isupdated = shopdatabase.update(procode,proname, proprice,prodetails);

                if(isupdated==true){
                    Toast.makeText(getApplicationContext(), "Successfully Updated  ", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Update Unsuccessfull  ", Toast.LENGTH_LONG).show();
                }

                pcode.setText("");
                pname.setText("");
                price.setText("");
                pdetail.setText("");
            }


        });




    }
}
