package tests;

import org.testng.annotations.Test;

import testsHelpers.ReusableMethods;
import testsHelpers.TestMethods;

// Main Flights API tests class, it is based on TestNG annotations and it triggers the main test methods
public class FlightsApiTests {

	TestMethods testmethods = new TestMethods();

	@Test(priority = 1)
	public void getFlightApiStatusCodeTest() {

		ReusableMethods.setBaseURL();
		testmethods.assertGetFlightsApiStatusCodeIsTwoHundred();
	}

	@Test(priority = 2)
	public void getFlightApiResponseBodyTest() {

		ReusableMethods.setBaseURL();
		testmethods.assertGetFlightsApiResponseBodyValues();
	}
}
