package com.i80.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.i80.pojo.DetailedCourse;
import com.i80.pojo.FAQ;
import com.i80.pojo.Trainer;

public class CourseUtil {
	private static final int PRETTY_PRINT_INDENT_FACTOR = 4;
	
	//Gets a courses json and returns a course list
	public static List<DetailedCourse> allCoursesJsonToCourseList(JSONObject jsonCoursesObj) throws JSONException{
		List<DetailedCourse> courses = new ArrayList<DetailedCourse>();
        JSONObject coursesJson = (JSONObject) jsonCoursesObj.get("courses");
        JSONArray courseArray = coursesJson.getJSONArray("course");
        //System.out.println(courseArray.toString(PRETTY_PRINT_INDENT_FACTOR));
        for(int i = 0 ; i < courseArray.length() ; i++){
        	//unpack courses and start processing
        	JSONObject jsonCourseObj = courseArray.getJSONObject(i);//.getString(AppConstants.COURSE_COURSE_NAME));
        	DetailedCourse aCourse = new DetailedCourse();
        	aCourse.setCourseName(jsonCourseObj.getString(AppConstants.COURSE_COURSE_NAME));
        	aCourse.setShortDescription(jsonCourseObj.getString(AppConstants.COURSE_SHORT_DESCRIPTION));
        	//System.out.println(aCourse.getCourseName() + " " + aCourse.getShortDescription());
        	aCourse.setDuration(jsonCourseObj.getString(AppConstants.COURSE_DURATION));
        	aCourse.setStartDate(jsonCourseObj.getString(AppConstants.COURSE_START_DATE));
        	aCourse.setCoursefee(jsonCourseObj.getString(AppConstants.COURSE_COURSE_FEE));
        	aCourse.setClassroomLocation(jsonCourseObj.getString(AppConstants.COURSE_CLASSROOM_LOCATION));
        	boolean isPlacementSupportAvailable = true;
        	if("Y".equalsIgnoreCase(jsonCourseObj.getString(AppConstants.COURSE_PLACEMENT_SUPPORT_AVAILABLE))){
        		isPlacementSupportAvailable = true;
        	}else{
        		isPlacementSupportAvailable = false;
        	}
        	aCourse.setPlacementSupportAvailable(isPlacementSupportAvailable);
        	boolean clickThroughToDetails = false;
        	if("Y".equalsIgnoreCase(jsonCourseObj.getString(AppConstants.COURSE_CLICKTHROUGH_TO_DETAILS))){
        		clickThroughToDetails = true;
        	}else{
        		clickThroughToDetails = false;
        	}
        	aCourse.setClickthroughToDetails(clickThroughToDetails);
        	aCourse.setLongDescription(jsonCourseObj.getString(AppConstants.COURSE_LONG_DESCRIPTION));
        	boolean preRegistrationAllowed = false;
        	if("Y".equalsIgnoreCase(jsonCourseObj.getString(AppConstants.COURSE_PRE_REGISTRATION_ALLOWED))){
        		preRegistrationAllowed = true;
        	}else{
        		preRegistrationAllowed = false;
        	}
        	aCourse.setPreRegistrationAllowed(preRegistrationAllowed);
        	aCourse.setEarlyRegistrationFee(jsonCourseObj.getString(AppConstants.COURSE_EARLY_REGISTRATION_FEE));
            JSONObject tagsJson = (JSONObject) jsonCourseObj.get(AppConstants.COURSE_TAGS);
        	JSONArray tagArray = tagsJson.getJSONArray(AppConstants.COURSE_TAG);
        	List<String> tagsList = new ArrayList<String>();
        	for(int i1 = 0 ; i1 < tagArray.length() ; i1++){
            	tagsList.add(tagArray.get(i1).toString());
        	}
        	aCourse.setTags(tagsList);
        	//Needs to change it to array validation. 
        	JSONObject whatItIncludesJson = (JSONObject) jsonCourseObj.get(AppConstants.COURSE_WHAT_IT_INCLUDES);
        	List<String> whatItIncludesCoreList = new ArrayList<String>();
        	whatItIncludesCoreList.add(whatItIncludesJson.getString(AppConstants.COURSE_CORE));
        	aCourse.setWhatItIncludesCoreList(whatItIncludesCoreList);
        	List<String> whatItIncludesOptionalList = new ArrayList<String>();
        	whatItIncludesOptionalList.add(whatItIncludesJson.getString(AppConstants.COURSE_OPTIONAL));
        	aCourse.setWhatItIncludesOptionalList(whatItIncludesOptionalList);
        	JSONArray whatItIncludesOthersJsonArray = whatItIncludesJson.getJSONArray(AppConstants.COURSE_OTHERS);
        	List<String> whatItIncludesOthersList = new ArrayList<String>();
        	for(int i1 = 0 ; i1 < whatItIncludesOthersJsonArray.length() ; i1++){
        		whatItIncludesOthersList.add(whatItIncludesOthersJsonArray.get(i1).toString());
        	}
        	aCourse.setWhatItIncludesOthersList(whatItIncludesOthersList);
        	//detailed-topics 
        	JSONObject detailedTopicsJson = (JSONObject) jsonCourseObj.get(AppConstants.COURSE_DETAILED_TOPICS);
        	JSONArray detailedTopicJsonArray = detailedTopicsJson.getJSONArray(AppConstants.COURSE_TOPIC);
        	List<String> detailedTopicList = new ArrayList<String>();
        	for(int j = 0 ; j < detailedTopicJsonArray.length() ; j++){
        		detailedTopicList.add(detailedTopicJsonArray.get(j).toString());
        	}
        	aCourse.setDetailedTopics(detailedTopicList);
        	//other-imp-details student-profiles profile
        	JSONObject otherImpDetailsJson = (JSONObject) jsonCourseObj.get(AppConstants.COURSE_OTHER_IMP_DETAILS);
        	JSONObject studentProfilesJson = (JSONObject) otherImpDetailsJson.get(AppConstants.COURSE_STUDENT_PROFILES);
        	JSONArray studentProfileJsonArray = studentProfilesJson.getJSONArray(AppConstants.COURSE_PROFILE);
        	List<String> studentProfileList = new ArrayList<String>();
        	for(int j = 0 ; j < studentProfileJsonArray.length() ; j++){
        		studentProfileList.add(studentProfileJsonArray.get(j).toString());
        	}
        	aCourse.setStudentProfiles(studentProfileList);
        	//placement-features
        	JSONObject placementFeaturesJson = (JSONObject) otherImpDetailsJson.get(AppConstants.COURSE_PLACEMENT_FEATURES);
        	JSONArray placementFeaturesJsonArray = placementFeaturesJson.getJSONArray(AppConstants.COURSE_FEATURE);
        	List<String> placementFeaturesList = new ArrayList<String>();
        	for(int j = 0 ; j < placementFeaturesJsonArray.length() ; j++){
        		placementFeaturesList.add(placementFeaturesJsonArray.get(j).toString());
        	}
        	aCourse.setPlacementFeatures(placementFeaturesList);
        	//trainer
        	Trainer trainer = new Trainer();
        	JSONObject trainerDetailsJson = (JSONObject) jsonCourseObj.get(AppConstants.COURSE_TRAINER);
        	trainer.setName(trainerDetailsJson.getString(AppConstants.COURSE_NAME));
        	trainer.setDescription(trainerDetailsJson.getString(AppConstants.COURSE_DESCRIPTION));
        	aCourse.setTrainer(trainer);
        	//Faqs
        	JSONObject faqsJson = (JSONObject) jsonCourseObj.get(AppConstants.COURSE_FAQS);
        	JSONArray faqJsonArray = faqsJson.getJSONArray(AppConstants.COURSE_FAQ);
        	List<FAQ> faqList = new ArrayList<FAQ>();
        	for(int j = 0 ; j < faqJsonArray.length() ; j++){
        		FAQ faq = new FAQ();
        		faq.setQuestion(((JSONObject)faqJsonArray.get(j)).getString(AppConstants.COURSE_QUESTION));
        		faq.setAnswer(((JSONObject)faqJsonArray.get(j)).getString(AppConstants.COURSE_ANSWER));
        		faqList.add(faq);
        	}
        	aCourse.setFaqs(faqList);
        	courses.add(aCourse);
        }        
		return courses;
	}
	
	//Test function
	public static void main(String args[]) throws Exception{
		JSONObject jsonCoursesObj = null;
		
		BufferedReader br = null;
    	StringBuffer strBuf = new StringBuffer();
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("WebContent/courses/all-courses.xml"));
			while ((sCurrentLine = br.readLine()) != null) {
				strBuf.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

        JSONObject xmlJSONObj = null;
		try {
			xmlJSONObj = XML.toJSONObject(strBuf.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
        jsonCoursesObj = xmlJSONObj;
        String jsonPrettyPrintString = null;
		jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        //System.out.println(jsonPrettyPrintString);
        
		allCoursesJsonToCourseList(jsonCoursesObj);
        
	}
}
