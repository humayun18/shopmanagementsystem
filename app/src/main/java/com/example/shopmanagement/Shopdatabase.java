package com.example.shopmanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Shopdatabase extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME = "Shopmanagement.db";
    private static  final String TABLE_NAME1 ="Addtable";
    private static  final String pcode = "_pcode";
    private static  final String pname = "Pname";
    private static  final String price = "Price";
    private static  final String pdetails = "Pdetails";

    private static  final  int VERSION_NO= 1;
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME1 ;
    private Context context;


    public Shopdatabase(Context context) {
        super(context, DATABASE_NAME,null, VERSION_NO);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{

            Toast.makeText(context,"Table is created", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME1+"("+pcode+" INTEGER(100) PRIMARY KEY,"+pname+" VARCHAR(50),"+price+" INTEGER(50),"+pdetails+" VARCHAR(500))");


        }catch (Exception e){
            Toast.makeText(context,"Exception :"+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try {

            Toast.makeText(context,"on upgrade is called", Toast.LENGTH_SHORT).show();

            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch (Exception e){

            Toast.makeText(context,"Exception :"+e, Toast.LENGTH_SHORT).show();

        }

    }

    public void insertData(String procode, String proname, String proprice, String prodetails)
    {

        try {

            SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            contentValues.put(pcode,procode);
            contentValues.put(pname,proname);
            contentValues.put(price,proprice);
            contentValues.put(pdetails,prodetails);
            sqLiteDatabase.insert(TABLE_NAME1,null,contentValues);

            Toast.makeText(context,"Product added successfully", Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(context,"Unsuccessful", Toast.LENGTH_SHORT).show();

        }

    }

    public Cursor showAllData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME1,null);
        return cursor;

    }

    public boolean update(String procode, String proname, String proprice, String prodetails)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(pcode,procode);
        contentValues.put(pname,proname);
        contentValues.put(price,proprice);
        contentValues.put(pdetails,prodetails);
        sqLiteDatabase.update(TABLE_NAME1,contentValues,pcode+"= ?",new String[]{procode});
        return true;
    }


}
