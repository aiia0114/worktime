package com.example.attendance.dto;

public class User {
	private String username;
	private String password;
	private String role;
	private String email;
	private boolean enabled;  // new field
	
	public User(String username,  String email, String password, String role) {
		this(username, password, role, email, true); // Default to enabled デフォルトでtureにする(boolean)
	}
	
	public User(String username, String email, String password, String role,  boolean enabled) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.enabled = enabled;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}