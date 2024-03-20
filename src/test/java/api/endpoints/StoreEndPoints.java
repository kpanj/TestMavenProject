package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	//method created for getting the data from property file
		static ResourceBundle getURL() {
			ResourceBundle routes = ResourceBundle.getBundle("routes");//load prooperty file	
			return routes;
		}
		public static Response createStore(Store payload) {
			
			String post_url = getURL().getString("store_post_url");
			Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(post_url);
			return response;
		}
	
	
}
