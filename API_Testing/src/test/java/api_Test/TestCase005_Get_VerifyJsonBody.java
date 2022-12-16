package api_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase005_Get_VerifyJsonBody {
	
	@Test
	void validateHeaderInReqres()
	{
		
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in";
	
		//Send the Request To object
		RequestSpecification httpRequest=RestAssured.given();
		
		// Get Response from Object
		Response response=httpRequest.request(Method.GET,"/api/users?page=2");
		
		//Print response on console
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :- "+responseBody);
		
		//VeriFy All json Body
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("per_page"));
		System.out.println(jsonpath.get("page"));
		System.out.println(jsonpath.get("total"));
		System.out.println(jsonpath.get("total_pages"));
		//System.out.println(jsonpath.get("data"));
		
		Assert.assertEquals(jsonpath.get("per_page"), 6);
		Assert.assertEquals(jsonpath.get("page"), 2);
		Assert.assertEquals(jsonpath.get("total"), 12);
		Assert.assertEquals(jsonpath.get("total_pages"), 2);
		//Assert.assertEquals(jsonpath.get("data"), "[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!");
		
	
	}


}
