function bookController($scope, $modal, $log, BookService) {
	var self = this;
	$scope.book = {};
	self.books = [];
	$scope.action = 'add';
	$scope.message = '';

	getAllBooks();
	
	function getAllBooks() {
		BookService.getAllBook().then(function(d) {
			self.books = d;
		}, function(errResponse) {
			console.error(errResponse);
		});

	}

	$scope.add = function() {
		BookService.addBook($scope.book).then(function(d) {
			$scope.message = 'Book Added Successfully';
			getAllBooks();
			$scope.clear();
		}, function(errResponse) {
			console.error(errResponse);
		});
	}

	$scope.update = function() {
		BookService.updateBook($scope.book).then(function(d) {
			$scope.message = 'Book Updated Successfully';
			getAllBooks();
		}, function(errResponse) {
			console.error(errResponse);
		});
	}

	$scope.edit = function(book) {
		$scope.book = book;
		$scope.action = 'update';
	}

	$scope.deleteBook = function(book) {
		if (confirm("Are you sure want to delete (" + book.name + ") ?") === false) {
			return;
		}
		BookService.deleteBook(book).then(function(d) {
			getAllBooks();
		}, function(errResponse) {
			console.error(errResponse);
		});
	}
	
	// form editing
	////////////////////////////////////////
	$scope.showForm = function(book) {
		
		if( book ) $scope.book = book;
		
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
			console.log("closed");
		});
	};
	
	var ModalInstanceCtrl = function($scope, $modalInstance, bookForm, BookService) {
		$scope.form = {}

		$scope.action = 'update';

		$scope.submitForm = function() {
			if ($scope.form.bookForm.$valid) {
				BookService.updateBook($scope.book).then(
						function(response) {
							console.log('update success.');
							$scope.message = 'book updated successfully.';
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
			console.log("cancelled");
			location.reload();
		};
	};
	
}

////////////////////////////////////////

var controllerApp = angular.module('controllerApp', [ 'LibraryService' ]);
controllerApp.controller('bookController', bookController);


