<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%        
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", -1);
%>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="<c:url value="/resources/js/service.js" />"></script>
<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.9.0.js"></script>
<script src="<c:url value="/resources/js/bookcontroller.js" />"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>