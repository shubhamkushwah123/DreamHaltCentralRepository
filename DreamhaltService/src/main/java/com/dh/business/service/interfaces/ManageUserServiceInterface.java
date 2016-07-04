package com.dh.business.service.interfaces;

import java.util.List;

import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.ProfileImage;
import com.dh.dao.entities.User;
import com.dh.dao.entities.Verification;

public interface ManageUserServiceInterface {
	
	//Create Para
	
	public boolean registerUser(User user,Login login);
	
	public Address createUserAddress(long userId,Address address);
	
	public Verification createUserVerification(long userId,Verification verification);
	
	public ProfileImage createUserProfileImage(long userId,ProfileImage profileImage);
	
	
	//Validate Para
	
	public boolean validateUser(User user);
	
	public Address validateAddress(Address address);
	
	public Verification validateVerificationId(Verification verification);
	
	public ProfileImage validateProfileImage(ProfileImage profileImage);
	
	//Update Para
	
	public User updateUserGeneralDetails(User user);
	
	public Address updateUserAddress(Address address);
	
	public Verification updateUserVerification(Verification verification);
	
	public ProfileImage updateUserProfileImage(ProfileImage profileImage);
	
	//Retrieve Para
	
	public User getAllUserDetails(long userId);
	
	public List<Verification> getAllUserVerification(long userId);
	
	public User getGeneralUserDetails(long userId);
	
	public Address getUserAddress(long addressId);
	
	public ProfileImage getUserProfileImage(long imageId);
	
	public Verification getUserVerification(long verificationId);
	
	public boolean checkIfUsernameExist(String userName);
	
	
	
	

}
