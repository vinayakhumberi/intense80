package com.i80.leads;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.i80.common.AppConstants;

/**
 * Servlet implementation class CaptureLeads
 */
@WebServlet("/CaptureLeads")
public class CaptureLeads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost/i80";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "123456";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaptureLeads() {
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
		  PreparedStatement stmt = null;
		  Connection conn = null;
		  JSONObject json = new JSONObject();
		  String retCode = AppConstants.RETCODE_FAILED;
		  String retMessage = "";
		  
		  //Get the params
		  String courseName = request.getParameter("CourseName");
		  String leadName = request.getParameter("LeadName");
		  String leadEmail = request.getParameter("LeadEmail");
		  String leadMobile = request.getParameter("LeadMobile");
		  
	      try{
	          // Register JDBC driver
	          Class.forName("com.mysql.jdbc.Driver");
	          // Open a connection
	          conn = DriverManager.getConnection(DB_URL, USER, PASS);
	          String sql;
	          sql = "insert into Lead (courseName,leadName,leadEmail,leadMobile) values(?,?,?,?);";	          
	          stmt = conn.prepareStatement(sql);
	          stmt.setString(1, courseName);
	          stmt.setString(2, leadName);
	          stmt.setString(3, leadEmail);
	          stmt.setString(4, leadMobile);
	          int numRecordsUpdated = stmt.executeUpdate();
	          if(numRecordsUpdated == 1){
	        	  retCode = AppConstants.RETCODE_SUCCESS;
	          }
	       }catch(SQLException se){
	          //Handle errors for JDBC
	    	   retCode = AppConstants.RETCODE_FAILED;
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	    	  retCode = AppConstants.RETCODE_FAILED;
	          e.printStackTrace();
	       }finally{
	          //finally block used to close resources
	          try{
	             if(stmt!=null)
	                stmt.close();
	          }catch(SQLException se2){
	          }// nothing we can do
	          try{
	             if(conn!=null)
	             conn.close();
	          }catch(SQLException se){
	             se.printStackTrace();
	          }//end finally try
	       } //end try
		
        PrintWriter writer = response.getWriter();
        
        try {
        	json.put("retCode",retCode);
        	json.put("message", retMessage);
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			 writer.write(json.toString());
	         writer.close();
		}
        
	}

}
