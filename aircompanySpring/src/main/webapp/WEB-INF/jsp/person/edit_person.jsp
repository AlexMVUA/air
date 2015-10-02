<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="<c:url value="/resources/datetimepicker/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/datetimepicker/jquery.datetimepicker.full.min.js"/>"></script>

<script type="text/javascript">
jQuery(function(){
jQuery('#birthdaypicker').datetimepicker({
	timepicker: false,	
	startDate:'1950/05/01',//or 1986/12/08	
    format:'Y-m-d 00:00:00',    
    lang:'ru',
    lang:'en'
});
});
 </script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datetimepicker/jquery.datetimepicker.css"/>">
<title><spring:message code="editperson.title" /></title>
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp" />
	</div>
	<h2 align="center">
		<spring:message code="editperson.header" />
	</h2>
	<form:form modelAttribute="person" name="supervisorEditPerson" method="post" action="confirmEditPerson">
		<table align="center" border="1" cellpadding="5" width="360">
			<tr>
				<th width="120">Edit person</th>
				<th width="120">Fields</th>
			</tr>

			<tr>
				<td><input type="hidden" name="personId" value="${personId}">
				<spring:message code="person.surname" /></td>
				<td><form:input type="text" path="surname" value="${(person.surname != null)? person.surname: personOriginal.surname}"/><br>				
				<c:if test="${person.surname != null and person.surname != personOriginal.surname}">
					${personOriginal.surname}<br>				
				</c:if>
				<form:errors path="surname" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.name" /></td>
				<td><form:input type="text" path="name" value="${(person.name != null)? person.name: personOriginal.name}"/><br>				
				<c:if test="${person.name != null and person.name != personOriginal.name}">
					${personOriginal.name}<br>				
				</c:if>
				<form:errors path="name" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.lastName" /></td>
				<td><form:input type="text" path="lastName" value="${(person.lastName != null)? person.lastName: personOriginal.lastName}"/><br>				
				<c:if test="${person.lastName != null and person.lastName != personOriginal.lastName}">
					${personOriginal.lastName}<br>				
				</c:if>
				<form:errors path="lastName" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="editperson.field.position" /></td>
				<td>
				
				<form:select path="position" id="id" >
       			  <form:option value="${personOriginal.position.id}">${personOriginal.position.specialty}</form:option>
      			  <c:forEach items="${positionList}" var="position">
         			 <form:option value="${position.id}" label="${position.specialty}"/>
        		  </c:forEach>
      			</form:select>
				<br>	<form:errors path="position" />	
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.birthday" /></td>
				<td>
				<form:input type="text" id="birthdaypicker" path="birthday" value="${personOriginal.birthday}"/><br>				
				<c:if test="${person.birthday != null and person.birthday != personOriginal.birthday}">
					${personOriginal.birthday}<br>				
				</c:if>
				<form:errors path="birthday" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.mobile" /></td>
				<td><form:input type="text" path="mobile" value="${(person.surname != null)? person.mobile: personOriginal.mobile}"/><br>				
				<c:if test="${person.mobile != null and person.mobile != personOriginal.mobile}">
					${personOriginal.mobile}<br>				
				</c:if>
				<form:errors path="mobile" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.email" /></td>
				<td><form:input type="text" path="email" value="${(person.email != null)? person.email: personOriginal.email}"/><br>				
				<c:if test="${person.email != null and person.email != personOriginal.email}">
					${personOriginal.email}<br>				
				</c:if>
				<form:errors path="email" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.experience" /></td>
				<td><form:input type="text" path="experience" value="${(person.surname != null)? person.experience: personOriginal.experience}"/><br>				
				<c:if test="${person.experience != null and person.experience != personOriginal.experience}">
					${personOriginal.experience}<br>				
				</c:if>
				<form:errors path="experience" />				
				</td> 
					
			</tr>

			<tr>
				<td align="center"><a href="home">HOME</a></td>
				<td><input type="submit"
					value="<spring:message code="editperson.button.confirm"/>" /></td>
			</tr>

		</table>
	</form:form>
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>