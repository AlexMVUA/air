<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/table.css"/>" title="Style">
		
		
		<title><spring:message code="registration.title"/></title>
	</head>
	<body>		
		
		<form:form modelAttribute="user" name="registrationPage" method="post" action="registrationConfirm" >
				
		<table align="center" border ="1" cellpadding="5" width="360">
					<tr>
						<th colspan="2">
							<h2 align="center"><spring:message code="registration.header"/></h2>
						 </th>
					</tr>				
			
			<tr>
				<td><spring:message code="registration.login"/></td>
				<td><form:input type="text" path="login"  />	
				<form:errors path="login" />			
				</td>
			</tr>
			<tr>
				<td><spring:message code="registration.password"/></td>
				<td><form:input type="password" path="password"/>
					<form:errors path="password" />
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="registration.password"/></td>
				<td><input type="password" name="passwordConfirmation"/>
							
				</td>
			</tr>
			<c:if test="${error != null }">
			 <tr>
				<td colspan="2" style="background-color: red; ; text-align:center; font-weight: bold">
				<br>${error}				
				</td>
			</tr>
			</c:if>						
			<tr>
				<td align="center">					
					<a href="index">Cancel</a>
				</td>
				<td><input type="submit" value="<spring:message code="registration.button.confirm"/>"/></td>
			</tr>
			
		</table>
		</form:form>	
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="footer.jsp"/>
	</div>
	</body>
</html>