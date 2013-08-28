package com.example.recommendedreaderclient.Server;

import java.net.*;
import net.sf.json.*;

import java.util.*;
import java.io.*;

import com.example.recommendedreaderclient.Account;
import com.example.recommendedreaderclient.Artical;

public class SocketClient extends Client{
	private final String SERVER_IP = "localhost";
	private final int PORT = 1989;

/*	public SocketClient(String type,String earliestTime,int order,String account,String password){
		_sendMsg = _constructJsonGetMsg(earliestTime,order,account,password);
	}

	public SocketClient(String type,String mainAccount,String website,String proAccount,String proPasswd){
		_sendMsg = _constructJsonUpdMsg(mainAccount,website,proAccount,proPasswd);
	}

	public SocketClient(String type,String account,String password){
		_sendMsg = _constructJsonRegMsg(account,password);
	}*/
	
	class RecvInfo{
		private String info = null;
		public String get(){
			return info;
		}
		public void set(String str){
			info = str;
		}
	}

	//GET
	@Override
	public String getArticals(String type,String earliestTime,int order,String account,String password){
		String _sendMsg = _constructJsonGetMsg(earliestTime,order,account,password);
		return _send(_sendMsg);
	}
	//UPD
	@Override
	public String update(String type,String mainAccount,String website,String proAccount,String proPasswd){
		String _sendMsg = _constructJsonUpdMsg(mainAccount,website,proAccount,proPasswd);
		return _send(_sendMsg);
	}
	//REG
	@Override
	public String register(String type,String account,String password){
		String _sendMsg = _constructJsonRegMsg(account,password);
		return _send(_sendMsg);
	}

	private String _send(String sendMsg){
		Socket socket = null;
		try{
			socket = new Socket(SERVER_IP,PORT);

			RecvInfo recvInfo = new RecvInfo();
			SocketRecvThread recvThread = new SocketRecvThread(socket,recvInfo,Thread.currentThread());
			recvThread.start();
		
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(sendMsg);
			
			wait();
			dos.close();
			return processRecvInfo(recvInfo.get());
		
		}catch(Exception e){
			//TODO
			return null;
		}
		finally{
			if(socket != null)
			{
				try{
					socket.close();
				}catch(Exception e){
					
				}
			}
		}
	}
	
	/*type:GET		type:GET
	 *status:OK 	status:ERROR
	 *content:xxx	errmsg:xxxx
	 *
	 *type:REG		type:REG
	 *status:OK		status:ERROR
	 *				errmsg:xxx
	 *
	 *type:UPD		type:UPD
	 *status:		status:ERROR
	 *				errmsg:xxx
	 */
	private String processRecvInfo(String info){
		JSONObject jsonObj = JSONObject.fromObject(info);
		String type = jsonObj.getString("type");

		if(type.equals("GET")){
			String status = jsonObj.getString("status");
			if(status.equals("OK")){
				JSONObject jsonCont = jsonObj.getJSONObject("content");
				Artical.storeArticalsIntoDB(jsonCont);
				return null;
			}
			else if(status.equals("ERROR")){
				//TODO:
				String errmsg = jsonObj.getString("ERROR");
				return errmsg;
			}
		}
		else if(type.equals("REG")){
			String status = jsonObj.getString("status");
			if(status.equals("OK")){
				return null;
			}
			else if(status.equals("ERROR")){
				//TODO:
				String errmsg = jsonObj.getString("ERROR");
				return errmsg;
			}
		}
		else if(type.equals("UPD")){
			String status = jsonObj.getString("status");
			if(status.equals("OK")){
				return null;
			}
			else if(status.equals("ERROR")){
				//TODO:
				String errmsg = jsonObj.getString("ERROR");
				return errmsg;
			}
		}
	}

	private String _constructJsonRegMsg(String account,String password){
		Map<String,String> map = new HashMap<String,String>();
		map.put("account",account);
		map.put("password",password);
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
	}
	private String _constructJsonUpdMsg(String mainAccount,String website,String proAccount,String proPasswd){
		Map<String,String> map = new HashMap<String,String>();
		map.put("mainAccount", mainAccount);
		map.put("website", website);
		map.put("proAccount", proAccount);
		map.put("proPasswd", proPasswd);
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
	}
	private String _constructJsonGetMsg(String earliestTime,int order,String account,String password){
		Map<String,String> map = new HashMap<String,String>();
		map.put("earliestTime",earliestTime);
		map.put("order",Integer.toString(order));
		map.put("account",account);
		map.put("password",password);
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
	}
}
