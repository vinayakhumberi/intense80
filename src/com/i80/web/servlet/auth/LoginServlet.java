package com.i80.web.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.i80.common.AppConstants;
import com.i80.common.enums.RetcodeEnum;
import com.i80.pojo.Course;
import com.i80.pojo.User;
import com.i80.web.AppResponse_O;
import com.i80.web.AppResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userHandle = request.getParameter(AppConstants.USER_HANDLE); 
		JSONObject json = new JSONObject();
		RetcodeEnum retCode = RetcodeEnum.failed;
		
		PreparedStatement stmt = null;
		Connection conn = null;
		User user = new User();
	      try{
	          // Register JDBC driver
	          Class.forName("com.mysql.jdbc.Driver");
	          // Open a connection
	          conn = DriverManager.getConnection(AppConstants.DB_URL, AppConstants.USER, AppConstants.PASS);
	          String sql;
	          sql = "select * from users u join courses c on u.courseId = c.courseId where u.userHandle = ?;";	          
	          stmt = conn.prepareStatement(sql);
	          stmt.setString(1, userHandle);	          
	          ResultSet rs = stmt.executeQuery();
	          while(rs.next()){
	        	  retCode = RetcodeEnum.success;
	        	  //Populate the User Object
	        	  user.setUserId(rs.getInt("userId"));
	        	  user.setUserHandle(rs.getString("userHandle"));
	        	  user.setFullName(rs.getString("fullName"));
	        	  user.setEmail(rs.getString("email"));
	        	  user.setMobile(rs.getString("mobile"));
	        	  //user.setCourseName(rs.getString("courseName"));
	        	  Course course = new Course();
	        	  course.setCourseId(Integer.parseInt(rs.getString("courseId")));
	        	  course.setCourseName(rs.getString("courseName"));
	        	  user.setCourse(course);
	          }
	       }catch(SQLException se){
	          //Handle errors for JDBC
	    	   retCode = RetcodeEnum.failed;
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	    	  retCode = RetcodeEnum.failed;
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
	      //if things are successful, add the user object to the session.
	      if(retCode.equals(RetcodeEnum.success)){
	    	  HttpSession session = request.getSession();
		      session.setAttribute("user", user);  
	      }
	      AppResponse<User> appResponse = new AppResponse<User>();
	      ObjectMapper mapper = new ObjectMapper();
	      appResponse.setData(user);
	      appResponse.setCode(retCode);
	      PrintWriter writer = response.getWriter();
	      response.setContentType("application/json");
	      mapper.writeValue(writer, appResponse);
		  writer.close();
	}

}
