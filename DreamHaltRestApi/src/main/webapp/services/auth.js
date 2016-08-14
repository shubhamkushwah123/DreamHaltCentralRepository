'use strict';

angular.module("dreamhalt_home").service('auth',function($http){
     
    this.login = function (user){
  
    	var string = 'shubham@gmail.com/shubham123';
    /*	
        return $http({
        	  method: 'GET',
        	  url: 'http://localhost:8080/DreamHaltRestApi/webapi/login/'+ string
        	});
        };
    	*/
        
      /*  return $http({
        	  method: 'GET',
        	  url: 'http://localhost:8080/DreamHaltRestApi/webapi/login/shubham@gmail.com/shubham123'
        	});
        };
    	
    	//alert('call');
        return $http.get('http://localhost:8080/DreamHaltRestApi/webapi/login/shubham@gmail.com/shubham123',
         {
             email : user.email , 
             password : user.password
         });
    
    	
    return $http({
    	  method: 'GET',
    	  url: 'http://localhost:8080/DreamHaltRestApi/webapi/myresource',
    	  params: {
  	        username: user.email,
  	        password: user.password 
  	      } 
    	});
    };   	
    	*/
 
       	
        return $http({
        	  method: 'GET',
        	  url: 'http://localhost:8080/DreamHaltRestApi/webapi/loginTest/query',
        	  params: {
      	        username: user.email,
      	        password: user.password 
      	      } 
        	});
        };


    this.signup = function (user){
         return $http.get('http://localhost:8080/DreamHaltRestApi/webapi/signup',
         {
             fname : user.firstName , 
             email : user.email , 
             password : user.password
         });
    }; 
    
    this.isLoggedIn = function (){
      return (localStorage.getItem('auth_token'))? true : false;  
    };
    

    this.logout = function (){
      return (localStorage.removeItem('auth_token'));  
    };
    
 });
        