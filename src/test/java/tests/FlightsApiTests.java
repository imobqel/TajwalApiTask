package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import testsHelpers.ApiRequests;
import testsHelpers.ReusableMethods;
import testsHelpers.TestMethods;

// Main Flights API tests class, it is based on TestNG annotations and it triggers the main test methods
public class FlightsApiTests {

	TestMethods testmethods = new TestMethods();
	ApiRequests apiRequests = new ApiRequests();
	Response response;

	@Test
	public void getFlightApiPositiveTests() {

		ReusableMethods.setBaseURL();
		response = apiRequests.getFlightsApi();
		testmethods.statusCodeAssertion(response, 200);
		testmethods.assertGetFlightsApiResponseBodyValues(response);
	}
}
