/**
 * Created by teisaacs on 8/13/14.
 */
var app = angular.module('mystudents', [
    'ngRoute',
    'ngResource',
    'mystudents.MenuService',
    'mystudents.Students'
]);


/**
 * Setup the default route for the app.  Each module of code will add it's routes on module config
 */
app.config(['$routeProvider','$httpProvider', function($routeProvider, $http) {
    $routeProvider.when('/home', {templateUrl: 'src/home.tpl.html'});
    $routeProvider.otherwise({redirectTo: '/home'});
}]);