<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="personal.title"/></title>
	</head>
	<body>		
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="header.jsp"/>
	</div>
	
		<h2 align="center"><spring:message code="personal.header"/></h2>
		<form name="registrationPage" method="post" action="aircompanyController">
		<table align="center" border ="1" cellpadding="5" width="360">
									
			<tr>
				<td>				
					<input type="hidden" name="command" value="PERSONAL_INFO_EDIT"/>					
					<spring:message code="person.surname"/>					
				</td>
				<td>${person.surname}		
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.name"/></td>
				<td>${person.name}</td>
			</tr>
			<tr>
				<td><spring:message code="person.lastname"/></td>
				<td>${person.lastName}</td>
			</tr>			
			<tr>
				<td><spring:message code="editperson.field.position"/></td>
				<td>${positionMap[person.idPosition]}</td>
			</tr>
			<tr>
				<td><spring:message code="person.birthday"/></td>
				<td>${person.birthday}</td>
			</tr>
			<tr>
				<td><spring:message code="person.mobile"/></td>
				<td>${person.mobile}</td>				
			</tr>
			<tr>
				<td><spring:message code="person.email"/></td>
				<td>${person.email}</td>				
			</tr>
			<tr>
				<td><spring:message code="person.experience"/></td>
				<td>${person.experience}</td>
			</tr>
			<tr>
				<td><spring:message code="registration.login"/></td>
				<td>${userValue.login}</td>
			</tr>
			<tr>
				<td><spring:message code="registration.password"/></td>
				<td>${userValue.password}</td>
			</tr>
			
						
			<tr>
				<td align="center">					
					<c:choose>
					<c:when test="${userValue.userRole == 'ADMINISTRATOR'}">
						<a href="aircompanyController?command=HOME_PAGE_ADMIN">HOME</a> 
					</c:when>
					<c:when test="${userValue.userRole == 'SUPERVISOR'}">
						<a href="aircompanyController?command=HOME_PAGE_SUPERVISOR">HOME</a> 
					</c:when>
					<c:when test="${userValue.userRole == 'GUEST'}">
						<a href="aircompanyController?command=HOME_PAGE_GUEST">HOME</a> 
					</c:when>
					</c:choose>
					
				</td>
				<%-- <td><input type="submit" value="<spring:message code="registration.button.confirm"/>"/></td>--%>
				<td align="center"><input type="submit" value="Edit"/></td>
			</tr>
			
		</table>
		</form>	
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="footer.jsp"/>
	</div>
	</body>
</html>