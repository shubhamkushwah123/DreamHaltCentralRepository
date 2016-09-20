package com.dh.presentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import com.dh.business.service.implementation.LoginServiceImpl;
import com.dh.business.service.implementation.TokenServiceImpl;
import com.dh.business.service.interfaces.LoginServiceInterface;
import com.dh.business.service.interfaces.TokenServiceInterface;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.Test;
import com.dh.dao.entities.Token;
import com.dh.dao.entities.User;
import com.dh.presentation.dto.HomeScreenDTO;
import com.dh.presentation.dto.LinkDTO;


@Path("login")
public class LoginRestService {
	
	public static final String AUTHENTICATION_HEADER = "Authorization";
	
	LoginServiceInterface loginService = new LoginServiceImpl();
	TokenServiceInterface tokenService = new TokenServiceImpl();
	HomeScreenDTO homeScreenDto = new HomeScreenDTO();
	Login login = new Login();
	
	
	@GET
	@Path("/verify")
	@Produces(MediaType.APPLICATION_JSON)
	public HomeScreenDTO verifyUserLogin(@Context HttpHeaders httpHeaders)
	{
		String credentials = httpHeaders.getRequestHeader(AUTHENTICATION_HEADER).get(0);
		if(credentials.isEmpty()){
			System.out.println("Credentials are Empty");
			return null;
		}
		else {
				login = loginService.decodeCredentials(credentials);
				long userId = loginService.verifyLogin(login);
				if(userId!=0)
				{
					Token token = tokenService.generateToken(userId);
					if(tokenService.saveToken(token)){
						homeScreenDto.setToken(token);
						homeScreenDto.setLinkDTO(new LinkDTO());
					}
					else{
						System.out.println("Error in Inserting Token");
					}	
				}
				else
				{
					System.out.println("Invalid Credentials");
				}
			return homeScreenDto;
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@GET
	//@Path("/verify")
	@Path("/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public User verifyLogin(@PathParam("username") String username, 
							@PathParam("password") String password){
			User user = new User();
			System.out.println("USERNAME IS " + username);
			System.out.println("Password Is " + password);
			System.out.println("I am calling from Login Rest Service");
  
			  if((username!=null&&username!="")&&(password!=null&&password!="")){		
				  login.setUsername(username);
				  login.setPassword(password);
			  }
			  else{
				    login.setUsername("shubhamkushwah123@gmail.com");
			  		login.setPassword("Shubham123");
				  System.out.println("Please enter username & password");
				 return null;
			  }

		   user = loginService.verifyLogin(login);
		  String msg = null;
		  		if(user==null){
		  			msg = "Invalid username & Password";
		  		}
		  		else{
		  			msg = "User " + user.getFirstName() + "is successfully loggedIn";
		  		}
		  		System.out.println(msg);
		  		return user;
		}	
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Test test()
	{
		Login login = new Login();
		login.setUserId(1);
		login.setUsername("shubhamkushwah123@gmail.com");
		login.setPassword("lovemelove");
		login = null;
		Test test=new Test(1,"shubham",login);
		System.out.println(test.getId() + test.getName());
		return test;
	}
*/
}