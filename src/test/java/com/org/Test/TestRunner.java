package com.org.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.API.BinaryExecution;
import com.org.Util.GetResponseCode;

/**
 * This Test file contents all the required Test methods where required Binary files are passed.
 * To Test the BinaryExecution functionality, we used URLConnection methods in GetResponseCode class.
 * @author Bishnu
 *
 */
public class TestRunner {
	BinaryExecution bin;
	GetResponseCode rc;
	String url;
	String binaryPath;
	@BeforeTest
	public void setUp(){
		bin = new BinaryExecution();
		binaryPath = System.getProperty("user.dir") + "/Resources/";
		System.out.println(binaryPath);
		
	}
	//Parametrizing the file name.
	@Parameters({"fileName"})
	@Test
	public void testBinaryExecutionAPI(String fileName){
		//passing Binary file to GetResponseCode class to get the endpoint and response for the same.
		rc = new GetResponseCode(binaryPath+fileName);
		int expectedResponse = rc.getResponse();
		System.out.println("Expected StatusCode is --->"+expectedResponse);
		
		//Using the Dev Teams BinaryExecution API to get the Response Code
		int actualResponse = bin.RequestBinary(binaryPath+fileName);
		System.out.println("Actual StatusCode is --->"+actualResponse);
		
		//Verifying the Response code BinaryExecution API vs getResponse() .
		Assert.assertEquals(actualResponse, expectedResponse);		
	}
}
