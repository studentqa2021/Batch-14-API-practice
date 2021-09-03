package com.http.method.java;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethodTesting {
	
	public void getPostTest() {

		//1st ==>add test data = JsinObject class and addProperty
		JsonObject data = new JsonObject();
		data.addProperty("title", "Automation");
		data.addProperty("author", "Student");
		
		//2nd==> RequestSpecification and add data inside body
		RequestSpecification rsf = RestAssured.given();
		rsf.body(data);// passing test data inside the msg body
		
		//3rd ==>pass URL
		Response response = rsf.post("http://localhost:3000/posts");
		
		//4th = API basic validate
		System.out.println("Status code ="+response.getStatusCode());//201
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println("Data format ="+response.getContentType());//json
		Assert.assertTrue(response.getContentType().contains("json"));
		System.out.println("Resonce time ="+response.getTime());//time
		Assert.assertTrue(response.getTime()<2000);
		//Data validation
		//not null
		System.out.println("Is response null or not = "+(response.toString()!= null));
		Assert.assertTrue(response.toString()!= null);//should not be null
		// specific attribute value or how to parse jason data
		
		JsonPath jp = response.jsonPath();
		Assert.assertTrue(jp.get("title") != null);

		Assert.assertEquals(jp.get("title"), "Automation");
		Assert.assertEquals(jp.get("author"), "Student");
		
		
		
		
	}
	public static void main(String[] args) {
		new PutMethodTesting().getPostTest();
	}

}
