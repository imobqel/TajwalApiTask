package testsHelpers;

import org.testng.Assert;

import frameworkHelpers.DataReader;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

// This class hold main test methods which will be called within TestNG annotated tests
public class TestMethods {

	ReusableMethods reusableMethods = new ReusableMethods();
	ApiRequests apiRequests = new ApiRequests();
	String stringResponse;
	ValidatableResponse objectResponse;

	// This method is to assert some values within the response's body of GET
	// Flights API
	public void assertGetFlightsApiResponseBodyValues(Response response) {

		stringResponse = response.then().extract().asString();

		String actualOriginId = reusableMethods.getValueFromResponseBody(stringResponse, "request.leg[0].originId");
		String actualDestinationId = reusableMethods.getValueFromResponseBody(stringResponse,
				"request.leg[0].destinationId");

		Assert.assertEquals(DataReader.dataReader("expectedOriginID"), actualOriginId);
		Assert.assertEquals(DataReader.dataReader("expectedDestinationID"), actualDestinationId);
	}

	// This method is to assert some values within the response's body of Post
	// Hotels Async API
	public void assertPostHotelsAsyncApiResponseBodyValues(Response response) {

		stringResponse = response.then().extract().asString();

		String sId = reusableMethods.getValueFromResponseBody(stringResponse, "sId");
		Assert.assertNotNull(sId);
	}

	// This method is to assert the response's status code
	public void statusCodeAssertion(Response response, int statusCode) {

		response.then().log().all().assertThat().statusCode(statusCode);
		System.out.println("Status code = " + statusCode);
	}
}
