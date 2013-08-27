package com.example.recommendedreaderclient;

import com.example.recommendedreaderclient.Server.GetInfoBySocket;
import com.example.recommendedreaderclient.Server.GetInfoInter;

import android.database.*;
import android.database.sqlite.*;

public class Artical {
	
	private String id,author,title,href,timestampUsec;
	private String content;

	void storeInDb(SQLiteDatabase db){
		String sql = "insert into Articals values(\'" + id +  "\',\'" + author + "\',\'" + title + "\',\'" + content + "\',\'" + href + "\',\'" + timestampUsec + "\')";
		db.execSQL(sql);
	}
	
	public static void storeInDb(SQLiteDatabase db,String id,String author,String title,String content,String href,String timestampUsec){
		String sql = "insert into Articals values(\'" + id +  "\',\'" + author + "\',\'" + title + "\',\'" + content + "\',\'" + href + "\',\'" + timestampUsec + "\')";
		db.execSQL(sql);
	}
	
	public static String getFromServer(String id ,String startTimeStamp){
		GetInfoInter inter = new GetInfoBySocket());
		return inter.getInfo();	
	}
}
