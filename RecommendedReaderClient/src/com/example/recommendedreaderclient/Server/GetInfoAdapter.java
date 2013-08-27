package com.example.recommendedreaderclient.Server;

public class GetInfoAdapter {
	GetInfoBySocket inter  = new GetInfoBySocket();

	private String id,author,title,href,timestampUsec;
	private String content;

	public String getAuthor(){
		return inter.getAuthor();
	}
	public String setAuthor(String author){
		author = 
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
	public String getInfo()
}

