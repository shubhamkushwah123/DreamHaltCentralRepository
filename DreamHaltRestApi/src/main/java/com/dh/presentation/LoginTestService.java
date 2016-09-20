package com.dh.presentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dh.business.service.implementation.LoginServiceImpl;
import com.dh.business.service.interfaces.LoginServiceInterface;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;




@Path("loginTest")
public class LoginTestService {
	
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public long getIt() {
	  
	  System.out.println("I am calling from Rest Service");
	  Login login = new Login();
	  login.setUsername("shubhamkushwah123@gmail.com");
	  login.setPassword("Shubham123");
	  LoginServiceInterface loginService = new LoginServiceImpl();
	  long userId = loginService.verifyLogin(login);
	  String msg = null;
	  if(userId!=0){
		 msg = "Invalid username & Password";
	  }
	  else{
		 msg = "User " + userId + "is successfully loggedIn";
	  }
	  return userId;
	 }

}
