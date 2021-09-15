package testsHelpers;

import org.testng.Assert;

import frameworkHelpers.DataReader;
import io.restassured.response.ValidatableResponse;

// This class hold main test methods which will be called within TestNG annotated tests
public class TestMethods {

	ReusableMethods reusableMethods = new ReusableMethods();
	ApiRequests apiRequests = new ApiRequests();
	String stringResponse;
	ValidatableResponse objectResponse;

	// This method is to assert that Get Flights API is returning 200 upon a valid
	// request
	public void assertGetFlightsApiStatusCodeIsTwoHundred() {

		apiRequests.getFlightsApi().then().log().all().statusCode(200);
	}

	// This method is to assert some values within the request's body
	public void assertGetFlightsApiResponseBodyValues() {

		stringResponse = apiRequests.getFlightsApi().then().log().all().extract().asString();

		String actualOriginId = reusableMethods.getValueFromResponseBody(stringResponse, "request.leg[0].originId");
		String actualDestinationId = reusableMethods.getValueFromResponseBody(stringResponse,
				"request.leg[0].destinationId");

		Assert.assertEquals(DataReader.dataReader("expectedOriginID"), actualOriginId);
		Assert.assertEquals(DataReader.dataReader("expectedDestinationID"), actualDestinationId);
	}

	// This method is to assert that Post Hotels Async API is returning 200 upon a
	// valid
	// request
	public void assertPostHotelsAsyncApiStatusCodeIsTwoHundred() {

		objectResponse = apiRequests.postAHotelsAsyncApi().then().assertThat().statusCode(200);
	}

	// This method is to assert some values within the request's body payload
	public void assertPostHotelsAsyncApiResponseBodyValues() {

		stringResponse = apiRequests.postAHotelsAsyncApi().then().log().all().extract().asString();
		String sId = reusableMethods.getValueFromResponseBody(stringResponse, "sId");
		Assert.assertNotNull(sId);
	}
}
