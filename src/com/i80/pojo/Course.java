package com.i80.pojo;

import java.util.List;

public class Course {
	private List<String> tags;
    private String coursefee;
    private boolean placementSupportAvailable;
    private List<String> placementFeatures;
    private List<String> studentProfiles;
    private String longDescription;
    private String earlyRegistrationFee;
    private boolean preRegistrationAllowed;
    private String shortDescription;
    private List<String> whatItIncludesCoreList;
    private List<String> whatItIncludesOptionalList;
    private List<String> whatItIncludesOthersList;
    private boolean clickthroughToDetails;
    private Trainer trainer;
    private String classroomLocation;
    private String duration;
    private List<String> detailedTopics;
    private String startDate;
    private String courseOutline;
    private String courseName;
    private List<FAQ> faqs;
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getCoursefee() {
		return coursefee;
	}
	public void setCoursefee(String coursefee) {
		this.coursefee = coursefee;
	}
	public boolean isPlacementSupportAvailable() {
		return placementSupportAvailable;
	}
	public void setPlacementSupportAvailable(boolean placementSupportAvailable) {
		this.placementSupportAvailable = placementSupportAvailable;
	}
	public List<String> getPlacementFeatures() {
		return placementFeatures;
	}
	public void setPlacementFeatures(List<String> placementFeatures) {
		this.placementFeatures = placementFeatures;
	}
	public List<String> getStudentProfiles() {
		return studentProfiles;
	}
	public void setStudentProfiles(List<String> studentProfiles) {
		this.studentProfiles = studentProfiles;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getEarlyRegistrationFee() {
		return earlyRegistrationFee;
	}
	public void setEarlyRegistrationFee(String earlyRegistrationFee) {
		this.earlyRegistrationFee = earlyRegistrationFee;
	}
	public boolean isPreRegistrationAllowed() {
		return preRegistrationAllowed;
	}
	public void setPreRegistrationAllowed(boolean preRegistrationAllowed) {
		this.preRegistrationAllowed = preRegistrationAllowed;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public List<String> getWhatItIncludesCoreList() {
		return whatItIncludesCoreList;
	}
	public void setWhatItIncludesCoreList(List<String> whatItIncludesCoreList) {
		this.whatItIncludesCoreList = whatItIncludesCoreList;
	}
	public List<String> getWhatItIncludesOptionalList() {
		return whatItIncludesOptionalList;
	}
	public void setWhatItIncludesOptionalList(
			List<String> whatItIncludesOptionalList) {
		this.whatItIncludesOptionalList = whatItIncludesOptionalList;
	}
	public List<String> getWhatItIncludesOthersList() {
		return whatItIncludesOthersList;
	}
	public void setWhatItIncludesOthersList(List<String> whatItIncludesOthersList) {
		this.whatItIncludesOthersList = whatItIncludesOthersList;
	}
	public boolean isClickthroughToDetails() {
		return clickthroughToDetails;
	}
	public void setClickthroughToDetails(boolean clickthroughToDetails) {
		this.clickthroughToDetails = clickthroughToDetails;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public String getClassroomLocation() {
		return classroomLocation;
	}
	public void setClassroomLocation(String classroomLocation) {
		this.classroomLocation = classroomLocation;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<String> getDetailedTopics() {
		return detailedTopics;
	}
	public void setDetailedTopics(List<String> detailedTopics) {
		this.detailedTopics = detailedTopics;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getCourseOutline() {
		return courseOutline;
	}
	public void setCourseOutline(String courseOutline) {
		this.courseOutline = courseOutline;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<FAQ> getFaqs() {
		return faqs;
	}
	public void setFaqs(List<FAQ> faqs) {
		this.faqs = faqs;
	}
	
	@Override
	public String toString() {
		String displayString = "course-name:" + courseName + "\n"+
								"short-description:" + shortDescription + "\n"+
								"duration:" + duration + "\n"+
								"start-date:" + startDate + "\n"+
								"coursefee:" + coursefee + "\n"+
								"classroom-location:" + classroomLocation + "\n"+
								"placement-support-available:" + placementSupportAvailable + "\n"+
								"clickthrough-to-details:" + clickthroughToDetails + "\n"+
								"long-description:" + longDescription + "\n"+
								"pre-registration-allowed:" + preRegistrationAllowed + "\n"+
								"early-registration-fee:" + earlyRegistrationFee + "\n"+
								"tags:" + tags + "\n"+
								"what-it-includes-core:" + whatItIncludesCoreList + "\n"+
								"what-it-includes-optional:" + whatItIncludesOptionalList + "\n"+
								"what-it-includes-others:" + whatItIncludesOthersList + "\n"+
								"detailed-topics:" + detailedTopics + "\n"+
								"other-imp-details -> student-profiles:" + studentProfiles + "\n"+
								"placement-features:" + placementFeatures + "\n"+
								"trainer:" + trainer + "\n"+
								"Faqs:" + faqs + "\n";
								
		return displayString;
	}
}
