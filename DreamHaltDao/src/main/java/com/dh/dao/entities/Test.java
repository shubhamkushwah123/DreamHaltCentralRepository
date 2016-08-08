package com.dh.dao.entities;

import javax.xml.bind.annotation.XmlRootElement;


public class Test {
	
	int id;
	
	String name;
	
	Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Test(int id, String name, Login login)
	{
		this.id=id;
		this.name=name;
		this.login=login;
	}
	
	public Test()
	{
		
	}

}
