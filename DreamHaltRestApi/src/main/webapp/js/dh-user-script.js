
/* Routing for index Paging */
var app = angular
        .module("dreamhalt_user", ["ngRoute", "angularUtils.directives.dirPagination"])
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                    .when('/index.html',
                            {
                                templateUrl: 'dashboard.html',
                                controller: 'user_dashboard'
                            })
                    .when('/',
                            {
                                templateUrl: 'dashboard.html',
                                controller: 'user_dashboard'
                            })
                    .when('/dashboard',
                            {
                                templateUrl: 'dashboard.html',
                                controller: 'user_dashboard'
                            })

                    .when('/profile', {
                        templateUrl: 'profile.html',
                        controller: 'user_profile'

                    })
                    .when('/reservations',
                            {
                                templateUrl: 'reservations.html',
                                controller: 'user_profile'
                            })
                    .when('/requirements',
                            {
                                templateUrl: 'requirements.html',
                                controller: 'user_profile'
                            })
                    .when('/list',
                            {
                                templateUrl: 'list.html',
                                controller: 'user_profile'
                            })
                    .when('/account',
                            {
                                templateUrl: 'notification.html',
                                controller: 'user_profile'
                            })
                    .when('/notifications',
                            {
                                templateUrl: 'notification.html',
                                controller: 'user_profile'
                            })
                    .when('/payment_methods',
                            {
                                templateUrl: 'payment_methods.html',
                                controller: 'user_payment_method'
                            })
                    .when('/payout_preferences',
                            {
                                templateUrl: 'payout_preferences.html',
                                controller: 'user_profile'
                            })
                    .when('/transaction_history',
                            {
                                templateUrl: 'transaction_history.html',
                                controller: 'user_profile'
                            })
                    .when('/privacy',
                            {
                                templateUrl: 'privacy.html',
                                controller: 'user_privacy'
                            })
                    .when('/security',
                            {
                                templateUrl: 'security.html',
                                controller: 'user_security'
                            })
                    .when('/settings',
                            {
                                templateUrl: 'settings.html',
                                controller: 'user_setting'
                            })
                    .when('/edit_verification',
                            {
                                templateUrl: 'edit_verification.html',
                                controller: 'user_profile'
                            })
                    .when('/photo_upload',
                            {
                                templateUrl: 'photo_upload.html',
                                controller: 'user_profile'
                            })
                    .when('/references',
                            {
                                templateUrl: 'references.html',
                                controller: 'user_profile'
                            })
                    .when('/reviews',
                            {
                                templateUrl: 'reviews.html',
                                controller: 'user_review'
                            })
                    .when('/messages',
                            {
                                templateUrl: 'messages.html',
                                controller: 'user_profile'
                            })
                    .when('/view',
                            {
                                templateUrl: 'view.html',
                                controller: 'user_profile'
                            })
                    .when('/credit',
                            {
                                templateUrl: 'invite.html',
                                controller: 'invite_controller'
                            })
                    .when('/invite',
                            {
                                templateUrl: 'invite.html',
                                controller: 'invite_controller'
                            })
                    .otherwise({
                        templateUrl: '404.html'
                    });
            $locationProvider.html5Mode(true);
        })
        .controller('user_header', function ($scope) {
            $scope.heading = 'User Dashboard';
            $scope.count = '5';
            $scope.notification = [{
                    name: 'Notification 1',
                    number: '1'
                },
                {
                    name: 'Notification 2',
                    number: '2'
                },
                {
                    name: 'Notification 3',
                    number: '3'
                },
                {
                    name: 'Notification 4',
                    number: '4'
                },
                {
                    name: 'Notification 5',
                    number: '5'
                }

            ];
        })
        .controller('user_dashboard', function ($scope, $http) {

            this.tab = 1;
            this.setTab = function (tabID) {

                this.tab = tabID;
            };
            this.isSet = function (tabID) {
                return this.tab === tabID;
            };
            $scope.firstName = 'Bhupender';
            $scope.middleName = 'Singh';
            $scope.lastName = 'Darmal';
            $scope.about = 'I like the way you work it. No diggity. I wanna bag it up';
            $scope.gender = [
                'Male',
                'Female'
            ];
            $scope.selectedGender = $scope.gender[0];
            $scope.dob = "03/06/1991";
            $("#dob").datepicker({
                changeMonth: true,
                changeYear: true,
                yearRange: "c-1:c+10",
                startDate: '+1d',
                autoclose: true,
                format: "dd/mm/yyyy"
            }).on("changeDate", function (e) {
                $scope.dob = $("#checkindate").val();
            });
            $scope.school = 'K V Birpur,Dehradun';
            $scope.work = 'Tata  Consultancy Services';
            $scope.languages = 'English, Hindi';
            $scope.phonenumber = '9987218936';
            $scope.email = 'bhupender.singh405@gmail.com';
            $scope.address = 'flat 2 , b wing , desale pada';
            $scope.city = 'Mumbai';
            $scope.country = 'India';
            $scope.pincode = 421201;
            $scope.facebook = 'www.facebook.com/1singh';
            $scope.linkedin = 'www.linkedin.com/1singh';
            $scope.twitter = 'www.twitter.com/1singh';
            $scope.googleplus = 'plus.google.com/1singh';
            $scope.skype = 'www.skype.com/1singh';
            $scope.instagram = 'www.instagram.com/1singh';
            $scope.pinrest = 'www.pinrest.com/1singh';
            $scope.listingCount = 10;
            $scope.earnedAmount = 125;
            $scope.friendCount = 125;
            $scope.messageCount = 0;
            $scope.submit = function () {
                {
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
        .controller('user_profile', function ($scope, $http) {

            this.tab = 1;
            this.setTab = function (tabID) {
                alert(tabID);
                this.tab = tabID;
            };
            this.isSet = function (tabID) {
                return this.tab === tabID;
            };
            $scope.firstName = 'Bhupender';
            $scope.middleName = 'Singh';
            $scope.lastName = 'Darmal';
            $scope.about = 'I like the way you work it. No diggity. I wanna bag it up';
            $scope.gender = [
                'Male',
                'Female'
            ];
            $scope.selectedGender = $scope.gender[0];
            $scope.dob = "03/06/1991";
            $("#dob").datepicker({
                changeMonth: true,
                changeYear: true,
                yearRange: "c-1:c+10",
                startDate: '+1d',
                autoclose: true,
                format: "dd/mm/yyyy"
            }).on("changeDate", function (e) {
                $scope.dob = $("#checkindate").val();
            });
            $scope.school = 'K V Birpur,Dehradun';
            $scope.work = 'Tata  Consultancy Services';
            $scope.languages = 'English, Hindi';
            $scope.phonenumber = '9987218936';
            $scope.email = 'bhupender.singh405@gmail.com';
            $scope.address = 'flat 2 , b wing , desale pada';
            $scope.city = 'Mumbai';
            $scope.country = 'India';
            $scope.pincode = 421201;
            $scope.facebook = 'www.facebook.com/1singh';
            $scope.linkedin = 'www.linkedin.com/1singh';
            $scope.twitter = 'www.twitter.com/1singh';
            $scope.googleplus = 'plus.google.com/1singh';
            $scope.skype = 'www.skype.com/1singh';
            $scope.instagram = 'www.instagram.com/1singh';
            $scope.pinrest = 'www.pinrest.com/1singh';
            $scope.listingCount = 10;
            $scope.earnedAmount = 125;
            $scope.friendCount = 125;
            $scope.messageCount = 0;
            $scope.submit = function () {
                {
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
        .controller('user_security', function ($scope, $http) {

            $scope.currentPassword = '';
            $scope.newPassword = '';
            $scope.confirmedPassword = '';
            $scope.loginNotification = false;
            $scope.changeNotification = function () {
                {
                    swal($scope.loginNotification + "");
                }

            };
            $scope.updatePassword = function () {
                {
                    swal("current : " + $scope.currentPassword + " new : " + $scope.newPassword);
                    if ($scope.confirmedPassword === $scope.newPassword)
                    {
                        $http.get("http://localhost:8080/DreamHaltRestApi/webapi/login", {
                        }).then(function (response) {
                            //  alert(response);
                            swal("Great!!!", "Password Updated Sucessfully! ", "success");
                        },
                                function errorCallback(response)
                                {
                                    alert("error " + response.data);
                                    swal("Unable to update password!", "An error occured while updaing the passsword! Please try again! ", "error")
                                });
                    }
                    else
                    {
                        swal({title: "Are you sure?", text: "You will not be able to recover this imaginary file!", type: "warning", showCancelButton: true, confirmButtonColor: "#DD6B55", confirmButtonText: "Yes, delete it!", closeOnConfirm: false}, function () {
                            swal("Deleted!", "Your imaginary file has been deleted.", "success");
                        });
                        // swal("Good job!", "You clicked the button!", "success")
                        // sweetAlert("Oops...", "Something went wrong!", "error");
                        //  swal("error ! Confirmed Password does not matched! ");
                    }
                }

            };
        })
        .controller('user_setting', function ($scope, $http) {

            $scope.country = 'India';
            $scope.newPassword = '';
            $scope.confirmedPassword = '';
            $scope.loginNotification = false;
            $scope.saveCountryResidence = function () {
                {
                    swal($scope.country + "");
                }

            };
            $scope.cancelAccount = function () {
                {
                     swal(
                          {
                          title: "Are you sure?", 
                           text: "You will not be able to recover your account!", 
                           type: "warning", 
               showCancelButton: true, 
             confirmButtonColor: "#DD6B55",
              confirmButtonText: "Yes, delete it!",
              closeOnConfirm: false}, 
                      function () 
                        { 
                           $http.get("http://localhost:8080/DreamHaltRestApi/webapi/login", {
                        }).then(function (response) {
                         
                           swal("Deleted!", "Your Account has been deleted.", "success");
                        },
                                function errorCallback(response)
                                {
                                    alert("error " + response.data);
                                    swal("Unable to delete your Account", "An error occured while deleting Account! Please try again! ", "error")
                                });  
                         
                         
                        });
                       
                    if ($scope.confirmedPassword === $scope.newPassword)
                    {
                       
                    }
                    else
                    {
                           
                        // swal("Good job!", "You clicked the button!", "success")
                        // sweetAlert("Oops...", "Something went wrong!", "error");
                        //  swal("error ! Confirmed Password does not matched! ");
                    }
                }

            };
        })
        .controller('transaction_history', function ($scope, $http) {



            $scope.list =
                    [
                        {
                            id: 1,
                            date: '02/06/2016',
                            type: 'Room',
                            details: 'Complete room with kitchen',
                            Amount: 1000,
                            paidOut: 250,
                            confirmed: true
                        },
                        {
                            id: 2,
                            date: '02/06/2016',
                            type: 'Flat',
                            details: 'Complete room with kitchen',
                            Amount: 1800,
                            paidOut: 250,
                            confirmed: true
                        },
                        {
                            id: 3,
                            date: '02/05/2016',
                            type: 'Flat',
                            details: 'Complete room with kitchen',
                            Amount: 1200,
                            paidOut: 150,
                            confirmed: true
                        },
                        {
                            id: 4,
                            date: '05/06/2016',
                            type: 'Room',
                            details: 'Complete room with kitchen',
                            Amount: 3000,
                            paidOut: 250,
                            confirmed: true
                        },
                        {
                            id: 5,
                            date: '05/06/2016',
                            type: 'Room',
                            details: 'Complete room with kitchen',
                            Amount: 3000,
                            paidOut: 250,
                            confirmed: true
                        },
                        {
                            id: 6,
                            date: '02/06/2016',
                            type: 'Room',
                            details: 'Complete room with kitchen',
                            Amount: 1000,
                            paidOut: 250,
                            confirmed: true
                        },
                        {
                            id: 7,
                            date: '02/06/2016',
                            type: 'Flat',
                            details: 'Complete room with kitchen',
                            Amount: 1800,
                            paidOut: 250,
                            confirmed: true
                        },
                        {
                            id: 8,
                            date: '02/05/2016',
                            type: 'Flat',
                            details: 'Complete room with kitchen',
                            Amount: 1200,
                            paidOut: 150,
                            confirmed: true
                        },
                        {
                            id: 9,
                            date: '05/06/2016',
                            type: 'Room',
                            details: 'Complete room with kitchen',
                            Amount: 3000,
                            paidOut: 250,
                            confirmed: true
                        },
                        {
                            id: 10,
                            date: '05/06/2016',
                            type: 'Room',
                            details: 'Complete room with kitchen',
                            Amount: 3000,
                            paidOut: 250,
                            confirmed: true
                        }
                    ];
            $scope.sort = function (keyname) {
                $scope.sortKey = keyname; //set the sortKey to the param passed
                $scope.reverse = !$scope.reverse; //if true make it false and vice versa
            }

            $scope.calculate = function () {
                {
                    $scope.totalAmount = 0;
                    $scope.totalpaidOut = 0;
                    for (var i in $scope.list) {
                        if ($scope.list[i].confirmed === true)
                        {
                            $scope.totalpaidOut = $scope.totalpaidOut + $scope.list[i].paidOut;
                            $scope.totalAmount = $scope.totalAmount + $scope.list[i].Amount;
                        }
                    }

                }

            };
        })
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
        })
        .controller('user_review', function ($scope, $http) {

            this.tab = 1;
            this.setTab = function (tabID) {
                this.tab = tabID;
            };
            this.isSet = function (tabID) {
                return this.tab === tabID;
            };
            $scope.submit = function () {
                {
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
        .controller('user_notification', function ($scope, $http) {


            $scope.contact = [
                '9987218936'
            ];
            $scope.selectedContact = $scope.contact[0];
            $scope.message = false;
            $scope.reservation = false;
            $scope.other = false;
            $scope.emailGeneral = false;
            $scope.emailReservation = false;
            $scope.submit = function () {
                {
                    swal($scope.message + ", " + $scope.reservation + "," + $scope.other + "," + $scope.emailGeneral + "," + $scope.emailReservation);
                    $http.get("http://localhost:8080/DreamHaltRestApi/webapi/login", {
                    }).then(function (response) {
                        alert(response);
                    }, function errorCallback(response) {
                        alert("error " + response.data);
                    });
                }

            };
        })
        .controller('user_references', function ($scope, $http) {

            this.tab = 1;
            this.setTab = function (tabID) {
                this.tab = tabID;
            };
            this.isSet = function (tabID) {
                return this.tab === tabID;
            };
            $scope.submit = function () {
                {
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
        .controller('user_privacy', function ($scope, $http) {
            $scope.socialNotification = true;
            $scope.timelineNotification = true;
            $scope.submit = function () {
                {
                    swal("socialNotification " + $scope.socialNotification);
                    $http.get("http://localhost:8080/DreamHaltRestApi/webapi/login", {
                    }).then(function (response) {
                        alert(response);
                    }, function errorCallback(response) {
                        alert("error " + response.data);
                    });
                }

            };
        })
        .controller('user_payment_method', function ($scope, $http) {

            $scope.giftcardbalance = 100;
            $scope.giftcard = '';
            $scope.submit = function () {
                {
                    swal("giftcard " + $scope.giftcard + " balance : " + $scope.giftcardbalance);
                    $http.get("http://localhost:8080/DreamHaltRestApi/webapi/login", {
                    }).then(function (response) {
                        alert(response);
                    }, function errorCallback(response) {
                        alert("error " + response.data);
                    });
                }

            };
        })
         .controller('invite_controller', function ($scope,auth) {

          
           $scope.invite = function () {
                if ($scope.inviteForm.$valid)
                {
                    console.log("Sending request to server");
                    var promise = auth.invite($scope.user)
                    promise.then(success,error);          
                }
            };
            
            var success = function (response) {
                 $scope.sucessemail = true;
            };

           var error = function (response) {
                $scope.nosuchemail = true;
            };

        });






