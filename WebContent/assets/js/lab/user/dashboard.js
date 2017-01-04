angular.module('i80lab', ["ngCookies"])
  .controller('DashboardController', ['$scope', '$http', '$cookies', function($scope, $http, $cookies) {
   
	  $scope.userDashboard.load = function() {
	    	$http({
	        	method: 'POST', 
	        	url: '../../dashboard', 
	        	data: "userHandle="+ $cookies.get('userHandle') + "&action=login",
	        	headers : { 'Content-Type': 'application/x-www-form-urlencoded'}})
	        	.then(function successCallback(response) {
	        		//User exists and returned
	        		if(response.data.code == "success"){
	        			$scope.userDashboard.fullName = response.data.data.user.fullName;
	        		}else{
	        			$scope.errorMessageFromServer = "Could not retrieve user data";
	                	$scope.isHidden = 'show';
	        		}        		
	        	  }, function errorCallback(response) {
	        		  $scope.errorMessageFromServer = "Could not connect to server";
	              	  $scope.isHidden = 'show';
	        	  });
	    }; 
	    
	    $scope.userDashboard.load();
	    
	}]);