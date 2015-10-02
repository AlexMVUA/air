<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="deletedestination.title"/></title>
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>
		<h2 align="center"><spring:message code="deletedestination.header"/></h2>
		<form name="supervisorDeleteDestination" method="post" action="confirmRemoveDestination">
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					Deleting destination		
				</th>
				<th width="120">
					Fields	
				</th>				
			</tr>
						
			<tr>
				<td align="center">		
					<input type="hidden" name="destinationId" value="${destination.id}"/>
					<spring:message code="destination.country"/>						
				</td>
				<td><c:out value="${destination.country}"></c:out></td>
			</tr>
			<tr>
				<td><spring:message code="destination.city"/></td>
				<td>${destination.city}</td>
			</tr>
			<tr>
				<td><spring:message code="destination.airport"/></td>
				<td>${destination.airport}</td>
			</tr>
			
			
			<tr>
				<td align="center">					
					<a href="home">HOME</a>
				</td>
				<td><input type="submit" value='<spring:message code="deletedestination.button.confirm"/>'></td>
			</tr>
			
		</table>
		</form>	
		
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>