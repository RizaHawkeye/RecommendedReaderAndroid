package com.example.recommendedreaderclient;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.*;
import android.database.*;

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
		//weather have a table in sqlite
		//需要自己判断数据库存在吗
		if(!_isTableExist(db, "MainAccount"))
			_createMainAccount(db);
		if(!_isTableExist(db, "ProxyAccount"))
			_createProxyAccounts(db);
		if(!_isTableExist(db, "Articals"))
			_createArticals(db);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	private boolean _isTableExist(SQLiteDatabase db,String table){
		String sql = "SELECT COUNT(*) AS NUM FROM sqlite_master where type='table' and name=?;"; 
		Cursor c = db.rawQuery(sql, new String[]{table});
		c.moveToFirst();
		if(c.getString(c.getColumnIndex("NUM")).equals("1"))
			return true;
		else
			return false;

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
		String sql = "create table Articals ( " +
				"( id varchar(50) not null, " +
				"	author varchar(50) , " + 
				"	title varchar(50) not null," +
				"	content text not null, " +
				"	href varchar(150) not null, " +
				"	timestampUsec varchar(20) not null,"+
				"	status varchar(10) not null default \"UNREAD\","+
				"	score int, " +
				"	primary key (id), " +
				"	foreign key(status) references Status(status), "+
				"	check (score > 0 and score <=5)";
		db.execSQL(sql);
	}

}
