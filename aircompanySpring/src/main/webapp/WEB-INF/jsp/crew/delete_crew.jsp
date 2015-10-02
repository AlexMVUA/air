<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="deletecrew.title"/></title>
		 
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>		
		<h2 align="center"><spring:message code="deletecrew.header"/></h2>
		<form name="supervisorDeleteCrew" method="post" action="confirmRemoveCrew">
		<table align="center" border ="1" cellpadding="5" >
			<tr>
				<th width="120">
					Delete crew		
				</th>
				<th >
					Fields	
				</th>				
			</tr>
				
			<tr>
				<td><spring:message code="deletecrew.flight.info"/>
				<input type="hidden" name="crewId" value="${crew.id}"/>
				</td>
				<td>
					${crew.id} ${crew.flight.name} 
									${crew.flight.route.destinationFrom.country}, ${crew.flight.route.destinationFrom.city}
									 - ${crew.flight.route.destinationTo.country}, ${crew.flight.route.destinationTo.city}
									${crew.flight.departure} - ${crew.flight.arrival}
				</td>
			</tr>
			<tr>
				<td><spring:message code="deletecrew.person.info"/></td>
				<td>
					${crew.person.id} ${crew.person.surname} ${crew.person.name} ${crew.person.position.specialty}
				</td>
			</tr>
						
			<tr>
				<td align="center">					
    				<a href="home">HOME</a>  
				</td>
				<td><input type="submit" value='<spring:message code="deletecrew.button.confirm"/>'></td>
			</tr>
			
		</table>
		</form>	
		
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>