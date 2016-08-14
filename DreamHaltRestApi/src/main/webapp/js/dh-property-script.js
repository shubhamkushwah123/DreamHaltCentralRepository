
/* Routing for index Paging */
var main = angular
        .module("dreamhalt_property", ["ngRoute", "ngAnimate"])
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                    .when('/index.html',
                            {
                                templateUrl: 'add_property.html'
                            })
                    .when('/',
                            {
                                templateUrl: 'add_property.html'
                            })
                    .when('/add',
                            {
                                templateUrl: 'add_property.html'
                            })

                    .when('/basics', {
                        templateUrl: 'add_property.html'

                    })
                    .when('/description',
                            {
                                templateUrl: 'add_property.html'
                            })

                    .when('/about', {
                        templateUrl: 'profile.html'

                    })
                    .when('/contact', {
                        templateUrl: 'profile.html'

                    })
                    .when('/general', {
                        templateUrl: 'profile.html'

                    })
                    .when('/social', {
                        templateUrl: 'profile.html'

                    })
                    .when('/view',
                            {
                                templateUrl: 'view.html'
                            })
                    .otherwise({
                        templateUrl: '404.html'
                    });
                 $locationProvider.html5Mode(true);            
        })
        .controller('user-header', function ($scope) {
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

        .controller('slider-image', ['$scope', '$interval',
            function ($scope, $interval) {
                $scope.slides = [
                    "header_image_1.jpg",
                    "header_image_2.jpg",
                    "header_image_3.jpg"
                ];
                var i = 0;
                $scope.currentimage = $scope.slides[i];
                $interval(function () {
                    if (i >= 2)
                        i = 0;
                    else
                        ++i;
                    $scope.currentimage = $scope.slides[i];
                }, 10000);
            }
        ])
        .controller('header-menu', function ($scope) {

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
        .controller('help-menu', function ($scope) {

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






