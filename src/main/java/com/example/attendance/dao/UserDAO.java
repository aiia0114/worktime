package com.example.attendance.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.attendance.dto.User;

public class UserDAO{
	private static final Map<String, User> users = new HashMap<>();
	
	static {
		// sample users with hashed passwords
		users.put("employeel", new User("employeel", "employee1@example.com", hashPassword("password"), "employee", true));
		users.put("admin1", new User("admin1",  "admin@example.com", hashPassword("adminpass"), "admin", true));
		users.put("employeel2", new User("employeel2",  "employee2@example.com", hashPassword("password"), "employee", true));
	}
	
	public User findByUsername(String username) {
		return users.get(username);
	}
	
	public boolean verifyPassword(String username, String password) {
		User user = findByUsername(username);
		return user != null && user.isEnabled() && user.getPassword().equals(hashPassword(password));
	}
	
	public Collection<User> getAllUsers() {
		return users.values();
	}
	
	public void addUser(User user) {
		users.put(user.getUsername(), user);
	}
	
	public void updateUser(User user) {
		users.put(user.getUsername(), user);
	}
	
	public void updateEmail(User email) {
		users.put(email.getEmail(), email);
	}
	
	public void deleteUser(String username) {
		users.remove(username);
	}
	
	public void resetPassword(String username, String newPassword) {
		User user = users.get(username);
		if (user != null) {
			users.put(username, new User(user.getUsername(), hashPassword(newPassword), user.getRole(), user.getEmail(), user.isEnabled()));
		}
	}
	
	public void toggleUserEnabled(String username, boolean enabled) {
		User user = users.get(username);
		if(user != null) {
			users.put(username, new User(user.getUsername(), user.getPassword(), user.getRole(), user.getEmail(),enabled));
		}
	}
	
	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(password.getBytes());
			StringBuilder sd = new StringBuilder();
			for (byte b : hashedBytes) {
				sd.append(String.format("%02x", b)); // バイトを16進数に変換
			}
			return sd.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}