package tests;

import org.testng.annotations.Test;

import frameworkHelpers.DataReader;
import io.restassured.response.Response;
import testsHelpers.ApiRequests;
import testsHelpers.ReusableMethods;
import testsHelpers.TestMethods;

// Main Hotels API tests class, it is based on TestNG annotations and it trigger the main test methods
public class HotelsApiTests {

	TestMethods testmethods = new TestMethods();
	ApiRequests apiRequests = new ApiRequests();
	Response response;

	@Test
	public void postAsyncHotelsApiPositiveTests() {

		ReusableMethods.setBaseURL();
		response = apiRequests.postAHotelsAsyncApi(DataReader.dataReader("validToken"));
		testmethods.statusCodeAssertion(response, 200);
		testmethods.assertPostHotelsAsyncApiResponseBodyValues(response);
	}

	@Test
	public void postAsyncHotelsApiWithInvalidTokenNegativeTest() {

		ReusableMethods.setBaseURL();
		response = apiRequests.postAHotelsAsyncApi(DataReader.dataReader("invalidToken"));
		testmethods.statusCodeAssertion(response, 401);
	}
}
