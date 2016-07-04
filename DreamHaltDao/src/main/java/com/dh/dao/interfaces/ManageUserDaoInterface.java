package com.dh.dao.interfaces;

import java.util.List;

import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.ProfileImage;
import com.dh.dao.entities.User;
import com.dh.dao.entities.Verification;


public interface ManageUserDaoInterface {
	
	public long createUser(User user,Login login);
	
	public User updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public User retrieveUser(long userId);
	
	public boolean verifyLogin(String email,String password);
	
	public Verification addVerification(Verification verification);
	
	public boolean removeVerification(Verification verification);
	
	public Verification updateVerification(Verification verification);
	
	public List<Verification> getAllVerification(long userId);
	
	public Verification getVerification(long verificationId);
	
	public Address addAddress(Address address);
	
	public Address removeAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public Address getAddress(long userId);
	
	public ProfileImage addProfileImage(ProfileImage profileImage);
	
	public ProfileImage removeProfileImage(ProfileImage profileImage);
	
	public ProfileImage updateProfileImage(ProfileImage profileImage);
	
	public ProfileImage getProfileImage(long imageId);

	public boolean retrieveLogin(String username);

	


	
}
