<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 

<html>
<head>
    <title><spring:message code="destinations.title"/></title>   
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/table.css"/>" title="Style">
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp"/>
	</div>

<div align="center">
<h3><spring:message code="destinations.header"/></h3>
     <table border="1" style="width:60% ">		
		<tr>
			<th width="5%" class="destinations">#</th>
			<th width="20%" class="destinations"><spring:message code="destination.country"/></th>
			<th width="25%" class="destinations"><spring:message code="destination.city"/></th>
			<th width="25%" class="destinations"><spring:message code="destination.airport"/></th>
			<th width="25%" class="destinations"><spring:message code="flights.doaction"/></th>				
		</tr>		
		<c:forEach var="item" items="${destinationList}" varStatus="destination">
			<c:choose>
				<c:when test="${destination.count mod 2 eq 0}">
			<tr bgcolor="#D3DFEE" >
				</c:when>
				<c:when test="${destination.count mod 2 eq 1}">
			<tr bgcolor="#FFFFF" >
				</c:when>
			</c:choose>
				<td>${destination.count}</td>				
				<td>${item.country}</td>
				<td>${item.city}</td>
				<td>${item.airport}</td>
				<td>
				<a href="editDestination?destinationId=${item.id}"><spring:message code="flights.action.edit"/></a>
				/
				<a href="removeDestination?destinationId=${item.id}"><spring:message code="flights.action.delete"/></a>
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
