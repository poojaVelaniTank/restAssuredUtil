package restAssuredReference;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
public class soapReference {
	public static void main(String[] args) {
		//Step 1 : Declare baseURI and request body variables
		String baseURI="https://www.dataaccess.com";
		String requestbody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>100</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		//Step 2 : Fetch request parameter
		XmlPath xmlreq=new XmlPath(requestbody);
		String req_param= xmlreq.getString("ubiNum");
		System.out.println(req_param);
		//Step 3 : Configure the API and fetch responseBody
		RestAssured.baseURI=baseURI;
      String responsebody=given().header("Content-Type","text/xml; charset=utf-8").body(requestbody).when().post("webservicesserver/NumberConversion.wso")
		.then().extract().response().getBody().asString();
      System.out.println(responsebody);
      //Step 4 : Parse the responseBody and fetch the response parameters
      XmlPath xml_res= new XmlPath(responsebody);
      String Result = xml_res.getString("responseBody");
      System.out.println(Result);
      //Step 5 : validate responseBody parameter
      Assert.assertEquals(Result, "one hundred ");
	}
}
	

	
		
	


