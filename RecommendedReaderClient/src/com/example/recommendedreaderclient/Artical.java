package com.example.recommendedreaderclient;

import android.database.*;
import android.database.sqlite.*;

public class Artical {
	
	private String id,author,title,href,timestampUsec;
	private String content;

	void storeInDb(SQLiteDatabase db){
		String sql = "insert into Articals values(\'" + id +  "\',\'" + author + "\',\'" + title + "\',\'" + content + "\',\'" + href + "\',\'" + timestampUsec + "\')";
		db.execSQL(sql);
	}
	
	void getFromServer(String id ,String startTimeStamp){
		GetInfoAdapter adapter = new GetInfoAdapter();
		id  = adapter.getId();
		author = adapter.getAuthor();
		title = adapter.getTitle();
		href = adapter.getHref();
		timestampUsec = adapter.getTimestampUsec();
		content = adapter.getContent();
	}
}
