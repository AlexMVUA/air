<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="crews.title"/></title>   
	 
</head>
<body>
<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp"/>
</div>

<div align="center">
<h3><spring:message code="crews.header"/></h3>
	
    <table border="1" style="width:70%">		
		<tr>			
						<th width="5%" class="crews">#</th>
						<th width="5%" class="crews"><spring:message code="crew.id"/></th>
						<th width="5%" class="crews"><spring:message code="flight.id"/></th>
						<th width="40%" class="crews"><spring:message code="flight.flightName"/></th>
						<th width="5%" class="crews"><spring:message code="person.id"/></th>
						<th width="10%" class="crews"><spring:message code="person.surname"/></th>
						<th width="10%" class="crews"><spring:message code="person.name"/></th>
						<th width="10%" class="crews"><spring:message code="position.specialty"/></th>
						<th width="10%" class="crews"><spring:message code="crews.doaction"/></th>
		</tr>	
		<c:forEach var="item" items="${crewList}" varStatus="crew" >
			<c:choose>
				<c:when test="${crew.count mod 2 eq 0}">
			<tr bgcolor="#D3DFEE" >
				</c:when>
				<c:when test="${crew.count mod 2 eq 1}">
			<tr bgcolor="#FFFFF" >
				</c:when>
			</c:choose>
				<td>${crew.count}</td>
				<td>${item.id}</td>
				<td>${item.flight.route.id}</td>
				<td>${item.flight.route.destinationFrom} - ${item.flight.route.destinationTo}</td>
				<td>${item.person.id}</td>
				<td>${item.person.surname}</td>
				<td>${item.person.name}</td>
				<td>${item.person.position.specialty}</td>
				<td>
				<a href="editCrew?crewId=${item.id}"><spring:message code="crews.action.edit"/></a>
				/
				<a href="removeCrew?crewId=${item.id}"><spring:message code="crews.action.delete"/></a>
				</td>
				
			</tr>
		</c:forEach>       
    </table>
    
    <p>
    	<a href="home">HOME</a>
    </p>
    
</div>

<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>
