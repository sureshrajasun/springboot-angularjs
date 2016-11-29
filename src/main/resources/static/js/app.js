var app = angular.module('app', ['ngRoute']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl: '/views/roles.html',
            controller: 'rolesController'
        })
        .when('/listEmployee',{
            templateUrl: '/views/employeeList.html',
            controller: 'employeeListCtrl'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

