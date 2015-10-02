<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--  <%@ taglib prefix="ctag" uri="http://pagination/tag"%>-->
 


<html>
<head>
    <title><spring:message code="routes.title"/></title>   
	
</head>
<body>
<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp"/>
</div>

<div align="center">
<h3><spring:message code="routes.header"/></h3>
     <table border="1" style="width:70% ">		
		<tr>			
						<!-- <th width="5%" class="routes">#</th> -->
						<th width="25%" class="routes"><spring:message code="route.departure"/></th>						
						<th width="25%" class="routes"><spring:message code="route.arrival"/></th>
						<th width="35%" class="routes"><spring:message code="routes.doaction"/></th>
						<th width="10%" class="routes"><spring:message code="flights.doaction"/></th>
					
		</tr>
		<c:forEach var="item" items="${routeList}" varStatus="route">
			<c:choose>
				<c:when test="${route.count mod 2 eq 0}">
			<tr bgcolor="#D3DFEE" >
				</c:when>
				<c:when test="${route.count mod 2 eq 1}">
			<tr bgcolor="#FFFFF" >
				</c:when>
			</c:choose>				
				<!--  <td>${route.count+(currentPage-1)*10}</td>-->
				
				<td>
				
				${item.destinationFrom.country} ${item.destinationFrom.city} ${item.destinationFrom.airport}
				</td>
				<td>
				${item.destinationTo.country} ${item.destinationTo.city} ${item.destinationTo.airport}
				</td>
				<td colspan="1">				
				<a href="addFlightForRoute?routeId=${item.id}">Add flight for this route </a><br>
								
				</td>
				<td>
				<a href="editRoute?routeId=${item.id}"><spring:message code="flights.action.edit"/></a>
				/
				<a href="removeRoute?routeId=${item.id}"><spring:message code="flights.action.delete"/></a>
				</td>
				
			</tr>
		</c:forEach>        
    </table>
    
    <p>
    	<a href="home">HOME</a>
    </p>
    <p>
   		<!--  
   		<c:url var="searchUri" value="/aircompanyController?command=FLIGHT_VIEW_ALL&&currentPage=##" />
    	<ctag:display maxLinks="5" currentPage="${currentPage}" totalPages="${totalPages}" uri="${searchUri}" />
    	-->
    </p>
</div>

<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>
