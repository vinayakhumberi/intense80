<!DOCTYPE html>
<%@page import="com.i80.pojo.Course"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Intense 80 Coding School</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="assets/libraries/css/bootstrap.min.css">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,400i,500,700'
	rel='stylesheet' type='text/css'>
<script src="https://use.fontawesome.com/a177f95dd8.js"></script>

<!-- Custom CSS -->

<!--Start Google analytics-->
<!--End Google analytics-->
<!--Start Mixpanel Initialize-->
<!-- end Mixpanel -->
</head>

<%
//Get courses data
List<Course> coursesList = (List<Course>) (request.getServletContext().getAttribute("AllCoursesList"));

%>
<body>
<link rel="stylesheet" href="assets/css/common-mobile.css">
<div class="main-header container-fluid">
      <nav class="navbar navbar-inverse">
        <div class="container-fluid pad-0">
          <div class="navbar-header">
            <a class="navbar-brand" href="" style="padding: 3%;"><img src="assets/img/logo-small.png" alt=""></a>
            <a class="call-number" href="tel: 9886707787"><i class="glyphicon glyphicon-earphone"></i></a>
          </div>
        </div>
      </nav>
  </div>
  
  
 <!-- home body starts -->
 
<body>  
<!-- Navigation  start -->
  <section>
