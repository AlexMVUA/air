<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="homeadmin.title" /></title>
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="header.jsp" />
	</div>
	<h2 align="center">
		<spring:message code="homeadmin.header" />
	</h2>
	
<div>
	<table align="center" border="1" cellpadding="5" width="360">
		<tr>
			<th width="120"><spring:message code="homeadmin.view" /></th>
			<th width="120"><spring:message code="homeadmin.add" /></th>
			<th width="120"><spring:message code="homeadmin.search" /></th>
		</tr>
		<tr>
			<td align="center">
				<form name="adminFlightView" method="get" action="viewAllFlights">
					<input type="hidden" name="currentPage" value="1" /> <input
						type="submit"
						value='<spring:message code="homeadmin.button.view"/>'>
				</form>
			</td>
			<td align="center">
				<form name="adminAddFlight" method="get" action="addFlight">
					<input type="submit"
						value='<spring:message code="homeadmin.button.add"/>'>
				</form>
			</td>
			<td align="center">
				<form name="searchFlight" method="GET" action="searchFlights">
					<input type="text" name="searchString" /> <input type="hidden"
						name="currentPage" value="1" /> <input type="submit"
						value='<spring:message code="homeadmin.button.search"/>'>
				</form>
			</td>
		</tr>

	</table>

	<table align="center" border="1" cellpadding="5" width="360">
		<tr>
			<th width="180"><spring:message
					code="homesupervisor.view.planes" /></th>
			<th width="180"><spring:message code="homesupervisor.add.plane" />
			</th>
		</tr>
		<tr>
			<td align="center">
				<form name="adminPlanesView" method="get" action="viewPlanes">
					<input type="submit"
						value='<spring:message code="homesupervisor.button.view"/>'>
				</form>
			</td>
			<td align="center">
				<form name="adminAddPlane" method="get" action="addPlane">
					<input type="submit"
						value='<spring:message code="homesupervisor.button.add"/>'>
				</form>
			</td>
		</tr>
	</table>

	<table align="center" border="1" cellpadding="5" width="360">
		<tr>
			<th width="120"><spring:message code="homeadmin.view.routes" />
			</th>
			<th width="120"><spring:message code="homeadmin.add.route" /></th>
			<th width="120"><spring:message code="homeadmin.search.routes" />
			</th>
		</tr>
		<tr>
			<td align="center">
				<form name="adminRoutesView" method="get" action="viewRoutes">
					<input type="submit"
						value='<spring:message code="homeadmin.button.view"/>'>
				</form>
			</td>
			<td align="center">
				<form name="adminAddRoute" method="get" action="addRoute">
					<input type="submit"
						value='<spring:message code="homeadmin.button.add"/>'>
				</form>
			</td>
			<td align="center">
				<form name="adminSearchRoute" method="get" action="searchRoutes">
				<input type="text" name="searchString" /> <input type="hidden"
						name="currentPage" value="1" /> 
					<input type="submit"
						value='<spring:message code="homeadmin.button.search"/>'>
				</form>
			</td>
		</tr>
	</table>



	<table align="center" border="1" cellpadding="5" width="360">
		<tr>
			<th width="180"><spring:message
					code="homesupervisor.view.destinations" /></th>
			<th width="180"><spring:message
					code="homesupervisor.add.destination" /></th>
		</tr>
		<tr>
			<td align="center">
				<form name="adminDestinationsView" method="get"
					action="viewDestinations">
					<input type="submit"
						value='<spring:message code="homesupervisor.button.view"/>'>
				</form>
			</td>
			<td align="center">
				<form name="adminAddDestination" method="get"
					action="addDestination">
					<input type="submit"
						value='<spring:message code="homesupervisor.button.add"/>'>
				</form>
			</td>
		</tr>

	</table>
</div>	
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>