package restAssuredReference;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.*;

public class GetReference {

    public static void main(String[] args) {

        // Step 1 :Declare BaseURL
        RestAssured.baseURI = "https://reqres.in/";

        // Step 2:Configure Response Body
        String responseBody = given().header("Content-Type","application/json").log().all().when().
        		get("/api/users?page=2").then().log().all().extract().response().asString();
        int statusCode = given().header("Content-Type","application/json").log().all().when().
        		get("/api/users?page=2").then().log().all().extract().statusCode();
        System.out.println(statusCode);
        System.out.println(responseBody);
        //expected result
        int id []= {7,8,9,10,11,12};
        String [] email = {"michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", 
        	  "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in"};
        
        JsonPath jsp = new JsonPath(responseBody);
        int count=jsp.getList("data").size();
       
        //System.out.println(count);
        
        //validate each object
        for (int i=0 ; i<count ; i++)
        {
        	int exp_id=id[i];
        	String exp_email=email[i];
        	
        	String res_email = jsp.getString("data["+i+"].email");
            String res_id = jsp.getString("data["+i+"].id");
            int res_int_id = Integer.parseInt(res_id);
            
            Assert.assertEquals(res_email,exp_email,"email at index" +i);
            Assert.assertEquals(res_int_id , exp_id, "id at index" +i);
        }
    }	
}   	
        
        
        

        