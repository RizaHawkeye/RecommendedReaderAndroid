package com.example.recommendedreaderclient;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.*;

public class DBHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "mydata.db"; //数据库名称
    private static final int version = 1; //数据库版本
     
    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
        // TODO Auto-generated constructor stub
    }
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		_createMainAccount(db);
		_createProxyAccounts(db);
		_createArticals(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	private void _createMainAccount(SQLiteDatabase db) {
		String sql = "create table MainAccount(account varchar(20) primary key,  password varchar(20) not null);";
		db.execSQL(sql);
	}
	
	private void _createProxyAccounts(SQLiteDatabase db){
		String sql = "create table ProxyAccount(account varchar(20) not null, password varchar(20) not null,website varchar(20) not null,primary key(account,website);";
		db.execSQL(sql);
	}
	
	private void _createArticals(SQLiteDatabase db){
		//TODO 
		String sql;
		db.execSQL(sql);
	}

}
