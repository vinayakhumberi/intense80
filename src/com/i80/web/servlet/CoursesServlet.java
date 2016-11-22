package com.i80.web.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.i80.common.AppConstants;

/**
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the CoursesJson stored in the servlet context
		JSONObject jsonCoursesObj = (JSONObject)request.getServletContext().getAttribute("CoursesJson");
		JSONObject json = new JSONObject();
		String retCode = AppConstants.RETCODE_FAILED;
		String retMessage = "";
		PrintWriter writer = response.getWriter();

        try {
            if(jsonCoursesObj == null){
            	json.put("retCode",retCode);
            	json.put("message", retMessage);
            	retCode = AppConstants.RETCODE_FAILED;
            }else{
            	json = jsonCoursesObj;
            }
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			 writer.write(json.toString());
	         writer.close();
		}
	}

}
