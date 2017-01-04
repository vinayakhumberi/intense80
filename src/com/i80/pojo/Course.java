package com.i80.pojo;

import java.util.ArrayList;

public class Course {
	private int courseId;
	private String extCourseId;
	private String courseName;
	private ArrayList<CourseSection> courseSections = new ArrayList<CourseSection>();
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public ArrayList<CourseSection> getCourseSections() {
		return courseSections;
	}
	public void setCourseSections(ArrayList<CourseSection> courseSections) {
		this.courseSections = courseSections;
	}	
	public String getExtCourseId() {
		return extCourseId;
	}
	public void setExtCourseId(String extCourseId) {
		this.extCourseId = extCourseId;
	}	
}
