package com.test.Service;

import com.dh.business.service.implementation.LoginServiceImpl;
import com.dh.business.service.implementation.ManageUserServiceImpl;
import com.dh.business.service.interfaces.LoginServiceInterface;
import com.dh.business.service.interfaces.ManageUserServiceInterface;
import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;

public class CheckLoginTest {
	
	public static void main(String args[])
	{
		
		//testLogin();
		testAddAddress();
		
		
	}

	private static void testAddAddress() {
		Address address = getAddress();
		ManageUserServiceInterface userService = new ManageUserServiceImpl();
		userService.createUserAddress(26, address);
		
	}
	
	public static Address getAddress() {
		Address address = new Address();
		address.setType('P');
		address.setHouseNo("69-B");
		address.setStreet("Dummy");
		address.setColony("Vidhyapati Nagar");
		address.setArea("Nanakheda");
		address.setLandmark("Near Maharaja Dhabha");
		address.setPincode("456010");
		address.setCity("Ujjain");
		address.setState("MP");
		address.setCountry("INDIA");
		return address;
	}

	private static void testLogin() {
		// TODO Auto-generated method stub
		Login login = new Login();
		login.setUsername("shubhamkushwah123@gmail.com");
		login.setPassword("Shubham123");
		LoginServiceInterface loginService = new LoginServiceImpl();
		User user = loginService.verifyLogin(login);
		if(user==null)
		{
			System.out.println("Invalid Username & Password");
		}
		else
		{
			System.out.println("User" + user.getFirstName() + "is successfully Logged In.");
		}
		
	}

}
