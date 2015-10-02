<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="addplane.title"/></title>
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>
		<h2 align="center"><spring:message code="addplane.header"/></h2>
		<form:form modelAttribute="plane" name="addPlaneForm" method="post" action="confirmAddPlane">
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					Add plane		
				</th>
				<th width="120">
					Fields	
				</th>				
			</tr>
						
			<tr>
				<td align="center">			
					<spring:message code="plane.model"/>
				</td>

				<td><form:input type="text" path="model" />
				<form:errors path="model" />
				</td>
				
			</tr>
			<tr>
				<td><spring:message code="plane.pilot"/></td>
				<td><form:input type="text" path="pilotNeeds" id="pilotNeeds" />
				<form:errors path="pilotNeeds" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="plane.navigator"/></td>
				<td><form:input type="text" path="navigatorNeeds" id="navigatorNeeds" />
				<form:errors path="navigatorNeeds" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="plane.radioman"/></td>
				<td><form:input type="text" path="radiomanNeeds" id="radiomanNeeds" />
				<form:errors path="radiomanNeeds" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="plane.stewardess"/></td>
				<td><form:input type="text" path="stewardessNeeds" id="stewardessNeeds" />
				<form:errors path="stewardessNeeds" />
				</td>
			</tr>
			
			<tr>
				<td align="center">					
					<a href="home">HOME</a>
				</td>
				<td><input type="submit" value="<spring:message code="addplane.button.confirm"/>"/></td>
			</tr>
			
		</table>
		</form:form>	
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>