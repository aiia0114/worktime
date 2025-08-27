package com.example.attendance.controller;

import com.example.attendance.dao.AttendanceDAO;
import com.example.attendance.dao.UserDAO;
import com.example.attendance.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {
	private final UserDAO userDAO = new UserDAO();
	private final AttendanceDAO attendanceDAO = new AttendanceDAO();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userDAO.findByUsername(username);
		if (user != null && user.isEnabled() && userDAO.verifyPassword(username, password))
	}
}