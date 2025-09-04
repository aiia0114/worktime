package com.example.attendance.dto;

import java.time.LocalDateTime;

public class Log {
	private String actionUser;
	private String targetUser;
	private String actionType;
	private LocalDateTime OldCheckInTime;
	private LocalDateTime OldCheckOutTime;
	private LocalDateTime NewCheckInTime;
	private LocalDateTime NewCheckOutTime;
	private LocalDateTime TimeStamp;
	
	public Log(String actionUser, String targetUser, String actionType,
			LocalDateTime OldCheckInTime, LocalDateTime OldCheckOutTime, LocalDateTime NewCheckInTime, LocalDateTime NewCheckOutTime, LocalDateTime TimeStamp) {
		this.actionType = actionType;
		this.actionUser = actionUser;
		this.targetUser = targetUser;
		this.OldCheckInTime = OldCheckInTime;
		this.OldCheckOutTime = OldCheckOutTime;
		this.NewCheckInTime = NewCheckInTime;
		this.NewCheckOutTime = NewCheckOutTime;
		this.TimeStamp = TimeStamp;
	}
	
	public String getActionUser() {
		return actionUser;
	}
	
	public String getActionType() {
		return actionType;
	}
	
	public String getTargetUser() {
		return targetUser;
	}
	
	public LocalDateTime getOldCheckInTime() {
		return OldCheckInTime;
	}
	
	public LocalDateTime getOldCehckOutTime() {
		return OldCheckOutTime;
	}
	
	public LocalDateTime getNewCheckInTime() {
		return NewCheckInTime;
	}

	public LocalDateTime getNewCheckOutTime() {
		return NewCheckOutTime;
	}
	
	public LocalDateTime getTimeStamp() {
		return TimeStamp;
	}
}