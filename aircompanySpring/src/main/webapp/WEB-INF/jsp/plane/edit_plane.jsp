<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="editplane.title"/></title>
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>		
		<h2 align="center"><spring:message code="editplane.header"/></h2>
		<form:form  modelAttribute="plane" name="editPlaneForm" method="post" action="confirmEditPlane">
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					Edit plane		
				</th>
				<th width="120">
					Fields	
				</th>				
			</tr>
						
			<tr>
				<td align="center">
					<input type="hidden" name="planeId" value="${planeId}"/>
					<spring:message code="plane.model"/>							
				</td>
				<td><form:input type="text" path="model" value="${(plane.model != null)? plane.model: planeOriginal.model}"/><br>				
				<c:if test="${plane.model != null and plane.model != planeOriginal.model}">
					${planeOriginal.model}<br>				
				</c:if>
				<form:errors path="model" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="plane.pilot"/></td>
				<td><form:input type="text" path="pilotNeeds" value="${(plane.model != null)? plane.pilotNeeds: planeOriginal.pilotNeeds}"/><br>				
				<c:if test="${plane.model != null and plane.pilotNeeds != planeOriginal.pilotNeeds}">
					${planeOriginal.pilotNeeds}<br>				
				</c:if>
				<form:errors path="pilotNeeds" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="plane.navigator"/></td>
				<td><form:input type="text" path="navigatorNeeds" value="${(plane.model != null)? plane.navigatorNeeds: planeOriginal.navigatorNeeds}"/><br>				
				<c:if test="${plane.model != null and plane.navigatorNeeds != planeOriginal.navigatorNeeds}">
					${planeOriginal.navigatorNeeds}<br>				
				</c:if>
				<form:errors path="navigatorNeeds" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="plane.radioman"/></td>
				<td><form:input type="text" path="radiomanNeeds" value="${(plane.model != null)? plane.radiomanNeeds: planeOriginal.radiomanNeeds}"/><br>				
				<c:if test="${plane.model != null and plane.radiomanNeeds != planeOriginal.radiomanNeeds}">
					${planeOriginal.radiomanNeeds}<br>				
				</c:if>
				<form:errors path="radiomanNeeds" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="plane.stewardess"/></td>
				<td><form:input type="text" path="stewardessNeeds" value="${(plane.model != null)? plane.stewardessNeeds: planeOriginal.stewardessNeeds}"/><br>				
				<c:if test="${plane.model != null and plane.stewardessNeeds != planeOriginal.stewardessNeeds}">
					${planeOriginal.stewardessNeeds}<br>				
				</c:if>
				<form:errors path="stewardessNeeds" />
				</td>
			</tr>
			
			<tr>
				<td align="center">					
					<a href="home">HOME</a>
				</td>
				<td><input type="submit" value='<spring:message code="editplane.button.confirm"/>'></td>
			</tr>
			
		</table>
		</form:form>	
		
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>