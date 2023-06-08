package PostPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class MyApiPost {
  @Test
  public void testPostRequest() {
	  RequestSpecification request= RestAssured.given();
	   
	   String jsonString = "{\"name\" : \"Sudha\",\"password\" : \"Sudha1997\"}";
	   request.contentType(ContentType.JSON);
	   request.baseUri("https://reqres.in/api/users");
       request.body(jsonString);
	   Response response = request.post();
	   System.out.println(response.asString());
	   
	   
	  //Validate status code
	   int statusCode=response.getStatusCode();
	   Assert.assertEquals(statusCode, 201);
	   
	   ///Retrieving the ID from the response
	   System.out.println(response.jsonPath().getString("id"));
	   
	   //Validating the user details
	   Assert.assertEquals(response.jsonPath().getString("name"), "Sudha");
	   Assert.assertEquals(response.jsonPath().getString("password"), "Sudha1997");

  }
}
