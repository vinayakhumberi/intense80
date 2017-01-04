package com.i80.web.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import com.i80.pojo.CourseSection;
import com.i80.pojo.Dashboard;
import com.i80.pojo.User;
import com.i80.web.AppResponse;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DashboardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RetcodeEnum retCode = RetcodeEnum.failed;
		Dashboard dashboard = new Dashboard();

		PreparedStatement stmt = null;
		Connection conn = null;
		HttpSession session = request.getSession();
		Object userObj = session.getAttribute("user");
		User user = null;
		Course course = null;
		if (userObj != null) {
			user = (User) userObj;
			course = user.getCourse();
			boolean recordsFound = false;
			try {
				// Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				// Open a connection
				conn = DriverManager.getConnection(AppConstants.DB_URL,AppConstants.USER, AppConstants.PASS);
				String sql;
				sql = "select * from (select c.courseId,c.courseName from users u join courses c on u.courseId = c.courseId where u.userHandle = ?) uc join coursesections cs on uc.courseId = cs.courseId;";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, user.getUserHandle());
				ResultSet rs = stmt.executeQuery();
				ArrayList<CourseSection> courseSections = new ArrayList<CourseSection>();
				while (rs.next()) {
					recordsFound = true;
					//Populate the User Object which is in the session
					//TODO: Change code to include multiple courses
					CourseSection courseSection = new CourseSection();
					courseSection.setCourseSectionId(Integer.parseInt(rs.getString("courseSectionId")));
					courseSection.setSectionName(rs.getString("sectionName"));
					courseSections.add(courseSection);
				}
				course.setCourseSections(courseSections);
				if (recordsFound == false) {
					retCode = RetcodeEnum.noCourseFoundForUser;
				}else{
					retCode = RetcodeEnum.success;
				}
				dashboard.setUser(user);
			} catch (SQLException se) {
				// Handle errors for JDBC
				retCode = RetcodeEnum.failed;
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				retCode = RetcodeEnum.failed;
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				}// nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}// end finally try
			} // end try
		} else {
			retCode = RetcodeEnum.login;
		}
		AppResponse<Dashboard> appResponse = new AppResponse<Dashboard>();
		ObjectMapper mapper = new ObjectMapper();
		appResponse.setData(dashboard);
		appResponse.setCode(retCode);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		mapper.writeValue(writer, appResponse);
		writer.close();
	}

}
