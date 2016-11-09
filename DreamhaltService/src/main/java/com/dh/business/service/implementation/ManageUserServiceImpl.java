package com.dh.business.service.implementation;

import java.util.List;

import com.dh.business.service.interfaces.ManageUserServiceInterface;
import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.ProfileImage;
import com.dh.dao.entities.User;
import com.dh.dao.entities.Verification;
import com.dh.dao.implementations.ManageUserDaoImpl;
import com.dh.dao.interfaces.ManageUserDaoInterface;

public class ManageUserServiceImpl implements ManageUserServiceInterface{
	
	ManageUserDaoInterface userDao = new ManageUserDaoImpl();

	@Override
	public boolean registerUser(User user,Login login) throws Exception {

		if(user!=null)
		{
			if(validateUser(user)){
			long userId = userDao.createUser(user, login);
				if(userId!=0)
				{
					System.out.println("User is successfully registered");
					return true;
				}
			}
			else{
				throw new Exception("email already exists");
			}
		}
		{
			throw new Exception("user is empty");
		}
	
	}

	
	@Override
	public boolean validateUser(User user) {
		if(user!=null)
		{
			if(checkIfUsernameExist(user.getEmail()))
			{
				System.out.println("User is already registered with this emailId "+ user.getEmail());
				return false;
			}
			else
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Address validateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verification validateVerificationId(Verification verification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileImage validateProfileImage(ProfileImage profileImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserGeneralDetails(User user) {
		 return userDao.updateUser(user);
		
	}

	@Override
	public Address updateUserAddress(Address address) {
		return userDao.updateAddress(address);
	}

	@Override
	public Verification updateUserVerification(Verification verification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileImage updateUserProfileImage(ProfileImage profileImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getAllUserDetails(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verification> getAllUserVerification(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getGeneralUserDetails(long userId) {
		return userDao.retrieveUser(userId);
	}

	@Override
	public Address getUserAddress(long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileImage getUserProfileImage(long imageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verification getUserVerification(long verificationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkIfUsernameExist(String username) {
		if(userDao.retrieveLogin(username))
		{
			return true;
		}
		else
			return false;
		
	}


	@Override
	public Address createUserAddress(long userId, Address address) {
		// TODO Auto-generated method stub
		User user = userDao.retrieveUser(userId);
		address=userDao.addAddress(address);
		user.setAddress(address);
		user = userDao.updateUser(user);
		return address;
	}


	@Override
	public Verification createUserVerification(long userId,
			Verification verification) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ProfileImage createUserProfileImage(long userId,
			ProfileImage profileImage) {
		// TODO Auto-generated method stub
		return null;
	}

}
