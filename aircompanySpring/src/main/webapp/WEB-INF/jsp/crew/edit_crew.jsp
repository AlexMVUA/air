<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="editcrew.title"/></title>
		 
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>		
		<h2 align="center"><spring:message code="editcrew.header"/></h2>
		<form name="supervisorEditCrew" method="post" action="confirmEditCrew">
		<input type="hidden" name="crewId" value="${crew.id}"/>
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					Edit crew		
				</th>
				<th width="120">
					Fields	
				</th>				
			</tr>
				
			<tr>
				<td><spring:message code="editcrew.flight.info"/></td>
				<td>
					<select name="flightId" >
						<c:forEach var="item" items="${flightList}" >
							<option value="${item.id}" ${item.id == flight.id ? 'selected="selected"' : ''}>
									${item.id} ${item.name} 
									${item.route.destinationFrom.country}, ${item.route.destinationFrom.city}
									 - ${item.route.destinationTo.country}, ${item.route.destinationTo.city}
									${item.departure} - ${item.arrival}</option>					
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><spring:message code="editcrew.person.info"/></td>
				<td>
					<select name="personId" >
						<c:forEach var="item" items="${personList}" >
							<option value="${item.id}" ${item.id == crew.person.id ? 'selected="selected"' : ''}>${item.id} ${item.surname} ${item.name}  ${item.position.specialty}</option>					
						</c:forEach>
					</select>	
				</td>
			</tr>
						
			<tr>
				<td align="center">					
    				<a href="home">HOME</a>  
				</td>
				<td><input type="submit" value='<spring:message code="editcrew.button.confirm"/>'></td>
			</tr>
			
		</table>
		</form>	
		
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>