<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="deleteperson.title"/></title>
	</head>
	<body>
		<div style="text-align: right; vertical-align: text-top;">
			<jsp:include page="../header.jsp"/>
		</div>
		<h2 align="center"><spring:message code="deleteperson.header"/></h2>
		<form name="supervisorDeletePerson" method="post" action="confirmRemovePerson">
		<table align="center" border ="1" cellpadding="5" width="360">
			<tr>
				<th width="120">
					Delete person		
				</th>
				<th width="120">
					Fields	
				</th>				
			</tr>
						
			<tr>
				<td>				
					
					<input type="hidden" name="personId" value="${person.id}"/>
					<spring:message code="person.surname"/>
				</td>

				<td>${person.surname}</td>
			</tr>
			<tr>
				<td><spring:message code="person.name"/></td>
				<td>${person.name}</td>
			</tr>
			<tr>
				<td><spring:message code="person.lastName"/></td>
				<td>${person.lastName}</td>
			</tr>			
			<tr>
				<td><spring:message code="deleteperson.field.position"/></td>
				<td>${person.position.specialty}</td>
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
				<td align="center">					
					<a href="home">HOME</a>
				</td>
				<td><input type="submit" value="<spring:message code="deleteperson.button.confirm"/>"/></td>
			</tr>
			
		</table>
		</form>	
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
	</body>
</html>