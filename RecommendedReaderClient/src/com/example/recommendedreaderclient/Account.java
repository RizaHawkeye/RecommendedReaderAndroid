package com.example.recommendedreaderclient;

import android.database.sqlite.*;

public class Account {
	private String _account = null;
	private String _passwd = null;
	Account(String account,String passwd){
		_account = account;
		_passwd = passwd;
	}
	
	public static void storeAccountInDB(String account,String passwd){
		String path = "";
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path, null);

		String sql = String.format("INSERT INTO MainAccount SET account='%s', password='%s'", account,passwd);
		db.execSQL(sql);
	}
}
