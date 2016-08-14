
/* Routing for index Paging */
/* global controller */

var main = angular
        .module("dreamhalt_home", ["ngRoute", "ngAnimate"])
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                    .when('/index.html', {
                        redirectTo: '/',
                        controller: 'user_profile'
                    })
                    .when('/contact', {
                        templateUrl: 'views/contact_us.html',
                        controller: 'user_profile'
                    })
                    .when('/login', {
                        templateUrl: 'views/login.html'

                    });

            $locationProvider.html5Mode(true);
        })
        .controller('login_controller', function ($scope, $http) {
            $scope.email;
            $scope.password;

            $scope.submit = function () {
                if ($scope.loginForm.$valid)
                {
                    console.log("Sending request to server");
                  //sweetAlert("Oops...", "Please Enter Mail ID & Password.", "error");

                }
                else {
                    //swal("email : " + $scope.email + " password : " + $scope.password);
                    $http.get("http://localhost:8080/DreamHaltRestApi/webapi/login", {
                    }).then(function (response) {
                        alert(response);
                    }, function errorCallback(response) {
                        alert("error " + response.data);
                    });
                }

            };


        })
        .controller('signup_controller', function ($scope) {
            $scope.email;
            $scope.password;
            $scope.firstname;
            $scope.submit = function () {
                if ($scope.email == null || $scope.password == null || $scope.firstname == null)
                {
                   
                   swal({  
                       title: "Error!",   
                       text: "Please fill complete information!",   
                       type: "warning"
                   });
                }
                else
                    swal("email : " + $scope.email + " password : " + $scope.password + "first name : " + $scope.firstname);
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
                    swal("Check out date should be equal to or greater than check in date.","warning");
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
        .controller('slider_image', ['$scope', '$interval',
            function ($scope, $interval) {
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
            }
        ])
        .controller('header_menu', function ($scope) {

            $scope.default =
                    [
                        {
                            name: 'Become a Host',
                            link: './add_property.html',
                            toggle: 'modal',
                            target: 'modal-property'
                        },
                        {
                            name: 'Help',
                            link: '#',
                            toggle: 'modal',
                            target: 'modal-help'
                        },
                        {
                            name: 'Sign Up',
                            link: '#',
                            toggle: 'modal',
                            target: 'modal-register'
                        },
                        {
                            name: 'log in',
                            link: '#',
                            toggle: 'modal',
                            target: 'modal-login'
                        }

                    ];

            $scope.showmodal = function () {


                $('#modal-signin').modal('toggle');
                //alert("hi");

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


                $('#modal-help').modal('toggle');
                //alert("hi");

            };


        });






