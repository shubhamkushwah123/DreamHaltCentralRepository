 angular.module("dreamhalt_user").service('auth',function($http){
     
 
    this.invite = function (user){
         return $http.get('http://localhost:8080/DreamHaltRestApi/webapi/invite',
         {
             email : user.email
            
         });
    }; 
    
 });
        