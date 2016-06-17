package com.dh.presentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dh.business.service.implementation.LoginService;




@Path("login")
public class LoginTestService {
	
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getIt() {
	  
		 System.out.println("I am calling from Rest Service");
	  
		
	    LoginService loginService = new LoginService();
		 if(loginService.verifyLogin("shubham","kushwah"))
		 {
	        return "Got it!";
		 }
		 else
		 {
			 
		 }
	    return " got it";
	 }

}
