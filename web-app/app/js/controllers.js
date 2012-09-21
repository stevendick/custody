'use strict';

/* Controllers */

function MyCtrl1() {}
MyCtrl1.$inject = [];


function MyCtrl2() {
}
MyCtrl2.$inject = [];

function MenuCtrl() {
	
}

function TradeTableCtrl($scope, Trade) {
	$scope.isTrades=true;
	$scope.trades = Trade.query();
}

function TradeEditCtrl($scope, $routeParams, Trade) {
	$scope.trade = Trade.get({id: $routeParams.id});
}

function TradeEditFormCtrl($scope, $location, $routeParams) {
	$scope.submit = function() {
		$scope.trade.$save(function() { 
			$location.path('trades'); 
		});
	};
}

function LoginController($scope, $location) {
	$scope.user = {login: null, password: null, client: null};
}

function LoginFormController($scope, $http, authService) {
	$scope.submit = function() {
		$http.post('../auth/signIn', $scope.user)
		.success(function(data, status, headers, config) {
			authService.loginConfirmed();
		})
		.error(function(data, status, headers, config) {
			$scope.message='doh!';
		});
	};
}

