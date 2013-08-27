package com.example.recommendedreaderclient.Server;

import android.database.sqlite.*;
import android.database.Cursor;
import java.net.*;

public class GetInfoBySocket implements GetInfoInter{
	
	private SQLiteDatabase db;
	private final String SERVER_IP = "localhost";
	private final int PORT = 1989;
	private String _earliestTime;
	@Override
	public String getAuthor(){
		String author = null;
		return author;
	}
	@Override
	public String getId(){
		String id = null;
		return id;
	}
	@Override
	public String getTitle(){
		String title = null;
		return title;
	}
	@Override
	public String getHref(){
		String href = null;
		return href;
	}
	@Override
	public String getContent(){
		String content = null;
		return content;
	}
	@Override
	public String getTimestampUsec(){
		String timestampUsec = null;
		return timestampUsec;
	}
	private String _constructGetNewMsg(String earliestTime){
		String msg = "{\"method\":\"NEW\",\"earliestTime\":\"" + earliestTime + "\"}";
		return msg;
	}
	private String _constructGetMoreMsg(String earliestTime,String latestTime){
		String msg = "{\"method\":\"MORE\",\"earliestTime\":\"" + earliestTime + "\",\"latestTime\":\"" + latestTime + "\"}";
		return msg;
	}
	
	public String getNewArticals(){
		String sql = "select max(timestampUsec) from Articals";
		Cursor c = db.rawQuery(sql,null);
		c.moveToNext();
		_earliestTime = c.getString(0);
		String msg = _constructGetNewMsg(_earliestTime);
		//����sendҪ���أ���õ�20��������ÿ��20���ɣ�������ʱ�������ʱ�䡣�����������������20����˵����������ظ���
		String gotData = send(msg);
		
		//TODO parse
		
	}
	
	public String getMoreArticals(){
		String sql = "select max(timestampUsec) from Articals";
		Cursor c = db.rawQuery(sql,null);
		c.moveToNext();
		String latestTime = c.getString(0);
		String msg = _constructGetMoreMsg(_earliestTime,latestTime);
		send(msg);
	}
	public String getInfo(){
		
	}
}
