'use strict';

/* Services */

// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('Custody.services', []).value('version', '0.1');

angular.module('Custody.services', [ 'ngResource' ]).factory('Trade',
		function($resource) {
			return $resource('../trades/:id', {id: '@id'});
		});