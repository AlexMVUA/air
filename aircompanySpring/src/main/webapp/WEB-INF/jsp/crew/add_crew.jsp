<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="addcrew.title"/></title>
		 
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>		
		<h2 align="center"><spring:message code="addcrew.header"/></h2>
		<form name="supervisorAddCrew" method="post" action="confirmAddCrew">
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					Add crew		
				</th>
				<th width="120">
					Fields	
				</th>				
			</tr>
			<!--<c:if test="${personBeanExist != null}">
				<tr>
					<td colspan="2" style="background-color: red; text-align: cender;font-weight: bold;">
						<spring:message code="addcrew.existbean"/>
						<br>
						<spring:message code="addcrew.person.exist"/>: 
						${personBeanExist.idPerson} ${personBeanExist.surname} ${personBeanExist.name} ${positionMap[personBeanExist.idPosition]} 
						<br> 
						<spring:message code="addcrew.flight.exist"/>:
						${flightBeanExist.idFlight} ${flightBeanExist.flightName} 
					</td>
				</tr>
			</c:if>	-->
			<tr>
				<td>
				<spring:message code="addcrew.flight.info"/>
				</td>
				<td>
					<select name="flightId" >
						<c:forEach var="item" items="${flightList}" >
							<option value="${item.id}" ${item.id == '1' ? 'selected="selected"' : ''}>
									${item.id} ${item.name} 
									${item.route.destinationFrom.country}, ${item.route.destinationFrom.city}
									 - ${item.route.destinationTo.country}, ${item.route.destinationTo.city}
									${item.departure} - ${item.arrival}</option>					
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><spring:message code="addcrew.person.info"/></td>
				<td>
					<select name="personId" >
						<c:forEach var="item" items="${personList}" >
							<option value="${item.id}" ${item.id == '1' ? 'selected="selected"' : ''}>${item.id} ${item.surname} ${item.name}  ${item.position.specialty}</option>					
						</c:forEach>
					</select>	
				</td>
			</tr>
						
			<tr>
				<td align="center">					
    				<a href="home">HOME</a>  
				</td>
				<td><input type="submit" value='<spring:message code="addcrew.button.confirm"/>'></td>
			</tr>
			
		</table>
		</form>	
		
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>