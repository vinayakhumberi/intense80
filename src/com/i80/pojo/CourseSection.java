package com.i80.pojo;

import java.util.ArrayList;

public class CourseSection {
	private int courseSectionId; 
	private String sectionName;
	private ArrayList<LessonPage> lessonPages = new ArrayList<LessonPage>();
	private ArrayList<QuizCollection> quizCollection = new ArrayList<QuizCollection>();
	
	public int getCourseSectionId() {
		return courseSectionId;
	}
	public void setCourseSectionId(int courseSectionId) {
		this.courseSectionId = courseSectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public ArrayList<LessonPage> getLessonPages() {
		return lessonPages;
	}
	public void setLessonPages(ArrayList<LessonPage> lessonPages) {
		this.lessonPages = lessonPages;
	}
	public ArrayList<QuizCollection> getQuizCollection() {
		return quizCollection;
	}
	public void setQuizCollection(ArrayList<QuizCollection> quizCollection) {
		this.quizCollection = quizCollection;
	}
}
