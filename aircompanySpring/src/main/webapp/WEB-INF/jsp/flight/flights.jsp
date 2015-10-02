<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--  <!-- <%@ taglib prefix="ctag" uri="http://pagination/tag"%>-->-->
 

<html>
<head>
    <title><spring:message code="flights.title"/></title>   
	 
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp"/>
	</div>

<div align="center">
<h3><spring:message code="flights.header"/></h3>
     <table border="1" style="width:60% ">		
		<tr>
			<th width="5%" class="flight">#</th>			
			<th width="5%" class="flight"><spring:message code="flight.id"/></th>
			<th width="8%" class="flight"><spring:message code="flight.flightName"/></th>
			<th width="10%" class="flight"><spring:message code="flight.plane"/></th>
			<th width="25%" class="flight"><spring:message code="flight.route"/></th>
			<th width="18%" class="flight"><spring:message code="flight.departure"/></th>
			<th width="18%" class="flight"><spring:message code="flight.arrival"/></th>
			<th width="11%" class="flight"><spring:message code="flights.doaction"/></th>				
		</tr>				
		<c:forEach var="item" items="${flightList}" varStatus="entry">
			<c:choose>
				<c:when test="${entry.count mod 2 eq 0}">
			<tr bgcolor="#D3DFEE" >
				</c:when>
				<c:when test="${entry.count mod 2 eq 1}">
			<tr bgcolor="#FFFFF" >
				</c:when>
			</c:choose>
				<td>${entry.count}</td>				
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.plane}</td>
				<td>${item.route}</td>
				<td><fmt:formatDate pattern="YYYY-dd-MM HH:mm" value="${item.departure}"/></td>
				<td><fmt:formatDate pattern="YYYY-dd-MM HH:mm" value="${item.arrival}"/> </td>
				<td>
				<a href="editFlight?flightId=${item.id}"><spring:message code="flights.action.edit"/></a>
				/
				<a href="removeFlight?flightId=${item.id}"><spring:message code="flights.action.delete"/></a>
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
