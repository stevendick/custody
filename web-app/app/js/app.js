'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/landing', {templateUrl: 'partials/landing.html', controller: MyCtrl1});
    $routeProvider.when('/trades', {templateUrl: 'partials/trades.html', controller: MyCtrl2});
    $routeProvider.when('/reports', {templateUrl: 'partials/reports.html', controller: MyCtrl2});
    $routeProvider.otherwise({redirectTo: '/landing'});
  }]);
