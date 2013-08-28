package com.example.recommendedreaderclient.Server;

import java.net.Socket;

public abstract class Client {
	public abstract String getArticals(String type,String earliestTime,int order,String account,String password);
	
	public abstract String update(String type,String mainAccount,String website,String proAccount,String proPasswd);
	
	public abstract String register(String type,String account,String password);
}
