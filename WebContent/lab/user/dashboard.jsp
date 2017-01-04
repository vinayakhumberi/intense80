<!DOCTYPE html>
<html lang="en" ng-app="i80lab">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Sign-in with your code</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="../../assets/libraries/css/bootstrap.min.css">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,400i,500,700'
	rel='stylesheet' type='text/css'>
<script src="https://use.fontawesome.com/a177f95dd8.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-cookies.js"></script>
 
<script src="../../assets/js/lab/main.js"></script>
<script src="../../assets/js/lab/user/dashboard.js"></script>
<link rel="stylesheet" href="../../assets/css/lab/common.css">

<!-- Custom CSS -->

<!--Start Google analytics-->
<!--End Google analytics-->
<!--Start Mixpanel Initialize-->
<!-- end Mixpanel -->
</head>


<body>

	<div class="main-header">
		<nav class="navbar navbar-inverse">
			<div class="top-nav-bar container-fluid pad-0">
				<div class="navbar-header">
					<a class="navbar-brand" href=""><img src="../../assets/img/logo.png"
						alt=""></a>
				</div>
				<ul class="nav navbar-nav pull-right">
					<li class="dropdown"><a href="javascript:void(0)"
						class="dropdown-toggle" type="button" data-toggle="dropdown">All
							Courses <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
						
							<li><a href="<?=  base_url()?>course-java">
								<div class="nav-title">Hello</div>
								<div class="nav-sub-title-blue">Class starts&nbsp;&nbsp;World</div>
							</a></li>
						
						</ul></li>
					<li><a class="call-number" href="javascript:void(0)"
						onclick="COMMON_FUNCTIONS.openContactUsDialog()"><img src="assets/img/Phone-50.png" alt=""> +91 955945224</a></li>
				</ul>
			</div>
		</nav>
	</div>
	  <div class="container" ng-controller="DashboardController as userDashboard" style="margin-top: 100px;margin-left: 40px;">    
	      <div class="row">	      	  
	      	  <div class="col-xs-4"></div>
	          <div class="col-xs-10">
	          	<div style="font-weight:bold;margin-bottom:10px;">Hi,{{userDashboard.fullName}}</div>
	                	                
	            </div>	   
	            <div>
	            
	            </div>         
	        </div>
	        <div class="row" style="margin-top: 50px;">
	            <div class="col-xs-6">
	        	    <div class="label label-danger {{errorMessageFromServer}}">{{errorMessageFromServer}}</div>
	        	</div>
	        </div>
       </div>
</body>
</html>
