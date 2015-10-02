<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="editroute.title" /></title>
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp" />
	</div>
	<h2 align="center">
		<spring:message code="editroute.header" />
	</h2>
	<form name="adminEditRoute" method="post" action="confirmEditRoute">
		<input type="hidden" name="routeId" value="${route.id}" />
		<table align="center" border="1" cellpadding="5" width="360">
			<tr>
				<th width="120">Edit route</th>
				<th width="120">Fields</th>
			</tr>

			
			<tr>
				<td><spring:message code="route.departure" /></td>
				<td><select name="destinationFromId">
						<c:forEach var="item" items="${destinationList}">
							<option value="${item.id}"
								${item.id == route.destinationFrom.id ? 'selected="selected"' : ''}>
								${item.country} ${item.city} ${item.airport}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><spring:message code="route.arrival" /></td>
				<td><select name="destinationToId">
						<c:forEach var="item" items="${destinationList}">
							<option value="${item.id}"
								${item.id == route.destinationTo.id ? 'selected="selected"' : ''}>
								${item.country} ${item.city} ${item.airport}</option>
						</c:forEach>
				</select></td>
			</tr>
			
			<tr>
				<td align="center"><a href="home">HOME</a></td>
				<td><input type="submit"
					value='<spring:message code="editroute.button.confirm"/>'></td>
			</tr>

		</table>
	</form>

	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>