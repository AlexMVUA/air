<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="homesupervisor.title"/></title>
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="header.jsp"/>
		</div>
	
		<h2 align="center"><spring:message code="homesupervisor.header"/></h2>
		
		<table align="center" border ="1" cellpadding="5" width="500" style="caption-side:top; " >
			<caption>CREW</caption>
			<tr>
				<td align="center">
				<form name="supervisorCrewsView" method="get" action="viewCrews">
					<input type="submit" value="crew view">
				</form>				
				</td>
				<td align="center">
				<form name="supervisorAddCrew" method="get" action="addCrew">
					<input type="submit" value='<spring:message code="homesupervisor.button.add"/>'>
				</form>				
				</td>
				<td align="center">
				<form name="supervisorCrewsViewByPerson" method="get" action="viewCrewsByPerson">					
					<select name="personId" >						
						<c:forEach var="item" items="${personList}" >
							<option value="${item.id}" ${item.id == '1' ? 'selected="selected"' : ''}>${item.surname} ${item.name}  ${item.position.specialty}</option>					
						</c:forEach>
					</select>
					<input type="submit" value='<spring:message code="homesupervisor.button.view.crew.person"/>'>
				</form>				
				</td>
				<td align="center">
				<form name="supervisorCrewsViewByFlight" method="get" action="viewCrewsByRoute">					
					<select name="flightId" >
						<c:forEach var="item" items="${flightList}" >
							<option value="${item.id}" ${item.id == '1' ? 'selected="selected"' : ''}>${item.destinationFrom.city} - ${item.destinationTo.city}</option>					
						</c:forEach>
					</select>
					<input type="submit" value='<spring:message code="homesupervisor.button.view.crew.route"/>'>
				</form>				
				</td>
			</tr>			
		</table>
		
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					<spring:message code="homesupervisor.viewpersons"/>		
				</th>
				<th width="120">
					<spring:message code="homesupervisor.add"/>	
				</th>
				<th width="120">
					<spring:message code="homesupervisor.search"/>		
				</th>
			</tr>			
			<tr>
				<td align="center">
				<form name="supervisorPersonsView" method="get" action="viewPersons">
					<input type="hidden" name="currentPage" value="1"/>
					<input type="submit" value='<spring:message code="homesupervisor.button.view"/>'>
				</form>				
				</td>
				<td align="center">
				<form name="supervisorAddPerson" method="get" action="addPerson">
					<input type="submit" value='<spring:message code="homesupervisor.button.add"/>'>
				</form>				
				</td>
				<td align="center">
				<form name="searchPerson" method="get" action="searchPersons">
					<input type="text" name="searchString" />
					<input type="submit" value='<spring:message code="homesupervisor.button.search"/>'>
				</form>				
				</td>
			</tr>			
		</table>
				
		
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="footer.jsp"/>
	</div>
	</body>
</html>