package api.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payloads.Store;
import io.restassured.response.Response;

public class StoreTests {
	
	Faker faker;
	Store storePayload;
	//public Logger logger;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		storePayload = new Store();
		
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(5);
		storePayload.setShipdate("2024-03-19T16:11:53.243Z");
		storePayload.setStatus("complete");
		storePayload.setComplete(true);
		
	}
	@Test
	public void testPostStore() {
		Response response = StoreEndPoints.createStore(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	
}
