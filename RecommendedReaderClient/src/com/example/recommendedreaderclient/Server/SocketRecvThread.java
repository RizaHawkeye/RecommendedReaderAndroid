package com.example.recommendedreaderclient.Server;

import net.sf.json.*;
import java.io.DataInputStream;
import java.net.*;

public class SocketRecvThread extends Thread{
	Socket socket = null;
	@Override
	public void run(){
		try{
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String info = dis.readUTF();
			JSONObject jsonObj = JSONObject.fromObject(info);
			String type = (String)jsonObj.get("type");

			if(type.equals("GET")){
				
			}
			else if(type.equals("REG")){
				
			}
			else if(type.equals("UPD")){
				
			}
		}catch(Exception e){
			
		}
	}
	SocketRecvThread(Socket sock){
		socket = sock;
	}
}
