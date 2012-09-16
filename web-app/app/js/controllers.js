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


