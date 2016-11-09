package com.dh.presentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import com.dh.business.service.implementation.ManageUserServiceImpl;
import com.dh.business.service.implementation.TokenServiceImpl;
import com.dh.business.service.interfaces.ManageUserServiceInterface;
import com.dh.business.service.interfaces.TokenServiceInterface;
import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.Token;
import com.dh.dao.entities.User;
import com.dh.presentation.dto.DreamHalt;
import com.dh.presentation.dto.Links;
import com.dh.service.constants.ServiceConstants;


@Path("user")
public class UserRestService {
	
	ManageUserServiceInterface userService = new ManageUserServiceImpl();
	TokenServiceInterface tokenService = new TokenServiceImpl();
	DreamHalt dreamHalt = new DreamHalt();
	Links links = new Links();
	String message="";
	
	//GET USER
	@GET
	@Path("/get/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public DreamHalt getUser(@Context HttpHeaders httpHeaders,
							@PathParam("userId") long userId){
	
		try{
			String tokenKey = httpHeaders.getHeaderString(ServiceConstants.AUTHENTICATION_HEADER);
			if(tokenKey!=null){
				Token token = tokenService.validateToken(tokenKey);
				dreamHalt.setToken(token);
				
				if(token!=null){
					User user = userService.getGeneralUserDetails(userId);
					
					if(user!=null){
						dreamHalt.setUser(user);
						message = "User has been retrieved successfully";
					}
				}
			}
			else{
				throw new Exception("authorization header is empty");
			}
			
		} catch(Exception e) {
			message = e.getMessage();
		}
	dreamHalt.setResponseMessage(message);
	dreamHalt.setLinks(links);
	return dreamHalt;
	}
	
	//UpdateUser
	@PUT
	@Path("/edit/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DreamHalt updateUser(@Context HttpHeaders httpHeaders,
								@PathParam("userId") long userId,
								User user){
		
		try{
			String tokenKey = httpHeaders.getHeaderString(ServiceConstants.AUTHENTICATION_HEADER);
			if(tokenKey!=null){
				Token token = tokenService.validateToken(tokenKey);
				dreamHalt.setToken(token);
				
				if(token!=null){
				
					user.setId(userId);
					User usr = userService.updateUserGeneralDetails(user);
					
					if(usr!=null){
						
						dreamHalt.setUser(usr);
						message = "User has been updated successfully";
					}
					else{
						message = "User does not exist";
					}
				}
				else{
					message = "Token Expired";
				}
			}
			else{
				message = "Authentication header is empty";
			}
			
		} catch(Exception e) {
			message = e.getMessage();
		}
		dreamHalt.setResponseMessage(message);
		dreamHalt.setLinks(links);
		return dreamHalt;
	}
	
	
	
	//Create User
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DreamHalt createUser(@Context HttpHeaders httpHeaders,
								User user){
		try{
			Login login = new Login();
			login.setUsername(user.getEmail());
			login.setPassword(user.getPassword());
			boolean success = userService.registerUser(user, login);
			if(success){
				message = "User has been successfully registered";
			}
		} catch(Exception e){
			message = e.getMessage();
		}
		dreamHalt.setResponseMessage(message);
		dreamHalt.setLinks(links);
		return dreamHalt;
	}
	
	
	//DELETE User
	@DELETE
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DreamHalt deleteUser(){
		
		return null;
	}
	
	
	@PUT
	@Path("/address/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public DreamHalt updateAddress(@Context HttpHeaders httpHeaders,
						Address address){
		try{
			String tokenKey = httpHeaders.getHeaderString(ServiceConstants.AUTHENTICATION_HEADER);
				if(tokenKey!=null){
					Token token = tokenService.validateToken(tokenKey);
					dreamHalt.setToken(token);
					if(token!=null){
					Address adres = userService.updateUserAddress(address);
					User user = new User();
					user.setAddress(address);
					dreamHalt.setUser(user);
					dreamHalt.setResponseMessage("Address Updated Successfully");
					}
				}
		} catch(Exception e){
			dreamHalt.setResponseMessage(e.getMessage());
		}
		
		return dreamHalt;
	}
	
	
	
	//CreateAddress
	@POST
	@Path("/address/create/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DreamHalt createAddress(@Context HttpHeaders httpHeaders,
								   @PathParam("userId") long userId,
								   Address address){
		try{
			String tokenKey = httpHeaders.getHeaderString(ServiceConstants.AUTHENTICATION_HEADER);
				if(tokenKey!=null){
					Token token = tokenService.validateToken(tokenKey);
					dreamHalt.setToken(token);
					if(token!=null){
						Address adres = userService.createUserAddress(userId, address);
						User user = new User();
						user.setAddress(address);
						dreamHalt.setUser(user);
					}
				}
			}
			catch(Exception e){
			dreamHalt.setResponseMessage(e.getMessage());
			}
		
		dreamHalt.setLinks(links);
		return dreamHalt;
	}
}
