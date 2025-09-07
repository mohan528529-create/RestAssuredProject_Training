package UserTests;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;
import Payloads.POJO;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Endpoints.UserEndPoints;
import io.restassured.response.Response;

public class UserEndpoints_POJO {
static String loginResp;
	
	static Response response;	
	
	static POJO pojo =new POJO("mohanV","test"+Math.floor(Math.random()*1000)+"@gmail.com","junnu@1234");
	public static UserEndPoints userendpoints=new UserEndPoints();
	
	
	
	@Test(priority=1)
	public static void createuser() throws IOException {
		HashMap hashmap=new HashMap();
		response=UserEndPoints.registeruser(pojo);
			
		}
	
	@Test(priority=2)
	public static void loginuser() {
		response =userendpoints.loginuser();
		loginResp=response.path("data.token");
		System.out.print(loginResp);
		
	}
	
	@Test(priority=3)
	public static void userprofile() {
		response=userendpoints.userprofile(loginResp);
		
			}
@AfterMethod
	public static void validateResposnses(ITestResult result)
	{
	switch(result.getMethod().getMethodName())
	{
	case "createuser":
		response.then().assertThat().statusCode(201);
		response.then().assertThat().body("data.name", equalTo("mohanV"));
		System.out.println("create user name is validated");
		response.then().assertThat().header("content-type","application/json; charset=utf-8");
		break;
	case "loginuser":
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body("data.email", equalTo("mohanv444@gmail.com"));
		System.out.println("login user email is validated");
		response.then().assertThat().header("content-type","application/json; charset=utf-8");
		break;
	case "userprofile":
		response.then().assertThat().statusCode(200);
		response.then().assertThat().header("content-type","application/json; charset=utf-8"	);
		break;
	}
	
	}

}
