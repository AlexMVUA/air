<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="editdestination.title"/></title>
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>		
		<h2 align="center"><spring:message code="editdestination.header"/></h2>
		<form:form modelAttribute="destination" name="supervisorEditDestination" method="post" action="confirmEditDestination">
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					Edit destination		
				</th>
				<th width="120">
					Fields	
				</th>				
			</tr>
						
			<tr>
				<td align="center">				
					<input type="hidden" name="destinationId" value="${destinationId}"/>
					
					<spring:message code="destination.country"/>							
				</td>
				<td><form:input type="text" path="country" value="${(destination.country != null)? destination.country: destinationOriginal.country}"/> 				
				<c:if test="${destination.country != null and destination.country != destinationOriginal.country}">
					${destinationOriginal.country}<br>
				
				</c:if>
				<form:errors path="country" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="destination.city"/></td>
				<td><form:input type="text" path="city" value="${(destination.city != null)? destination.city: destinationOriginal.city}"/><br>
				<c:if test="${destination.city != null and destination.city != destinationOriginal.city}">
					${destinationOriginal.city}<br>
				
				</c:if>
				<form:errors path="city" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="destination.airport"/></td>
				<td><form:input type="text" path="airport" value="${(destination.airport != null)? destination.airport: destinationOriginal.airport}"/><br>
				<c:if test="${destination.airport != null and destination.airport != destinationOriginal.airport}">
					${destinationOriginal.airport}<br>
				
				</c:if>
				<form:errors path="airport" />
				</td>
			</tr>
						
			<tr>
				<td align="center">					
					<a href="home">HOME</a>
				</td>
				<td><input type="submit" value='<spring:message code="editdestination.button.confirm"/>'></td>
			</tr>
			
		</table>
		</form:form>	
		
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>