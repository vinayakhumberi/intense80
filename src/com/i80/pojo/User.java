package com.i80.pojo;

public class User {
	private int userId;
	private String userHandle;
	private Course course;
	private String fullName;
	private String email;
	private String mobile;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserHandle() {
		return userHandle;
	}
	public void setUserHandle(String userHandle) {
		this.userHandle = userHandle;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
