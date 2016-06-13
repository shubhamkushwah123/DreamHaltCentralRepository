package com.test;

import com.service.test.DhServiceTest;

public class RestTest1 {
	
	public void callService()
	{
		System.out.println("I am calling Service");
		
		DhServiceTest dh1 = new DhServiceTest();
		dh1.serviceEcho();
	}

}
