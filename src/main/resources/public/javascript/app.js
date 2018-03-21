(function() {

	var app = angular.module('mainCtrl', []);

	app.config([ '$httpProvider', function($httpProvider) {
		$httpProvider.defaults.useXDomain = true;
		delete $httpProvider.defaults.headers.common['X-Requested-With'];
	} ]);

	var otroControler = function($scope, $http) {
		$scope.info = function(v) {
			$http.get('http://localhost:5000/getOrder/' + v.id).then(
				function(response) {
					$scope.valores=response.data;
				},
				function(err){
					alert("No hay producto disponible");
				});
		};
	}

	var cardController = function($scope){
		console.log("hola");
		$scope.card = "SQUA";
	}
	
	app.controller('otroControler', otroControler);

	
	
	app.controller('cardController', cardController);



})();