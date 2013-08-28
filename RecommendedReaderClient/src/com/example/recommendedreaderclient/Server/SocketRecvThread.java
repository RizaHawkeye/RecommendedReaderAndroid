package com.example.recommendedreaderclient.Server;

import net.sf.json.*;
import java.io.DataInputStream;
import java.net.*;
import com.example.recommendedreaderclient.*;

public class SocketRecvThread extends Thread{
	private Socket _socket = null;
	private SocketClient.RecvInfo _recvInfo = null;
	private Thread _mainThread = null;
	@Override
	public void run(){
		try{
			DataInputStream dis = new DataInputStream(_socket.getInputStream());
			String info = dis.readUTF();
			_recvInfo.set(info);
			
			//only the main thread begin to wait, call notify()
			while(_mainThread.getState() == Thread.State.WAITING)
			{
				notify();
				break;
			}
		}catch(Exception e){
			
		}
	}
	SocketRecvThread(Socket sock,SocketClient.RecvInfo recvInfo,Thread mainThread){
		_socket = sock;
		_recvInfo = recvInfo;
		_mainThread = mainThread;
	}
}
