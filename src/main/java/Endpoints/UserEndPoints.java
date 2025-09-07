package Endpoints;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import Payloads.POJO;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class UserEndPoints {
	public static Routes routes=new Routes();
	
	
	public static Response registeruser(POJO pojo)
	{
		//Given is for Request date
		//When is for Request method
		//Then is for Response data		
		
			
		Response createResp=given().baseUri(routes.Baseurl).and().basePath(routes.Register_endpoint).header("Content-Type","application/json").header("accept","application/json").body(pojo)	   
		.when().post()
		.then().log().all().extract().response();
		return createResp;
	    
	}

	public static Response loginuser()
	{
		
		 Response response = given().baseUri(routes.Baseurl).and().basePath(routes.Login_endpoint).header("Content-Type","application/json").body("{\"email\":\"mohanv444@gmail.com\",\"password\":\"junnu@1234\"}")	   
			.when().post()
			.then().log().all().extract().response();
			return response;
	}
	

	public static Response userprofile(String tokenid)
	{
		Response responsereturned=given().baseUri(routes.Baseurl).and().basePath(routes.Profile_endpoint).header("Content-Type","application/json").header("x-auth-token",tokenid)	   
		.when().get()
		.then().log().all().extract().response();
		return responsereturned;
		
	}
	
	public static Response registeruser(Map hashmap)
	{
		//Given is for Request date
		//When is for Request method
		//Then is for Response data		
		
			
		Response createResp=given().baseUri(routes.Baseurl).and().basePath(routes.Register_endpoint).header("Content-Type","application/json").header("accept","application/json").body(hashmap)	   
		.when().post()
		.then().log().all().extract().response();
		return createResp;
	    
	}

	
}
