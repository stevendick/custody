'use strict';

// Declare app level module which depends on filters, and services
angular.module(
		'Custody',
		[ 'Custody.filters', 'Custody.services', 'Custody.directives',
				'http-auth-interceptor', 'ui' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/landing', {
				templateUrl : 'partials/landing.html',
				controller : MyCtrl1
			});
			$routeProvider.when('/trades', {
				templateUrl : 'partials/trades.html',
				controller : MyCtrl2
			});
			$routeProvider.when('/trades/edit/:id', {
				templateUrl : 'partials/trade/edit.html',
				controller : TradeEditCtrl
			});
			$routeProvider.when('/reports', {
				templateUrl : 'partials/reports.html',
				controller : MyCtrl2
			});
			$routeProvider.otherwise({
				redirectTo : '/landing'
			});
		} ])
.directive('authDemoApplication', function() {
	return {
		restrict : 'C',
		link : function(scope, elem, attrs) {
			//once Angular is started, remove class:
			//elem.removeClass('waiting-for-angular');

			var login = elem.find('#login-holder');
			var main = elem.find('#content');

			login.hide();

			scope.$on('event:auth-loginRequired', function() {
				main.hide();
				login.slideDown('slow');
			});
			scope.$on('event:auth-loginConfirmed', function() {
				main.show();
				login.slideUp();
			});
		}
	}
});