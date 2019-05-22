package apis;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;

public class APITesting {

	public String getFirstID() {

		String baseURI = "https://petstore.swagger.io/v2/pet/findByStatus";
		String parameter1 = "status";
		String value1 = "available";
		String serviceEndpoint = baseURI + "?" + parameter1 + "=" + value1;

		RequestSpecification request = RestAssured.given();

		Response response = request.when().get(serviceEndpoint);
		ResponseBody body = response.getBody();
		
		String responseTxt = body.asString();
		int idBegin = responseTxt.indexOf("id");
		String firstID = responseTxt.substring(idBegin+4,15);
		return firstID;
	}
}
