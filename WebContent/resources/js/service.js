var validationHandler = angular.module('LibraryService', []);

validationHandler.factory('BookService', function($http, $q) {

	var factory = {
		getAllBook : getAllBook,
		addBook : addBook,
		updateBook : updateBook,
		deleteBook : deleteBook
	};
	return factory;

	function getAllBook() {
		var deferred = $q.defer();

		$http({
			  method: 'GET',
			  url: 'service/book/list'
			}).then(
				function(response) {

					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error(errResponse);
					deferred.reject(errResponse);
				});

		return deferred.promise;
	}

	function addBook(book) {
		var deferred = $q.defer();

		$http({
			  method: 'POST',
			  url: 'service/book/add',
			  data: book
			}).then(
				function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error(errResponse);
					deferred.reject(errResponse);
				});

		return deferred.promise;
	}

	function updateBook(book) {
		var deferred = $q.defer();

		$http({
			  method: 'POST',
			  url: 'service/book/update',
			  data: book
			}).then(
				function(response) {

					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error(errResponse);
					deferred.reject(errResponse);
				});

		return deferred.promise;
	}

	function deleteBook(book) {
		var deferred = $q.defer();
		$http({
			  method: 'POST',
			  url: 'service/book/delete',
			  data: book
			}).then(
				function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error(errResponse);
					deferred.reject(errResponse);
				});

		return deferred.promise;
	}
});