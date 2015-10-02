<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="deleteflight.title" /></title>
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp" />
	</div>
	<h2 align="center">
		<spring:message code="deleteflight.header" />
	</h2>
	<form name="adminDeleteFlight" method="post"
		action="confirmRemoveFlight">

		<table align="center" border="1" cellpadding="5" width="360">
			<tr>
				<th width="120">Deleting timetable</th>
				<th width="120">Fields</th>
			</tr>

			<tr>
				<td align="center"><input type="hidden" name="flightId"
					value="${flight.id}" /> <spring:message code="flight.id" /></td>
				<td>${flight.id} - ${flight.name}</td>
			</tr>

			<tr>
				<td><spring:message code="flight.route" /></td>
				<td>
         			 ${flight.route.destinationFrom.city} (${flight.route.destinationFrom.airport}) -
         			  ${flight.route.destinationTo.city} (${flight.route.destinationFrom.airport})         			 
         			 </td>
			</tr>

			<tr>
				<td><spring:message code="flight.plane" /></td>
				<td>${flight.plane.model}. Staff quantity:
					${flight.plane.pilotNeeds + flight.plane.navigatorNeeds 
         			  + flight.plane.radiomanNeeds + flight.plane.stewardessNeeds}

				
			</tr>

			<tr>
				<td><spring:message code="flight.departure" /></td>

				<td><fmt:formatDate pattern="YYYY-dd-MM HH:mm"
						value="${flight.departure}" /></td>

			</tr>
			<tr>
				<td><spring:message code="flight.arrival" /></td>
				<td><fmt:formatDate pattern="YYYY-dd-MM HH:mm"
						value="${flight.arrival}" /></td>

			</tr>

			<tr>
				<td align="center"><a href="home">HOME</a></td>
				<td><input type="submit"
					value="<spring:message code="deleteflight.button.confirm"/>" /></td>
			</tr>

		</table>
	</form>

	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>