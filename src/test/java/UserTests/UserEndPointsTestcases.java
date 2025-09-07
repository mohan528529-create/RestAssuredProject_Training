package UserTests;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.Matchers.*;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Endpoints.UserEndPoints;
import Utilities.XLUtility;
import io.restassured.response.Response;

public class UserEndPointsTestcases {
	static String loginResp;
	
	static Response response;
	
	
	public static UserEndPoints userendpoints=new UserEndPoints();
	public static XLUtility xlutility=new XLUtility();
	
	
	@Test(priority=1)
	public static void createuser() throws IOException {
		HashMap hashmap=new HashMap();
		hashmap.put("name",xlutility.readexceldata(1,0));
		System.out.println(xlutility.readexceldata(1,0));
		hashmap.put("email",xlutility.readexceldata(1,1)+Math.floor(Math.random()*1000)+"@gmail.com");
		System.out.println(xlutility.readexceldata(1,1));
		hashmap.put("password",xlutility.readexceldata(1,2));
		System.out.println(xlutility.readexceldata(1,2));
		response=userendpoints.registeruser(hashmap);
			
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
