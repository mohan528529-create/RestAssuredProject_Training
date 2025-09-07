package Payloads;

public class POJO {
	
	private static String name;
	private static String email;
	private static String password;
	
	//classname objectname=new classname();
	
	public POJO(String Name,String Email,String Password) {
		
		this.name=Name;
		this.email=Email;
		this.password=Password;
		
	}
	public String getName()
	{
		return name;
	}
	
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}

}
