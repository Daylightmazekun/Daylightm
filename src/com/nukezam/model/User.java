package com.nukezam.model;

public class User {
	
	private String email;
	private String password;
	private int role;
	private String name;
	
	public User(){}
	
	public User(String email, String password){
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
