package tests;

import org.testng.annotations.Test;

import testsHelpers.ReusableMethods;
import testsHelpers.TestMethods;

//Main Hotels API tests class, it is based on TestNG annotations and it triggeres the main test methods
public class HotelsApiTests {

	TestMethods testmethods = new TestMethods();

	@Test(priority = 1)
	public void postAsyncHotelsApiStatusCodeTest() {

		ReusableMethods.setBaseURL();
		testmethods.assertPostHotelsAsyncApiStatusCodeIsTwoHundred();
	}

	@Test(priority = 2)
	public void postAsyncHotelsApiResponseBodyTest() {

		ReusableMethods.setBaseURL();
		testmethods.assertPostHotelsAsyncApiResponseBodyValues();
	}
}
