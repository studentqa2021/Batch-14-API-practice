package com.http.method.cucumber;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Stepdef {

	Response response;
	
	@Given("pass the URL")
	public void pass_the_url() {
		response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
	    
	}

	@Then("validate status code")
	public void validate_status_code() {
		System.out.println("Status code ="+response.getStatusCode());//200
		Assert.assertEquals(response.getStatusCode(), 200);
	    
	}

	@Then("validate data format is json")
	public void validate_data_format_is_json() {
		System.out.println("Data format ="+response.getContentType());//json
		Assert.assertEquals(response.getContentType(), "application/json");
		Assert.assertTrue(response.getContentType().contains("json"));
	    
	}

	@Then("validate responce time")
	public void validate_responce_time() {
		System.out.println("Resonce time ="+response.getTime());//time
		Assert.assertTrue(response.getTime()<2000);
	    
	}

	@Then("validate reponse should not be null")
	public void validate_reponse_should_not_be_null() {
		System.out.println("Is response null or not = "+(response.toString()!= null));
		Assert.assertTrue(response.toString()!= null);
	    
	}
}
