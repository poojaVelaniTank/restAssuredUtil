package restAssuredReference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class deleteReference {

	public static void main(String[] args) {

   RestAssured.baseURI="https://reqres.in/";
   
   int statusCode=given().header("Content-Type","application/json").body("").log().all().when().
		   delete("/api/users/2").then().log().all().extract().statusCode();
   
   String responseBody=given().header("Content-Type","application/json").body("").log().all().
		   when().delete("/api/users/2").then().log().all().extract().response().asString();
   
  
	}
}
		  
   
	

