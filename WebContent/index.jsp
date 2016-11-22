<!DOCTYPE html>
<%@page import="com.i80.pojo.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.i80.web.*"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Intense 80 Conding School</title>

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
	<!-- header start -->
	<link rel="stylesheet" href="assets/css/common.css">
	<div class="main-header">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid pad-0">
				<div class="navbar-header">
					<a class="navbar-brand" href=""><img src="assets/img/logo.png"
						alt=""></a>
				</div>
				<ul class="nav navbar-nav pull-right">
					<li class="dropdown"><a href="javascript:void(0)"
						class="dropdown-toggle" type="button" data-toggle="dropdown">All
							Courses <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
						<%for(Course course : coursesList){ %>
							<li><a href="<?=  base_url()?>course-java">
									<div class="nav-title"><%=course.getShortDescription() %></div>
									<div class="nav-sub-title-blue">Class starts&nbsp;&nbsp;<%=course.getStartDate() %></div>
							</a></li>
						<%} %>
						</ul></li>
					<li><a class="call-number" href="javascript:void(0)"
						onclick="COMMON_FUNCTIONS.openContactUsDialog()"><i
							class="glyphicon glyphicon-earphone"></i> +91 955945224</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<!-- header end -->
	<!-- home body start -->
	<link rel="stylesheet" href="assets/css/home.css?ver=0.2">
	<section>
		<div class="container-fluid main-section">
			<div class="row jumbotron">
				<h1>From beginner to professional programmer in 80 days.</h1>
				<div class="content">
					Yes, it can be done. And that's our mission. Our way of teaching
					coding is <span>completely innovative. Highly Rigorous.
						Practical. project-driven. placement-focussed </span>(for freshers)<span>.
						We call it immersive learning. </span> <br> <br> All we need
					from you is your commitment, a lot of it!

				</div>
				<div class="cta text-center">
					<button id="main-cta">Browse All Courses</button>
				</div>
			</div>
			<div class="main-section-footer">
				<div class="container">
					<div class="row">
						<div class="col-md-7" style="border-right: 1px solid #fff;">
							<span class="m-label">Upcoming Courses:</span> <span
								class="m-value">Complete Java Development</span> <span
								class="m-value">Core Java</span>
						</div>
						<div class="col-md-5">
							<span class="m-label">Location:</span> <span class="m-value">Marathahalli,
								Bangalore</span>
						</div>
					</div>

				</div>
			</div>
		</div>

	</section>
	<section>
		<div class="container other-section">
			<div class="title">Our Story & mission</div>
			<div class="content">
				<div class="row">
					<div class="col-md-4">&nbsp</div>
					<div class="col-md-8 text-left">
						<p>
							Hi, I am Manas, Founder of Intense80. I have more than 10 years
							of exp in the software industry and have worked for top MNCs like
							Oracle, EMC, Intuit in various software development and
							leadership roles. <br> <br> During these years, I have
							interviewed, hired and mentored many people, both freshers and
							professionals. And I have realized 2 things about the skill gap
							that we face - - Freshers are good with theory but lack big time
							when it comes to practical application - Experienced
							professionals want to upgrade their skills, but don’t have the
							right way to <br> <br> I started Intense80 to change
							that. At Intense80, our goal is to teach programming in an
							innovative, rigorous, project-oriented way, so that our students
							can transform from beginner to professionals. That’s our mission
							and anyone associated with us is extremely committed to that
							mission.<br> <br> But there is no magic. It requires
							hard work and commitment from our side as well from you. If you
							are ready, read on...


						</p>
						<div>
							<button>Read More About Our Innovative Way of Learning</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="other-section-1">
		<div class="container-fluid other-section-1">
			<div class="title">Upcoming Courses</div>
			<div class="content">
				<div class="container">
					<div class="bottom">
					<%for(Course course : coursesList){ %>
						<div class="course-card">
							<div class="row">
								<div class="col-md-9 card-left">
									<div class="card-title"><%=course.getShortDescription() %></div>
									<div class="card-detail">Includes - Java (Core +
										Advanced), SQL & Web (HTML, CSS, JavaScript)</div>
									<div class="card-info">High Intensive 3 Month program
										(100 hours classroom + 100 hours online) with best
										instructors, Hands-on coding, Live projects and placement
										focus.</div>
									<div class="tag">With placement assistance for
										students/fresh/recent graduates, who are looking for a job in
										the software industry.</div>
								</div>
								<div class="col-md-3  card-right">
									<div>
										<div class="c-label">Course Fees</div>
										<div class="c-price">RS <%=course.getCoursefee() %></div>
									</div>
									<div>
										<div class="c-label">Batch Starts</div>
										<div class="c-value"><%=course.getStartDate() %></div>
									</div>
									<div>
										<div class="c-label">Classroom Location</div>
										<div class="c-value"><%=course.getClassroomLocation() %></div>
									</div>
									<div>
										<div class="c-label">Duration</div>
										<div class="c-value"><%=course.getDuration() %> Days</div>
									</div>
								</div>
							</div>
							<div class="view-course-details text-right">
								<%if(course.isClickthroughToDetails()) {%>
								<button class="view-course">View Course Details</button>
								<%} %>
								<button class="register-demo">Register for Demo Session</button>
							</div>
						</div>
						<%} %>

					</div>
				</div>
			</div>
		</div>
	</section>
	<section>
		<div class="other-section-2">
			<div class="container">
				<div class="title">Here is how we teach programming</div>
				<div class="content">
					<div class="top">Our courses are rigorous & Hands-on, which
						we call the “immersive learning experience”. All our courses
						require good amount of commitment from you, while we do our best
						to maximize your learning.</div>
					<div class="bottom">
						<div class="row">
							<div class="col-md-4 left">
								<img src="assets/img/UnderComputer-100.png" alt="">
							</div>
							<div class="col-md-8 right">
								<div class="s-title">Here are the typical things, that our
									students go through during a course</div>
								<div class="row s-content">
									<div class="col-md-6">
										- Lectures by expert instructor<br> - Online Assignments<br>
										- Foundation projects (Generally 5)<br> - Major Live
										Projects (Generally 2)<br>
									</div>
									<div class="col-md-6">
										- Hard core, intense, hands-on programming! <br> -
										Quizzes, pre-session readings & post-session reviews<br>
										- 1:1 doubt clearing & mentoring sessions<br>
									</div>
								</div>
								<div class="s-footer">View Some Of The Projects By Our
									Past Students</div>
							</div>
						</div>
					</div>
					<div class="footer text-center">
						To Know More
						<button onclick="COMMON_FUNCTIONS.openCommonRegisterPopup()">Register
							for a demo session</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section>
		<div class="container other-section">
			<div class="title">And here are some important details about
				our courses</div>
			<div>
				<div class="part">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-3"></div>
								<div class="col-md-9">
									<div class="d-title">Our instructors are experts, who
										work with top companies. More importantly they are passionate
										about teaching.</div>
									<div class="d-content">We carefully choose expert
										instructors at Intense80. All our instructors have at least
										6-8 years of experience in their respective fields and work
										with reputed companies. Also they</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-3">
									<img src="" alt="">
								</div>
								<div class="col-md-9">
									<div class="d-title">Our instructors are experts, who
										work with top companies. More importantly they are passionate
										about teaching.</div>
									<div class="d-content">We carefully choose expert
										instructors at Intense80. All our instructors have at least
										6-8 years of experience in their respective fields and work
										with reputed companies. Also they</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="part">
				<div class="row">
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-9">
								<div class="d-title">Our instructors are experts, who work
									with top companies. More importantly they are passionate about
									teaching.</div>
								<div class="d-content">We carefully choose expert
									instructors at Intense80. All our instructors have at least 6-8
									years of experience in their respective fields and work with
									reputed companies. Also they</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-3">
								<img src="" alt="">
							</div>
							<div class="col-md-9">
								<div class="d-title">Our instructors are experts, who work
									with top companies. More importantly they are passionate about
									teaching.</div>
								<div class="d-content">We carefully choose expert
									instructors at Intense80. All our instructors have at least 6-8
									years of experience in their respective fields and work with
									reputed companies. Also they</div>
							</div>
						</div>
					</div>
				</div>
			</div>
						<div class="part">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-9">
								<div class="d-title">Our instructors are experts, who work
									with top companies. More importantly they are passionate about
									teaching.</div>
								<div class="d-content">We carefully choose expert
									instructors at Intense80. All our instructors have at least 6-8
									years of experience in their respective fields and work with
									reputed companies. Also they</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid bottom-cta-section text-center">
			<div class="bottom-cta-title">Ready ro learn programming the
				right way? Learn by building things.</div>
			<div>
				<button class="bottom-cta-button"
					onclick="COMMON_FUNCTIONS.openCommonRegisterPopup()">Register
					for Demo Session</button>
			</div>
		</div>
	</section>
	<div id="files_to_load"></div>
	<script src="assets/js/home.js"></script>
	<!-- home body end -->

	<!-- footer start -->
	<!-- Bootstrap Core JavaScript -->
	<script src="assets/libraries/js/jquery-2.2.4.min.js"></script>
	<script src="assets/libraries/js/bootstrap.min.js"></script>
	<script src="assets/js/trackEvent.js"></script>
	<script src="assets/js/common.js"></script>
	<script src="assets/js/i80-main.js"></script>
	<!-- footer end -->
