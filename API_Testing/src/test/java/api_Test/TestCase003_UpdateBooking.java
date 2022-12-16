package api_Test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase003_UpdateBooking {
	
	@Test
	void updateData()
	{
		
		//Specify Base URI
				RestAssured.baseURI="BookingUrl";
			
				//Send the Request To object
				RequestSpecification httpRequest=RestAssured.given();
				
				//Send Payload
				JSONObject requestPara=new JSONObject();
				requestPara.put("city", "Pune");
				requestPara.put("State", "Maharastra");
				
				httpRequest.header("Content type","Application/json");
				httpRequest.body(requestPara.toJSONString()); //data attach to request
				
				// Get Response from Object
				Response response=httpRequest.request(Method.PUT,"/urn");
				
				//Print response on console
				String responseBody=response.getBody().asString();
				System.out.println("Response Body is :- "+responseBody);
				
				//Status code verification
				int statusCode=response.getStatusCode();
				System.out.println("Status code is :- "+statusCode);
				Assert.assertEquals(statusCode, 201);
	}

}
