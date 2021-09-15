package testsHelpers;

import frameworkHelpers.DataReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

// This class holds any reusable method that could be shared among tests/other methods
public class ReusableMethods {

	// This method is to set the API's Base URI
	public static void setBaseURL() {

		RestAssured.baseURI = DataReader.dataReader("baseURL");
	}

	// This method is to extract a value out of a response body
	public String getValueFromResponseBody(String response, String key) {

		JsonPath js = new JsonPath(response);
		return js.getString(key);
	}
}
