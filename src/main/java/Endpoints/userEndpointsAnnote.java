package Endpoints;
import org.testng.annotations.*;

import io.restassured.response.Response;

public class userEndpointsAnnote {
static String loginResp;
	
	public static UserEndPoints userendpoints=new UserEndPoints();
	
	@BeforeTest
	public static void createuser() {
	//	userendpoints.registeruser();
	}
	
	@BeforeTest
	public static void loginuser() {
		Response loginresponse =userendpoints.loginuser();
		loginResp=loginresponse.path("data.token");
		System.out.print(loginResp);
	}
	
	@Test()
	public static void userprofile() {
		userendpoints.userprofile(loginResp);
	}


}
