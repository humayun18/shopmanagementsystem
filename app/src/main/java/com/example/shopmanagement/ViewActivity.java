package com.example.shopmanagement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewActivity extends AppCompatActivity {

    private ListView listView;

    Shopdatabase shopdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView=(ListView)findViewById(R.id.listviewid);

        shopdatabase = new Shopdatabase(this);
        SQLiteDatabase sqLiteDatabase = shopdatabase.getWritableDatabase();
        localdata();

    }

    public void localdata(){

        ArrayList<String> listData=new ArrayList<>();

        Cursor cursor = shopdatabase.showAllData();

        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(), "No data is available", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                listData.add(cursor.getString(0)+" \n "+ cursor.getString(1)+" \n "+ cursor.getString(2)+" \n "+ cursor.getString(3));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtviewid,listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedValue = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Selected value : "+selectedValue, Toast.LENGTH_SHORT).show();

            }
        });

    }


}
