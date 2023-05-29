package restAssuredReference;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
public class soap2Ref {
	public static void main(String[] args) {
		//Step 1 : Declare baseURI and requestbody
		String baseURI="https://www.dataaccess.com";
		String requestbody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>100</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		//Step 2 : Configure API and requestbody
		RestAssured.baseURI=baseURI;
		//Step 3 : Configure responsebody
		String responsebody=given().header("Content-Type","text/xml; charset=utf-8").body(requestbody).when()
				.post("webservicesserver/NumberConversion.wso").then().extract().response().asString();
		System.out.println(responsebody);
		//Step 3.1 : Configure requestbody
		XmlPath xmlrequest= new XmlPath(requestbody);
		String req_param = xmlrequest.getString("ubiNum");
		System.out.println(req_param);
		
		XmlPath xml = new XmlPath(responsebody);
		String result = xml.getString("responsebody");
		
		//Validate responseBody parameter
		Assert.assertEquals(result, "one hundred ");
		
	}
}

	


