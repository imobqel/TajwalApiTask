package testsHelpers;

import static io.restassured.RestAssured.given;

import org.testng.internal.collections.Pair;

import frameworkHelpers.DataReader;
import io.restassured.response.Response;
import resources.ApiPayloads;

// This class holds the actual implementation of both GET & POST requests using RestAssured
public class ApiRequests {

	Response response;
	ReusableMethods reusableMethods = new ReusableMethods();
	DateHelper datehelper = new DateHelper();
	Pair<String, String> randomDatePairs = datehelper.getTwoRandomDates();
	Pair<String, String> randomConsecutiveDatePairs = datehelper.getTwoRandomConsecutiveDates();
	ApiPayloads apiPayloads = new ApiPayloads();

	// GetFlightsAPI main implementation method
	public Response getFlightsApi() {

		return response = given().when().log().all()
				.queryParam("query",
						DataReader.dataReader("expectedOriginID") + "-" + DataReader.dataReader("expectedDestinationID")
								+ "/" + randomDatePairs.first() + "/" + randomDatePairs.second() + "/"
								+ DataReader.dataReader("cabinType") + "/" + DataReader.dataReader("passengers"))
				.get(DataReader.dataReader("searchFlightsApiResource"));
	}

	// PostAsyncHotelsAPI main implementation method
	public Response postAHotelsAsyncApi() {

		return response = given().log().all().header("content-type", DataReader.dataReader("contentType"))
				.header("token", DataReader.dataReader("token")).header("accept", DataReader.dataReader("accept"))
				.body(apiPayloads.postHotelsAsyncRequestBodyApi(randomConsecutiveDatePairs.first(),
						randomConsecutiveDatePairs.second()))
				.when().post(DataReader.dataReader("asyncHotelsApiResource"));
	}
}
