package com.org.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetResponseCode {
	String filepath;
	String url;
	
	public GetResponseCode(String filepath){
		this.filepath = filepath;
	}
	
	public Integer getResponse(){
		int responsCode = 0;
		try{
			FileReader fileReader = new FileReader(filepath);
	    	BufferedReader bufferedReader = new BufferedReader(fileReader);
	    	url = bufferedReader.readLine();
	    	if(url != null){
	    		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		    	conn.setRequestMethod("GET");
		    	conn.connect();
		    	responsCode = conn.getResponseCode();
	    	}else
	    		responsCode = 404;
	    	
		}catch(Exception e){
			e.printStackTrace();
		}
		return responsCode;
	}

}