</body>
</html>

<!-- Popup Includes -->
<div id="register-popup" class="modal fade" role="dialog">
	<div class="modal-dialog  modal-md">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header text-center">
				<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
				<h4 class="modal-title">Happy to see you at intense80</h4>
				<h5>Lets Get Started</h5>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<form id="reg-form">
							<div id="batch-selector" class="form-group">
								<label for="batch">Which batch would you like you to
									join?</label> <select type="batch" class="form-control" id="batch"
									name="batch">
									<option value="October Batch">October Batch</option>
									<option value="November Batch">November Batch</option>
									<option value="December Batch">December Batch</option>
								</select>
							</div>
							<div id="course-selector" class="form-group">
								<label for="course_name">Which course would you like you
									to join?</label> <select type="batch" class="form-control"
									id="course_name" name="course_name">
									<option value="Java Development Immersive">Java
										Development Immersive</option>
									<option value="Complete Core Java">Complete Core Java</option>
									<option value="Android Development Immersive">Android
										Development Immersive</option>
								</select>
							</div>
							<div class="form-group">
								<label for="name">Name:</label> <input type="name"
									class="form-control" id="name" name="name">
							</div>
							<div class="form-group">
								<label for="email">Email address:</label> <input type="email"
									class="form-control" id="email" name="email">
							</div>
							<div class="form-group">
								<label for="mobile">Mobile:</label> <input type="text"
									class="form-control" id="mobile" name="phone">
							</div>
							<!--           <div class="form-group">
            <label for="name">Mode:</label>
            <select type="batch" class="form-control" id="mode" name="mode">
            <option value="Online">Online</option>
            <option value="Classroom">Classroom</option>
            </select>
          </div> -->
						</form>

						<div class="form-group text-center">
							<button class="btn btn-default"
								onclick="COMMON_FUNCTIONS.submitToZoho()">Submit
								Information</button>
							<!-- <label>Waiting to code along side you!</label> -->
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- Popup Includes -->
