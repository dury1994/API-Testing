package api_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase_002_GET_Booking {
	
	@Test
	void getBookingDetails()
	{
		
		//Specify Base URI
		RestAssured.baseURI="url";
	
		//Send the Request To object
		RequestSpecification httpRequest=RestAssured.given();
		
		// Get Response from Object
		Response response=httpRequest.request(Method.GET,"/urn");
		
		//Print response on console
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);

		
		//Status code verification
		int statusCode=response.getStatusCode();
		System.out.println("Status code is :- "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Verify Status Line
		String statusLine=response.getStatusLine();
		System.out.println("Status line is :- "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ok");
		
	}

}
