package resources;

// This class holds request body payloads
public class ApiPayloads {

	public String postHotelsAsyncRequestBodyApi(String checkInDate, String checkOutDate) {

		return "{\"checkIn\":\"" + checkInDate + "\",\"checkOut\":\"" + checkOutDate
				+ "\",\"roomsInfo\":[{\"adultsCount\":2,\"kidsAges\":[]}],\"placeId\":\"ChIJrRnTjtx5_IgRPSii63qm5Sw\"}";
	}

}
