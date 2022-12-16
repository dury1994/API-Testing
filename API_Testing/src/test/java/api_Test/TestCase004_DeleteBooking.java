package api_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase004_DeleteBooking {
	
	@Test
	void validateHeaderInReqres()
	{
		
		//Specify Base URI
		RestAssured.baseURI="url";
	
		//Send the Request To object
		RequestSpecification httpRequest=RestAssured.given();
		
		// Get Response from Object
		Response response=httpRequest.request(Method.DELETE,"/id");
		
		//Print response on console
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);
		
		//Verify Response Body
		Assert.assertEquals(responseBody.contains("Delete Succefully"), true);
		
	}

}
