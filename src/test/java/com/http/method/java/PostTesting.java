package com.http.method.java;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTesting {
	
	public void getPostTest() {

		//1st ==>add test data = JsinObject class and addProperty
		JsonObject obj = new JsonObject();
		obj.addProperty("title", "Automation");
		obj.addProperty("author", "Student");
		
		//2nd==> RequestSpecification and add data inside body
		RequestSpecification rsf = RestAssured.given();
		rsf.body(obj);// passing test data inside the msg body
		
		//3rd ==>pass URL
		Response response = rsf.post("http://localhost:3000/posts");
		
		//4th = validate
		System.out.println("Status code ="+response.getStatusCode());//201
		Assert.assertEquals(response.getStatusCode(), 201);
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
		new PostTesting().getPostTest();
	}

}
