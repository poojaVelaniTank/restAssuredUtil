package restAssuredReference;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
public class patchReference {
	public static void main(String[] args) {
		//Step 1 : Declare Base Url
		RestAssured.baseURI="https://reqres.in/";
		
		//Step 2 :  Configure Request Body
		//using log
		String responseBody=given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").log().all().when().patch("/api/users/2").then().log().all().extract().response().asString();
int statusCode=	given().header("Content-type","application/json").body("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"zion resident\"\r\n"
			+ "}").log().all().when().patch("/api/users/2").then().log().all().extract().statusCode();
	

    //System.out.println(statusCode);
	//System.out.println(responseBody);
	
    //Step 4 : Parse the responseBody
	JsonPath jsp = new JsonPath(responseBody);
	String res_name = jsp.getString("name");
	String res_job = jsp.getString("job");
	//Step 5 : Validate the responseBody Parameters
	Assert.assertEquals(statusCode, 200);
	Assert.assertEquals(res_name,"morpheus");
	Assert.assertEquals(res_job,"zion resident");
	}
}
	
	
			
	

