<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- <%@ taglib prefix="ctag" uri="http://pagination/tag"%> -->
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="flights.title"/></title>   
	 
</head>
<body>
<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp"/>
</div>

<div align="center">
<h3><spring:message code="flights.header"/></h3>
      <table border="1" style="width:70% ">		
		<tr>			
						<th width="5%" class="routes">#</th>
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
				<td>${route.count+(currentPage-1)*10}</td>
				
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
    <c:out value="${searchString}"/>
    <p>
    	<a href="home">HOME</a>
    </p>
    
    <c:url var="searchUri" value="/aircompanyController?command=FLIGHT_SEARCH&&currentPage=##" />
	
   <!--  <ctag:display maxLinks="5" currentPage="${currentPage}" totalPages="${totalPages}" uri="${searchUri}" searchString="${searchString}" /> -->
</div>

<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>
