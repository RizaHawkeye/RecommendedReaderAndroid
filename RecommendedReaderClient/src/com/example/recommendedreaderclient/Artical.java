package com.example.recommendedreaderclient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.example.recommendedreaderclient.Server.*;

import android.database.*;
import android.database.sqlite.*;

public class Artical {
	
	private String id,author,title,href,timestampUsec;
	private String content;

	void storeInDb(SQLiteDatabase db){
		String sql = "insert into Articals values(\'" + id +  "\',\'" + author + "\',\'" + title + "\',\'" + content + "\',\'" + href + "\',\'" + timestampUsec + "\')";
		db.execSQL(sql);
	}
	
	private static void storeInDb(SQLiteDatabase db,String id,String author,String title,String content,String href,String timestampUsec){
		String sql = "insert into Articals values(\'" + id +  "\',\'" + author + "\',\'" + title + "\',\'" + content + "\',\'" + href + "\',\'" + timestampUsec + "\')";
		db.execSQL(sql);
	}
	public static void storeArticalsIntoDB(JSONObject jsonCont){
		JSONArray allContent = JSONArray.fromObject(jsonCont.get("content"));

		for(int i = 0; i<allContent.size();++i){
			JSONObject oneContent = allContent.getJSONObject(i);
			String id = oneContent.getString("id");
			String title = oneContent.getString("title");
			String author = oneContent.getString("author");
			String timestampUsec = oneContent.getString("timestampUsec");
			String content = oneContent.getString("content");
			String href = oneContent.getString("href");
			Artical.storeInDb(db, id, author, title, content, href, timestampUsec);
		}
	}
	/*public static String getFromServer(String id ,String startTimeStamp){
		SocketClient client = new SocketClient();
		
		
	}*/
}
