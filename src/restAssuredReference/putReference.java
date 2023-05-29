package restAssuredReference;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;
public class putReference {
	public static void main(String[] args) {
		//step 1 : declare baseUrl
		RestAssured.baseURI="https://reqres.in/";
		//Step 2 : configure Request Body
	//Using logs
		String responseBody=given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").log().all().when().put("/api/users/2").then().log().all().extract().response().asString();	
		int statusCode = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").log().all().when().put("/api/users/2").then().log().all().extract().statusCode();
		
	//System.out.println(statusCode);
	//System.out.println(responseBody);
	//Step 3 : Parse the responseBody
	JsonPath jsp = new JsonPath(responseBody);
	String res_name = jsp.getString("name");
	String res_job = jsp.getString("job");
	
	//Step 4 : Validate the responseBody parameter
	Assert.assertEquals(statusCode, 200);
	Assert.assertEquals(res_name, "morpheus");
	Assert.assertEquals(res_job,"zion resident");
	}
}

