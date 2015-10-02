<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/table.css"/>" title="Style">

<title>Insert title here</title>
</head>
<body>
<div>
<div >
	<div style="text-align: center;background-color: red; color: white;font-size:24; font-weight: bold;">
	
		<p>
			${error}
			
		</p>
	
	</div>
	<div style="text-align: center;background-color: green;color: white;font-size:24; font-weight: bold;">
	
		<p>
			${success}
		</p>
	
	</div>
</div>
		
	<div align="right">
		<p><a href="home">HOME</a></p>
	</div>
	<c:url var="logoutUrl" value="/logout" />
	<form method="post" action="${logoutUrl}">
		<input type="submit" value="Log out" width="40" /> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
	<br>
	<c:choose>
		<c:when test="${param.locale ne null }">
			<c:set var="language" value="${param.locale }" />
		</c:when>
		<c:otherwise>
			<c:set var="language" value="${cookie.aircompanyLocaleCookie.value }" />
		</c:otherwise>
	</c:choose>

	<form action="changeLanguage" method="POST">
		<p>
			<select name="locale" onchange="submit()">

				<option value="en"
					${fn:containsIgnoreCase(language, 'en')  ? 'selected' : ''}>En</option>
				<option value="ru"
					${fn:containsIgnoreCase(language, 'ru') ? 'selected' : ''}>Ru</option>
			</select>
		</p>
	</form>
</div>
</body>
</html>