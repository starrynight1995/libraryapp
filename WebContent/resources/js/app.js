var formApp = angular.module('formApp', [ 'ui.bootstrap' ]);
formApp.controller("formControl", [ '$scope', '$modal', '$log', '$http',

function($scope, $modal, $log) {

	$scope.showForm = function() {

		var modalInstance = $modal.open({
			templateUrl : 'resources/modal/modal-form.html',
			controller : ModalInstanceCtrl,
			scope : $scope,
			resolve : {
				bookForm : function() {
					return $scope.bookForm;
				}
			}
		});

		modalInstance.result.then(function(selectedItem) {
			$scope.selected = selectedItem;
		}, function() {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};
} ]);

var ModalInstanceCtrl = function($scope, $modalInstance, $http, bookForm,
		BookService) {
	$scope.form = {}
	$scope.book = {
		name : "",
		author : "",
		description : ""
	};
	$scope.book = {};
	$scope.action = 'add';

	$scope.submitForm = function() {
		if ($scope.form.bookForm.$valid) {
			BookService.addBook($scope.book).then(function(response) {
				console.log('add success');
				location.reload();
			}, function(errResponse) {
				console.error(errResponse);
			});
			$modalInstance.close('closed');
		} else {
			console.log("form is invalid");
		}
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
};


////////////////////////////////////////


// same page two Apps integration
var rootApp = angular.module('rootApp', [ 'controllerApp', 'formApp' ]);