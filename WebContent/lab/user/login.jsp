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
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-route.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-cookies.js"></script>

<script src="../../assets/js/lab/user/login.js"></script>

<!-- Custom CSS -->

<!--Start Google analytics-->
<!--End Google analytics-->
<!--Start Mixpanel Initialize-->
<!-- end Mixpanel -->
</head>


<body>
	  <div class="container" ng-controller="SignUpController as user" style="margin-top: 100px;margin-left: 40px;">    
	      <div class="row">	      	  
	      	  <div class="col-xs-4"></div>
	          <div class="col-xs-10">
	          	<div style="font-weight:bold;margin-bottom:10px;">LOG IN with your code</div>
	                <form  class="form-signin" role="form">	                    
	                    <input id="LoginCode" type="text" class="form-control" placeholder="Your Code" ng-model="user.LoginCode">
	                    <a class="btn-login btn-default btn btn-block" type="submit" ng-click="user.login()">Login</a>
	                </form>	                
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
