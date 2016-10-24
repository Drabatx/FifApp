package com.devtx.drabatx.fifapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jose Luis on 23/10/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="fifapp.db";
    private static final int DATABASE_VERSION = 1 ;
    Context ctx;

    public DataBaseHelper(Context ctx){
        super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseSource.CREATE_EVENTO_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>oldVersion){
            db.execSQL("drop table if exist "+ DataBaseSource.TABLA_EVENTOS);
            db.execSQL(DataBaseSource.CREATE_EVENTO_SCRIPT);
        }
    }
}

