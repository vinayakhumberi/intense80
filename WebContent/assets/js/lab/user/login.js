angular.module('i80lab', ["ngCookies"])
  .controller('SignUpController', ['$scope', '$http', '$cookies' ,function($scope, $http, $cookies) {
   
    $scope.user.login = function() {
    	$http({
        	method: 'POST', 
        	url: '../../login', 
        	data: "userHandle="+ $scope.user.LoginCode + "&action=login",
        	headers : { 'Content-Type': 'application/x-www-form-urlencoded'}})
        	.then(function successCallback(response) {
        		//User exists and returned
        		if(response.data.code == "success"){
        			$cookies.put('userHandle', response.data.data.userHandle);
        			window.location.href = "../user/dashboard.jsp";
        		}else{
        			$scope.errorMessageFromServer = "Could not validate user";
                	$scope.isHidden = 'show';
        		}        		
        	  }, function errorCallback(response) {
        		  $scope.errorMessageFromServer = "Could not connect to server";
              	  $scope.isHidden = 'show';
        	  });
    }; 
    
}]);