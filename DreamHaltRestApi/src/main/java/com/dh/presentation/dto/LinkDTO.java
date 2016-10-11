package com.dh.presentation.dto;

public class LinkDTO {
	
	private String dashboard = "/dashboard";
	
	private String profile = "/profile";
			
	private String verification = "/verification";

	public String getDashboard() {
		return dashboard;
	}

	public void setDashboard(String dashboard) {
		this.dashboard = dashboard;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}
	
	

}
