'use strict';


// Declare app level module which depends on filters, and services
angular.module('Custody', ['Custody.filters', 'Custody.services', 'Custody.directives']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/landing', {templateUrl: 'partials/landing.html', controller: MyCtrl1});
    $routeProvider.when('/trades', {templateUrl: 'partials/trades.html', controller: MyCtrl2});
    $routeProvider.when('/trades/edit/:id', {templateUrl: 'partials/trade/edit.html', controller: TradeEditCtrl});
    $routeProvider.when('/reports', {templateUrl: 'partials/reports.html', controller: MyCtrl2});
    $routeProvider.otherwise({redirectTo: '/landing'});
  }]);