<link rel="stylesheet" href="assets/css/home-mobile.css">
  <div class="hp-jumbotron">
      <div class="container pad-0">
          <div class="jumbotron">
            <h1 style="padding-bottom: 0px;margin-bottom: 0px;">From beginner to fluent programmer in 80 days.</h1> 
            <h4 style="font-size:18px;font-weight: 300;color: #fff;margin-top: 5px;">With placement support for freshers</h4>
            <p class="jumbo-desc" style="margin-top: 50px;">      
              <span>Our innovative programming courses</span>     
              <ul>
                <li>Are Intense &amp; Rigorous</li>
                <li>Are practical &amp; hands-on. Not just lecture-based.</li>
                <li>Use all professional tools &amp; methods</li>
                <li>Use our modern technology &amp; collaboration platform</li>
                <li>Involve continuous learning even after course completion.</li>
              </ul>
              <span style="font-size: 16px;font-weight: 500;margin-left:8%;">We call it IMMERSIVE LEARNING</span> 
            </p> 
            <a href="<?= base_url() ?>course">Browse All Courses</a>
          </div>
      </div>    
  </div>
  <div class="main-section-footer">
		<div class="container">
			<div class="row">
				<span class="m-label">Classroom Location:</span> <span class="m-value">Marathahalli,
					Bangalore</span>
			</div>

		</div>
   </div>
  </section>
  <section>
    <div class="container hp-info-1">
      <div class="title">
        Intense80 is a revolutionary new way of learning programming.
      </div>
      <div class="content">
        At Intense80 our mission is simple - to get commited &amp; motivated people and transform them into professional developers in their chosen stream, by putting them through an intense and well-designed training program
      </div>
    </div>
  </section>
  <section>
    <div class="container  hp-info-2">
      <div class="title" style="font-size: 22px;font-weight: bold;">
        Upcoming Courses
      </div>
      <div class="content">
      	<%for(Course course : coursesList){ %>
        <div class="course-card" onclick="COMMON_FUNCTIONS.navigateToTheUrl('<?= base_url() ?>course-java')">
           <div class="card-title">
             <%=course.getShortDescription() %>
           </div>
           <div class="card-content">
             <%for(String whatsIncluded: course.getWhatItIncludesCoreList()) {%>
             	Includes: &nbsp; <span><%=whatsIncluded %></span><br>
             <%} %>
             <%for(String whatsIncludedOptional: course.getWhatItIncludesOptionalList()) {%>
             	Optional:&nbsp; <span><%=whatsIncludedOptional %></span><br>
             <%} %>
             Batch Starts: <span><%=course.getStartDate() %></span><br>
             Duration: <span><%=course.getDuration() %></span><br>
             Course Fee: <span><%=course.getCoursefee() %></span><br>
             Classroom Location: <span><%=course.getClassroomLocation() %></span>
             <i class="fa fa-angle-right"></i>
           </div>
           <div class="green" style="margin-top: 8px;">
             <i class="fa fa-star" aria-hidden="true"></i> With placement assistance for freshers.
           </div>
           <div class="card-regfooter" style="margin-top: 15px;">
		      <button  onclick="COMMON_FUNCTIONS.openCommonRegisterPopup()">Register for Demo Session</button>
		    </div>
        </div>
        <%} %>
      </div>
    </div>
  </section>
  <section>
    <div class="container hp-info-3">
    <div class="title" style="margin-bottom: 20px;margin-top: 10px;">
      How we teach programming
    </div>
    <div class="content" style="margin-bottom: 25px;">
      Our courses are rigorous & Hands-on, which we call the "immersive learning experience"Äù. All our courses require good amount of commitment from you, while we do our best to maximize your learning.
    </div>
    <div class="sub-title">
      What our courses include
    </div>
    <div class="content">
       - Lectures by expert instructor<br>
       - Online Assignments<br>
       - Foundation projects (Generally 5)<br>
       - Major Live Projects (Generally 2)<br>
       - Hard core, intense, hands-on programming! <br>
       - Quizzes, pre-session readings & post-session reviews<br>
       - 1:1 doubt clearing & mentoring sessions<br>
    </div>
    <div class="footer">
      <button  onclick="COMMON_FUNCTIONS.openCommonRegisterPopup()">Register for Demo Session</button>
    </div>
    </div>
  </section>
  <section>
    <div class="container hp-info-4">
      <div class="title">
        Important Details About our Courses
      </div>
      <div class="content">
      <div class="about-card">
        <div class="c-img1 text-center">
						<img src="assets/img/training-50.png" alt="">
					</div>
        <div class="c-title">
          Our instructors are experts, who work with top companies 
        </div>
        <div class="c-content">
          We carefully choose expert instructors at Intense80. All our instructors have at least 6-8 years of experience in their respective fields and work with reputed companies. Also they 
        </div>
      </div>
            <div class="about-card">
        <div class="c-img1  text-center">
          <img src="assets/img/variable-50.png" alt="">
        </div>
        <div class="c-title">
          Learn like a pro, using all professional tools and processes
        </div>
        <div class="c-content">
          We carefully choose expert instructors at Intense80. All our instructors have at least 6-8 years of experience in their respective fields and work with reputed companies. Also they 
        </div>
      </div>
            <div class="about-card">
        <div class="c-img1  text-center">
          <img src="assets/img/placement-50.png" alt="">
        </div>
        <div class="c-title">
          We provide placement assistance for Job seekers 
        </div>
        <div class="c-content">
          We carefully choose expert instructors at Intense80. All our instructors have at least 6-8 years of experience in their respective fields and work with reputed companies. Also they 
        </div>
      </div>
            <div class="about-card">
        <div class="c-img1  text-center">
          <img src="assets/img/technology-50.png" alt="">
        </div>
        <div class="c-title">
          You will use our modern technology &amp; collaboration platform
        </div>
        <div class="c-content">
          We carefully choose expert instructors at Intense80. All our instructors have at least 6-8 years of experience in their respective fields and work with reputed companies. Also they 
        </div>
      </div>
      <div class="about-card">
        <div class="c-img1  text-center">
          <img src="assets/img/learning-50.png" alt="">
        </div>
        <div class="c-title">
          Keep learning even after the course ends 
        </div>
        <div class="c-content">
          We carefully choose expert instructors at Intense80. All our instructors have at least 6-8 years of experience in their respective fields and work with reputed companies. Also they 
        </div>
      </div>
      </div>
    </div>
  </section>
  <section>
    <div class="main-footer">
  <div class="green-text">
    Ready to learn programming the right way? Learn by building things?
  </div>
      <div class="cta">
        <button onclick="COMMON_FUNCTIONS.openCommonRegisterPopup()">Register for Demo Session</button>
      </div>
    </div>
  </section>
<!-- Navigation  end -->
</body>
 <!-- home body ends -->
</body>
</html>