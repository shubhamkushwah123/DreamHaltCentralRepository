package com.dh.presentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dh.business.service.implementation.LoginServiceImpl;
import com.dh.business.service.interfaces.LoginServiceInterface;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;




@Path("login")
public class LoginTestService {
	
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getIt() {
	  
	  System.out.println("I am calling from Rest Service");
	  Login login = new Login();
	  login.setUsername("shubhamkushwah123@gmail.com");
	  login.setPassword("Shubham123");
	  LoginServiceInterface loginService = new LoginServiceImpl();
	  User user = loginService.verifyLogin(login);
	  String msg = null;
	  if(user==null){
		 msg = "Invalid username & Password";
	  }
	  else{
		 msg = "User " + user.getFirstName() + "is successfully loggedIn";
	  }
	  return msg;
	 }

}
