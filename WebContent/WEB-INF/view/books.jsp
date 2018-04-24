<%@ include file="/WEB-INF/view/resources.jsp"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);
%>
<!DOCTYPE html>
<html>

<head>
<title>Library App</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">

</head>

<body ng-app="rootApp">

	<div id="wrapper">
		<div id="header">
			<h2>Library App</h2>
		</div>
	</div>

	<div id="form" ng-app="formApp">
		<div ng-controller="formControl">
			<div class="page-body">

				<button class="btn btn-success btn-m" ng-click="showForm()"
					style="margin-bottom: 10px;">Add Book</button>

			</div>
		</div>
	</div>

	<div ng-app="controllerApp">
		<div id="controller" ng-controller="bookController as bctrl">

			<h2>Books</h2>
			<table border="1">
				<thead>
					<tr>
						<th>No</th>
						<th>Id</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Description</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="book in bctrl.books">
						<td>{{ $index +1 }}</td>
						<td><span ng-bind="book.id"></span></td>
						<td><span ng-bind="book.name"></span></td>
						<td><span ng-bind="book.author"></span></td>
						<td><span ng-bind="book.description"></span></td>
						<td>
							<button class="btn btn-sm btn-primary" type="button"
								class="btn btn-primary btn-sm" ng-click="showForm(book)">Edit</button>
							<button class="btn btn-sm btn-danger" type="button"
								ng-click="deleteBook(book)">Delete</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
