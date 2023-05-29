package restAssuredReference;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
public class postReference {
	public static void main(String[] args) {
	//Step 1 : Declare Base Url
	RestAssured.baseURI="https://reqres.in";
	//Step 2 : Configure Request Body
//Using log 
	String responseBody = given().header("Content-Type","application/json").body("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\",\r\n"
			+ "    \"id\": \"582\",\r\n"
			+ "    \"createdAt\": \"2023-05-05T09:59:37.889Z\"\r\n"
			+ "}").log().all().when().post("/api/users/").then().log().all().extract().response().asString();
//Without log
	int Statuscode=given().header("Content-Type","application/json").body("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\",\r\n"
			+ "    \"id\": \"582\",\r\n"
			+ "    \"createdAt\": \"2023-05-05T09:59:37.889Z\"\r\n"
			+ "}").when().post("/api/users/").then().extract().statusCode();
	System.out.println(responseBody);
	
   String responseBody1 = given().header("Content-Type","application/json").body("{\r\n"
   		+ "    \"name\": \"morpheus\",\r\n"
   		+ "    \"job\": \"leader\",\r\n"
   		+ "    \"id\": \"582\",\r\n"
   		+ "    \"createdAt\": \"2023-05-05T09:59:37.889Z\"\r\n"
   		+ "}").when().post("api/users/").then().extract().response().asString();
	
   //System.out.println(statusCode);
  //System.out.println(responseBody);

//Step 3 :  Parse the responseBody
JsonPath jsp = new JsonPath(responseBody1);
String res_name  = jsp.getString("name");
String res_job = jsp.getString("job");
String res_id= jsp.getString("id");
String res_createdAt = jsp.getString("createdAt");

//Step 4 : Validate the responseBody parameters
Assert.assertEquals(Statuscode,201);
Assert.assertEquals(res_name,"morpheus");
Assert.assertEquals(res_job,"leader");
Assert.assertNotNull(res_id,"582");
Assert.assertNotNull(res_createdAt,"2023-05-05T09:59:37.889Z");
	}
}





