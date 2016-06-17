package com.dh.business.service.implementation;

public class LoginService {
	
	public boolean verifyLogin(String username, String password)
	{
		
		if(username.equalsIgnoreCase("shubham") && password.equalsIgnoreCase("kushwah"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
