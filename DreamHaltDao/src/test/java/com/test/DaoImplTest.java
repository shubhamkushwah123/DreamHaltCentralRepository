package com.test;

import java.util.Date;

import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.ProfileImage;
import com.dh.dao.entities.User;
import com.dh.dao.implementations.ManageUserDaoImpl;
import com.dh.dao.interfaces.ManageUserDaoInterface;

public class DaoImplTest {

	public static void main(String args[])
	{
		//createUser();
		//updateUser();
		addAddress();
		addProfileImage();
	}

	private static void addProfileImage() {
		ManageUserDaoInterface userDao = new ManageUserDaoImpl();
		User user = userDao.retrieveUser(1);
		ProfileImage profileImage= getProfileImage();
		userDao.addProfileImage(profileImage);
		user.setImage(profileImage);
		System.out.println("Address Inserted & Id is "+ user.getImage());
		user = userDao.updateUser(user);
		System.out.println("User updated & Id is " + user.getId());
	}

	private static ProfileImage getProfileImage() {
		ProfileImage profileImage = new ProfileImage();
		profileImage.setImageType('u');
		profileImage.setName("profile");
		profileImage.setStatus('A');
		profileImage.setUpdatedAt(new Date());
		profileImage.setCreatedAt(new Date());
		return profileImage;
	}

	private static void addAddress() {
		long userId=1;
		User user = getUser();
		Address address = getAddress();
		ManageUserDaoInterface userDao = new ManageUserDaoImpl();
		user = userDao.retrieveUser(1);
		address = userDao.addAddress(address);
		user.setAddress(address);
		System.out.println("Address Inserted & Id is "+ address.getAddressId());
		user = userDao.updateUser(user);
		System.out.println("User updated & Id is " + user.getId());
	}
	/*	if(userDao.addAddress(address)){
		//	System.out.println("Address has ben updated to user with id" + user.getid());
		}
		else{
			System.out.println("Exception occured");
		}
	}*/

	private static Address getAddress() {
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

	private static User getUser() {
		User user = new User();
		user.setFirstName("shubham");
		user.setLastName("kushwah");
		user.setDescription("I am a tom boy");
		user.setDob(new Date());
		user.setGender("Male");
		user.setEmail("shubham@gmail.com");
		user.setMobileNo("9004050499");
		user.setLandLineNo("7342533050");
		user.setSchool("Study Home School");
		user.setCollege("GECU");
		user.setOrganisation("TCS");
		user.setCreatedAt(new Date());
		user.setLastUpdatedAt(new Date());
		user.setStatus('A');
		return user;
	}

	private static void updateUser() {
		ManageUserDaoInterface userDao = new ManageUserDaoImpl();
		long userId = 1;
		User user = userDao.retrieveUser(userId);
		user.setFirstName("Jyoti");
		user = userDao.updateUser(user);
		System.out.println(user.getFirstName() + " is updated.");
		
	}

	private static void createUser() {
		ManageUserDaoInterface userDao = new ManageUserDaoImpl();
		Login login = new Login();
		User user = new User();
		user.setFirstName("shubham");
		user.setLastName("kushwah");
		user.setDescription("I am a tom boy");
		user.setDob(new Date());
		user.setGender("Male");
		user.setEmail("shubham@gmail.com");
		user.setMobileNo("9004050499");
		user.setLandLineNo("7342533050");
		user.setSchool("Study Home School");
		user.setCollege("GECU");
		user.setOrganisation("TCS");
		user.setCreatedAt(new Date());
		user.setLastUpdatedAt(new Date());
		user.setStatus('A');
		user.setPassword("shubham123");
		login.setUsername(user.getEmail());
		login.setPassword(user.getPassword());
		long result = userDao.createUser(user,login);
		System.out.println(result);
		if(result!=0){
			System.out.println(user.getFirstName() + " is successfully registered");
		}
		else{
			System.out.println("Exception occured");
		}
		
		
	}
}
