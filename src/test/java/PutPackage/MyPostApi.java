package PutPackage;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MyPostApi {
  @Test
  public void testPostApi() {
	  JSONObject request = new JSONObject();
      //passing data to be modified in put() as arguments
      request.put("name", "Chandra");
      System.out.println(request);
      System.out.println(request.toJSONString());
      // Directly checking the status code of the given URL
      given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
      when().
      put("https://reqres.in/api/users/0").
      then().
      statusCode(200);
      
  }
  
}
