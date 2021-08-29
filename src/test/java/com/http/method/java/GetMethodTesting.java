package com.http.method.java;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethodTesting {
	
	public void getTest() {
	
		Response response = RestAssured.get("http://localhost:3000/posts");
		
		System.out.println("Status code ="+response.getStatusCode());//200
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Data format ="+response.getContentType());//json
		Assert.assertTrue(response.getContentType().contains("json"));
		System.out.println("Resonce time ="+response.getTime());//time
		Assert.assertTrue(response.getTime()<2000);
		//System.out.println(response.asString());// whole data
		//response.print();
		//response.prettyPrint();
		System.out.println("Is response null or not = "+(response.toString()!= null));
		Assert.assertTrue(response.toString()!= null);
		
		
		
		
	}
	public static void main(String[] args) {
		new GetMethodTesting().getTest();
	}

}
