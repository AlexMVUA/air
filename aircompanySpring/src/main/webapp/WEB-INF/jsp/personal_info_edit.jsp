<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="registration.title"/></title>
	</head>
	<body>		
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="header.jsp"/>
	</div>
		<h2 align="center"><spring:message code="registration.header"/></h2>
		<form name="personalInfoEdit" method="post" action="aircompanyController">		
			<input type="hidden" name="command" value="PERSONAL_INFO_EDIT_CONFIRM"/>
		<table align="center" border ="1" cellpadding="5" width="360">
									
			<tr>
				<td><spring:message code="person.surname"/>
					
				</td>

				<td><input type="text" name="surname"  value="${person.surname}"/>
				<input type="hidden" name="idPerson" value="${person.idPerson}"/>
				<c:choose>
				
					<c:when test="${not empty errorInputMap.surname or empty person.surname}">
						<img align="bottom" title="${errorInputMap.surname}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.surname}">
						<img align="bottom" title="${errorInputMap.surname}" src="img/ok.jpg">
					</c:when>
				</c:choose>
				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.name"/></td>
				<td><input type="text" name="name" value="${person.name}"/>
				<c:choose>
					<c:when test="${not empty errorInputMap.name or empty person.name}">
						<img align="bottom" title="${errorInputMap.name}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.name}">
						<img align="bottom" title="${errorInputMap.name}" src="img/ok.jpg">
					</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.lastname"/></td>
				<td><input type="text" name="lastName" value="${person.lastName}"/>
				<c:choose>
					<c:when test="${not empty errorInputMap.lastName or empty person.lastName}">
						<img align="bottom" title="${errorInputMap.lastName}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.lastName}">
						<img align="bottom" title="${errorInputMap.lastName}" src="img/ok.jpg">
					</c:when>
				</c:choose>
				</td>
			</tr>			
			<tr>
				<td><spring:message code="editperson.field.position"/></td>
				<td><input type="hidden" name="idPosition" value="${person.idPosition}"/>
				${positionMap[person.idPosition]}
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.birthday"/></td>
				<td><input type="text" name="birthday" value="${person.birthday}"/>
				<c:choose>
					<c:when test="${not empty errorInputMap.birthday or empty person.birthday}">
						<img align="bottom" title="${errorInputMap.birthday}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.birthday}">
						<img align="bottom" title="${errorInputMap.birthday}" src="img/ok.jpg">
					</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.mobile"/></td>
				<td><input type="text" name="mobile" value="${person.mobile}"/>
				<c:choose>
					<c:when test="${not empty errorInputMap.mobile or empty person.mobile}">
						<img align="bottom" title="${errorInputMap.mobile}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.mobile}">
						<img align="bottom" title="${errorInputMap.mobile}" src="img/ok.jpg">
					</c:when>
				</c:choose>
				</td>
				
			</tr>
			<tr>
				<td><spring:message code="person.email"/></td>
				<td><input type="text" name="email"  value="${person.email}"/>
				<c:choose>
					<c:when test="${not empty errorInputMap.email or empty person.email}">
						<img align="bottom" title="${errorInputMap.email}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.email}">
						<img align="bottom" title="${errorInputMap.email}" src="img/ok.jpg">
					</c:when>
				</c:choose>
				</td>
				
			</tr>
			<tr>
				<td><spring:message code="person.experience"/></td>
				<td><input type="text" name="experience" value="${person.experience}"/>
				<c:choose>
					<c:when test="${not empty errorInputMap.experience or empty person.experience}">
						<img align="bottom" title="${errorInputMap.experience}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.experience}">
						<img align="bottom" title="${errorInputMap.experience}" src="img/ok.jpg">
					</c:when>
				</c:choose>
									
				</td>
			</tr>
			<tr>
				<td><spring:message code="registration.login"/></td>
				<td>
				<input type="hidden" name="login" value="${userValue.login}"/>
				${userValue.login}</td>
			</tr>
			<tr>
				<td><spring:message code="registration.password"/></td>
				<td><input type="text" name="password" value="${userValue.password}"/>
					<c:choose>
					<c:when test="${not empty errorInputMap.password}">
						<img align="bottom" title="${errorInputMap.password}" src="img/error.jpg">
					</c:when>
					<c:when test="${empty errorInputMap.password}">
						<img align="bottom" title="${errorInputMap.password}" src="img/ok.jpg">
					</c:when>
					</c:choose>
					
				</td>
			</tr>						
			<tr>
				<td align="center">					
					<a href="index.jsp">Cancel</a>
				</td>				
				<td>
				
					<input type="submit" value="<spring:message code="registration.button.confirm"/>"/>
				
				</td>
					
			</tr>
			
		</table>
		</form>
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="footer.jsp"/>
	</div>
	</body>
</html>