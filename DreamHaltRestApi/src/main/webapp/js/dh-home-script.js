
/* Routing for index Paging */
/* global controller */

var main = angular
        .module('dreamhalt_home', [
            'ngRoute',
            'ngResource',
            'ngCookies',
            'ngSanitize'
        ])
        .factory('authIntercepter', function ($q,$location) {
            return {
                request: function (config) {
                    config.headers = config.headers || {};
                    if (localStorage.auth_token) {
                        config.headers.token = localStorage.auth_token;
                    }
                    return config;
                },
                responseError :function(response){
                    if(response.status === 401){
                        $location.path('/login');
                    }
                    return $q.reject(response);
                }
            };
        })
        .config(function ($httpProvider) {
            $httpProvider.interceptors.push('authIntercepter');
        })
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'views/home.html',
                        controller: 'home_controller'
                    })
                    .when('/index.html', {
                        templateUrl: 'views/home.html',
                        controller: 'home_controller'
                    })
                    .when('/home', {
                        templateUrl: 'views/home.html',
                        controller: 'home_controller'
                    })
                    .when('/contact', {
                        templateUrl: 'views/contact_us.html',
                        controller: 'contact_controller'
                    })
                    .when('/signup', {
                        templateUrl: 'views/signup.html',
                        controller: 'signup_controller'
                    })
                    .when('/login', {
                        templateUrl: 'views/login.html',
                        controller: 'login_controller'
                    })
                    .otherwise({
                        redirectTo: '/404.html'
                    });

            //   $locationProvider.html5Mode(true);
        })
        .controller('login_controller', function ($scope, auth, $location) {

            $scope.login = function () {
                if ($scope.loginForm.$valid)
                {
                    console.log("Sending request to server");
                    var promise = auth.login($scope.user)
                    promise.then(success, error);
                }
            };

            var success = function (response) {
            	
            	//alert(response.data.college);
            	
            	console.log(response.data.status);
                localStorage.setItem('auth_token', response.data.auth_token);
                $location.path('/');
            };

            var error = function (response) {
                $scope.wrongCredentials = true;
            };

            $scope.cancel = function () {

                console.log("user has cancel the login");
                $location.path('/');
            };


        })
        .controller('signup_controller', function ($scope, auth, $location) {

            $scope.signup = function () {
                if ($scope.signupForm.$valid)
                {
                    console.log("Sending request to server");
                    var promise = auth.signup($scope.user)
                    promise.then(success, error);
                }
            };

            var success = function (response) {
                localStorage.setItem('auth_token', response.data.auth_token);
                $location.path('/contact');
            };

            var error = function (response) {
                $scope.errorOccured = true;
            };

            $scope.cancel = function () {

                console.log("user has cancel the login");
                $location.path('/');
            };



        })
        .controller('search_controller', function ($scope) {
            $scope.location;
            $scope.checkindate;
            $scope.checkoutdate;
            $scope.guests = [
                'Guest 1',
                'Guests 2',
                'Guests 3',
                'Guests 4',
                'Guests 5',
                'Guests 6'
            ];
            $("#checkindate").datepicker({
                changeMonth: true,
                changeYear: true,
                yearRange: "c-1:c+10",
                startDate: '+1d',
                autoclose: true,
                format: "dd/mm/yyyy"
            }).on("changeDate", function (e) {
                $scope.checkindate = $("#checkindate").val();
                $("#indate").addClass("is-focused");


            });

            $("#checkoutdate").datepicker({
                changeMonth: true,
                changeYear: true,
                yearRange: "c-1:c+10",
                startDate: '+1d',
                autoclose: true,
                format: "dd/mm/yyyy"
            }).on("changeDate", function (e) {
                $scope.checkoutdate = $("#checkoutdate").val();
                $("#outdate").addClass("is-focused");
                if ($scope.checkoutdate < $scope.checkindate)
                {
                    swal("Check out date should be equal to or greater than check in date.", "warning");
                    $("#checkoutdate").val('');
                }
            });

            $scope.selected = $scope.guests[0];

            $scope.submit = function () {
                if ($scope.location == null || $scope.location.trim() == '')
                {
                    swal("Please enter location!.");
                }
                else
                    swal("location : " + $scope.location
                            + "/n checkindate : " + $scope.checkindate
                            + "checkoutdate : " + $scope.checkoutdate
                            + "numberofguest : " + $scope.selected);
            };

        })
        .controller('location_list_controller', function ($scope) {

            $scope.currentlocation = "MH,Mumbai";
            $scope.location = [{
                    name: 'New Delhi',
                    image: './img/location/new-delhi.jpg',
                    count: '30',
                    size: 'col-md-4'
                },
                {
                    name: 'Mumbai',
                    image: './img/location/mumbai.jpg',
                    count: '33',
                    size: 'col-md-4'
                },
                {
                    name: 'Pune',
                    image: './img/location/pune.jpg',
                    count: '24',
                    size: 'col-md-4'
                },
                {
                    name: 'Goa',
                    image: './img/location/goa.jpg',
                    count: '3',
                    size: 'col-md-4'
                },
                {
                    name: 'Bhopal',
                    image: './img/location/bhopal.jpg',
                    count: '3',
                    size: 'col-md-8'
                }

            ];

        })
        .controller('slider_image', ['$scope', '$interval', function ($scope, $interval) {
                $scope.slides = [
                    "header_image_1.jpg",
                    "header_image_2.jpg",
                    "header_image_3.jpg"
                ];
                var i = 0;
                $scope.currentimage = $scope.slides[0];
                $interval(function () {
                    if (i >= 2)
                        i = 0;
                    else
                        ++i;
                    $scope.currentimage = $scope.slides[i];
                }, 10000);
            }])
        .controller('header_controller', function ($scope,$location,auth) {

            $scope.isLoggedIn = auth.isLoggedIn;
    
        /*    $scope.isActive = function(path){
                var currentPath = $location.path().split('/')[1].split('?')[0];
                return currentPath === path.split('/')[1];
            };
          */  
           
            
            $scope.logout = function () {
               
                    console.log("Sending request to server");
                    var promise = auth.logout()
                    promise.then(success, error);
               
            };

            var success = function (response) {
                $location.path('/');
            };

            var error = function (response) {
                $scope.errorOccured = true;
            };
            
        })
        .controller('help_menu', function ($scope) {

            $scope.lists =
                    [
                        {
                            name: 'How To Become A Host',
                            link: './add_property.html'

                        },
                        {
                            name: 'How Do I Earn Money',
                            link: '#'
                        },
                        {
                            name: 'Security Tips',
                            link: '#'
                        },
                        {
                            name: 'What Is Reliable Host',
                            link: '#'
                        }

                    ];

            $scope.close = function () {


            };


        })
        .controller('home_controller', function ($scope) {

            $scope.lists =
                    [
                        {
                            name: 'How To Become A Host',
                            link: './add_property.html'

                        },
                        {
                            name: 'How Do I Earn Money',
                            link: '#'
                        },
                        {
                            name: 'Security Tips',
                            link: '#'
                        },
                        {
                            name: 'What Is Reliable Host',
                            link: '#'
                        }

                    ];

            $scope.close = function () {


                $('#modal-help').modal('toggle');
                //alert("hi");

            };


        });






