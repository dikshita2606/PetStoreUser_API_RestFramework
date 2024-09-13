package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java 
//Created to perform CRUD operation :- Create, Read, Update, Delete requests to the User services 

public class UserEndpoints2 {
	
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //Path is not required method by default gets the path
		return routes;
	}
	
	
	//Create User
	public static Response createUser(User payload) {
		String post_url = getURL().getString("post_url");
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)			
			
		.when()
			.post(post_url);
		
		return response;
	}
	
	//Get User
	public static Response readUser(String username){
		Response response= given()
				.pathParam("username",username)			
				
		.when()
			.get(getURL().getString("get_url"));
		
		return response;
	}
	
	//Update User
	public static Response updateUser(String username, User payload) {
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",username)	
			.body(payload)
			
		.when()
			.put(getURL().getString("update_url"));
		
		return response;
	}
	
	//Delete User
	public static Response deleteUser(String username) {
		Response response= given()
			.pathParam("username",username)	
			
		.when()
			.delete(getURL().getString("delete_url"));
		
		return response;
	}
}
