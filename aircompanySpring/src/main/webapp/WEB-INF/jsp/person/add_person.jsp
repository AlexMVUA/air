<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    format: 'Y-d-m 00:00:00',    
    mask:'9999/19/39', 
    lang:'en'
});
});


 </script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datetimepicker/jquery.datetimepicker.css"/>">


<title><spring:message code="addperson.title" /></title>
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp" />
	</div>
	<h2 align="center">
		<spring:message code="addperson.header" />
	</h2>
	<form:form modelAttribute="person" name="supervisorAddPerson" method="post" 
		action="confirmAddPerson">
		<table align="center" border="1" cellpadding="5" width="360">
			<tr>
				<th width="120">Add person</th>
				<th width="120">Fields</th>
			</tr>

			<tr>
				<td align="center"><spring:message code="person.surname" /></td>

				<td><form:input type="text" path="surname" /><br>
				<form:errors path="surname" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.name" /></td>
				<td><form:input type="text" path="name" /><br>
				<form:errors path="name" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.lastName" /></td>
				<td><form:input type="text" path="lastName" /><br>
				<form:errors path="lastName" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="addperson.field.position" /></td>
				<td>
				
				<form:select path="position" id="id">
       			 <form:option value="1">Select Position: </form:option>
      			  <c:forEach items="${positionList}" var="position">
         			 <form:option value="${position.id}">${position.specialty}</form:option>
        		  </c:forEach>
      			</form:select>
      			<br>	<form:errors path="position" />		
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.birthday" /></td>
				<td><form:input type="text" id="birthdaypicker" path="birthday" value="" /><br>
				<form:errors path="birthday" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.mobile" /></td>
				<td><form:input type="text" path="mobile" /><br>
				<form:errors path="mobile" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.email" /></td>
				<td><form:input type="text" path="email" /><br>
				<form:errors path="email" />				
				</td>
			</tr>
			<tr>
				<td><spring:message code="person.experience" /></td>
				<td><form:input type="text" path="experience" value="0" /><br>
				<form:errors path="experience" />				
				</td>
			</tr>

			<tr>
				<td align="center"><a href="home">HOME</a></td>
				<td><input type="submit" id="submitAdd"
					value="<spring:message code="addperson.button.confirm"/>" /></td>
			</tr>

		</table>
	</form:form>
	
	
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>