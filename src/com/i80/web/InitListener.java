package com.i80.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.i80.common.CourseUtil;
import com.i80.pojo.Course;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
@WebListener
public class InitListener implements ServletContextListener {
	private JSONObject jsonCourseObj = null;

    /**
     * Default constructor. 
     */
    public InitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	BufferedReader br = null;
    	StringBuffer strBuf = new StringBuffer();
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(arg0.getServletContext().getRealPath("courses/all-courses.xml")));
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
        jsonCourseObj = xmlJSONObj;
        
        //Add jsonCourseObj to the servlet context
        arg0.getServletContext().setAttribute("CoursesJson", jsonCourseObj);
        
        //Create course array for consumption by backend
        List<Course> courseList = null;
        try {
			courseList = CourseUtil.allCoursesJsonToCourseList(jsonCourseObj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        arg0.getServletContext().setAttribute("AllCoursesList", courseList);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
