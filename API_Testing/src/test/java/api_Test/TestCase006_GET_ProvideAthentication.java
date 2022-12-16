package api_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase006_GET_ProvideAthentication {
	
	@Test
	void validateHeaderInReqres()
	{
		
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in";
		
		//Provide AThentication
		PreemptiveBasicAuthScheme athentn= new PreemptiveBasicAuthScheme ();
		athentn.setUserName("Duryodhan");
		athentn.setPassword("Dury1234");
		
		RestAssured.authentication=athentn;
	
		//Send the Request To object
		RequestSpecification httpRequest=RestAssured.given();
		
		// Get Response from Object
		Response response=httpRequest.request(Method.GET,"/api/users?page=2");
		
		//Print response on console
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);
		
		//Verify Response Body
		Assert.assertEquals(responseBody.contains("To keep ReqRes free"), true);
		
		
	}


}
