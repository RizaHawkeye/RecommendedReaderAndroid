package com.example.recommendedreaderclient;

public class GetInfoAdapter {
	GetInfoBySocket inter  = new GetInfoBySocket();
	public String getAuthor(){
		return inter.getAuthor();
	}
	public String getId(){
		return inter.getId();
	}
	public String getTitle(){
		return inter.getTitle();
	}
	public String getHref(){
		return inter.getHref();
	}
	public String getContent(){
		return inter.getContent();
	}
	public String getTimestampUsec(){
		return inter.getTimestampUsec();
	}
}
