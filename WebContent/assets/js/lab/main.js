angular.module('i80lab', []).factory('userService', function() {
	 var savedData = {};
	 function set(data) {
	   savedData = data;
	 }
	 function get() {
	  return savedData;
	 };

	 return {
	  set: set,
	  get: get
	 };

});
