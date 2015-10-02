<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <title><spring:message code="crews.title"/></title>   
	 
</head>
<body>
<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="header.jsp"/>
</div>

<div align="center">
<h3><spring:message code="crews.header"/></h3>
	
     <table border="1" style="width: 90%">		
		<tr>			
						<th width="5%" class="crews">#</th>
						<th width="5%" class="crews"><spring:message code="crew.idCrew"/></th>						
						<th width="10%" class="crews"><spring:message code="flight.flightName"/></th>
						<th width="10%" class="crews"><spring:message code="plane.model"/></th>
						<th width="25%" class="crews"><spring:message code="flight.idFlightFrom"/></th>
						<th width="25%" class="crews"><spring:message code="flight.idFlightTo"/></th>
						<th width="10%" class="crews"><spring:message code="flight.departureTime"/></th>
						<th width="10%" class="crews"><spring:message code="flight.arrivalTime"/></th>
		</tr>		
		<c:forEach var="item" items="${crewList}" varStatus="crew">		
			<c:choose>
				<c:when test="${crew.count mod 2 eq 0}">
			<tr bgcolor="#D3DFEE" >
				</c:when>
				<c:when test="${crew.count mod 2 eq 1}">
			<tr bgcolor="#FFFFF" >
				</c:when>
			</c:choose>
				<td>${crew.count}</td>
				<td>${item.idCrew}</td>							
				<td>${flightMap[item.idFlight]["flightName"]}</td>
				<td>${planeMap[flightMap[item.idFlight]["idPlane"]]}</td>
				<td>${destinationMap[flightMap[item.idFlight]["idFlightFrom"]].city}
				(${destinationMap[flightMap[item.idFlight]["idFlightFrom"]].country}, 
				 ${destinationMap[flightMap[item.idFlight]["idFlightFrom"]].airport})
				</td>
				<td>${destinationMap[flightMap[item.idFlight]["idFlightTo"]].city} 
				(${destinationMap[flightMap[item.idFlight]["idFlightFrom"]].country}, 
				 ${destinationMap[flightMap[item.idFlight]["idFlightFrom"]].airport})				
				</td>
				<td>${flightMap[item.idFlight]["departureTime"]}</td>
				<td>${flightMap[item.idFlight]["arrivalTime"]}</td>
			</tr>
		</c:forEach>        
    </table>
    
    
</div>

<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>
