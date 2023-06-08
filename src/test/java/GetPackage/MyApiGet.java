package GetPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Iterator;
import java.util.List;

public class MyApiGet {
	
	@Test

	public void testGetRequest() {
		// Set base URI
		RestAssured.baseURI = "https://reqres.in/api/users?page=1";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "");
		System.out.println("status received==>" + response.statusLine());
		System.out.println("The Response Body is ===>" + response.asString());
		
		//Getting First Name Values from the Users Get Call
		System.out.println("List of First Name of all of the users");
		List<String> firstName = response.jsonPath().getList("data.first_name");
		for (String element: firstName) {
			System.out.println(element);
			
		}
		//Getting Last Name Values from the Users Get Call
		System.out.println("List of Last Name of all of the users");
		List<String> lastName=response.jsonPath().getList("data.last_name"); 
		for (String element1: lastName) {
			System.out.println(element1);
		//Validating the response code String statusCode=response.statusLine();
	    Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	    
	 //Validating the user details
	Assert.assertEquals(response.jsonPath().getString("data[0].id"), "1");
	Assert.assertEquals(response.jsonPath().getString("data[0].email"), "george.bluth@reqres.in");
	Assert.assertEquals(response.jsonPath().getString("data[0].first_name"), "George");
	Assert.assertEquals(response.jsonPath().getString("data[0].last_name"), "Bluth");
	Assert.assertEquals(response.jsonPath().getString("data[0].avatar"), "https://reqres.in/img/faces/1-image.jpg");
		

	}
	}
}

