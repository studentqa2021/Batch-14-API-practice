package com.http.method.cucumber;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Batch14StepDef {

	Response response;
	JsonObject json;
	@Given("select HTTP methods {string} and go to URL {string}")
	public void select_http_methods_and_go_to_url(String method, String URL) {
		if (method.contains("GET")) {
			response = RestAssured.get(URL);
			response.prettyPrint();
		} else if (method.contains("DELETE")) {
			response = RestAssured.delete(URL + "14");
			response.prettyPrint();
		}else if(method.contains("POST")) {
			
			RequestSpecification request = RestAssured.given();
			request.header("Content-type", "application/json");

			request.body(json.toString());
			 response = request.post("http://localhost:3000/posts");

		}
	}
	@When("pass test data\"POST\"")
	public void pass_test_data_post() {
		 json = new JsonObject();
			json.addProperty("title", "Automation");
			json.addProperty("author", "Student");
	}
	@When("pass test data\"PUT\"")
	public void pass_test_data_put() {
		 json = new JsonObject();
			json.addProperty("title", "Manual");
			json.addProperty("author", "Student");
	}

	@Then("validate my test")
	public void validate_my_test() {

		System.out.println("Status code =" + response.getStatusCode());// 200
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Data format =" + response.getContentType());// json
		Assert.assertTrue(response.getContentType().contains("json"));
		System.out.println("Resonce time =" + response.getTime());// time
		Assert.assertTrue(response.getTime() < 2000);
		System.out.println("Is response null or not = " + (response.toString() != null));
		Assert.assertTrue(response.toString() != null);
	}

}
