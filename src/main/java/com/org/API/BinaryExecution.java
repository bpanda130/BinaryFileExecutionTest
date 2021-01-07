package com.org.API;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.http.client.methods.CloseableHttpResponse;

/**
 * Consider this API developed by Dev Team which execute the required binary file and return Response code 
 * depends on given end point.
 * @param Binary File Path
 * @return Returns Response code
 * @author Bishnu
 *
 */
public class BinaryExecution {
	String uri;
	public Integer RequestBinary(String filePath){
		int statusCode=0;
	    try
	    {
	    	//Below line of code will get the content from file.
	    	FileReader fileReader = new FileReader(filePath);
	    	BufferedReader bufferedReader = new BufferedReader(fileReader);
	    	uri = bufferedReader.readLine();
	    	
	    	//By using Http client, getting the response for the URL.
	    	if(uri != null){
	    		RestClient rest = new RestClient();
		    	CloseableHttpResponse closableHttpResponse = rest.getMethod(uri);
		    	statusCode = closableHttpResponse.getStatusLine().getStatusCode();
	    	}else{
	    		//Assumed a condition the binary file doesn't have any content, in that case we are returning lets say 404 error code
	    		System.out.println("Please provide valid URL in the file.");
	    		statusCode = 404;
	    	}
	    	
			if(statusCode == 200)
				System.out.println("it works!!!"+" ============> Response Code is "+statusCode);
			else
				System.out.println("Error"+"****Response Code is "+statusCode);
	    	
	    	
	    }catch(Exception fe){
	    	fe.printStackTrace();
	    }
	    return statusCode;
	}

}
