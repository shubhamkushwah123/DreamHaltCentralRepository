package test.dh.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("login")
public class LoginTestService {
	
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getIt() {
	  
		 System.out.println("I am calling from Rest Service");
	    return " got it";
		
	    //LoginService loginService = new LoginService();
		/* if(loginService.verifyLogin(username,password)
		 {
	        return "Got it!";
		 }
		 else
		 {
			 
		 }*/
	 }

}
