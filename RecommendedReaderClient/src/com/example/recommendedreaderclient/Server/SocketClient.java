package com.example.recommendedreaderclient.Server;

import java.net.*;
import net.sf.json.*;
import java.util.*;
import java.io.*;

import com.example.recommendedreaderclient.Artical;

public class SocketClient extends Client{
	private final String SERVER_IP = "localhost";
	private final int PORT = 1989;
	private void send(String msg){
		Socket socket = null;
		try{
			socket = new Socket(SERVER_IP,PORT);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(msg);
			dos.close();
		}catch(Exception e){
		}
		finally{
			if(socket != null)
				try{
					socket.close();
				}catch(Exception e){
					
				}
		}
	}
	
	private String _constructJsonRegMsg(String earliestTime){
		Map<String,String> map = new HashMap<String,String>();
		
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
	}
	private String _constructJsonUpdMsg(String earliestTime,String latestTime){
		Map<String,String> map = new HashMap<String,String>();
		map.put("", "");
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
	}
	private String _constructJsonGetMsg(String earliestTime,String latestTime){
		Map<String,String> map = new HashMap<String,String>();
		map.put("earliest","");
		map.put("order","");
		map.put("account","");
		map.put("password","");
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
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
}
