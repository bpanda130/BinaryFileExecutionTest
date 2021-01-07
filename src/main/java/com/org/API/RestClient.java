package com.org.API;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	
	public CloseableHttpResponse getMethod(String url) throws ClientProtocolException, IOException {
		// create a client connection
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// create a get connection with the required url
		HttpGet httpGet = new HttpGet(url);
		// Sending the get request for the required url. like clicking on
		// Sending Button.
		CloseableHttpResponse closableHttpResponse = httpClient.execute(httpGet);
		return closableHttpResponse;
	}

}
