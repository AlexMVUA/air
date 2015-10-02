<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--  <%@ taglib prefix="ctag" uri="http://pagination/tag"%>-->
 

<html>
<head>
    <title><spring:message code="planes.title"/></title>   
	 
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp"/>
	</div>

<div align="center">
<h3><spring:message code="planes.header"/></h3>
     <table border="1" style="width:60% ">		
		<tr>
			<th width="5%" class="planes">#</th>
			<th width="25%" class="planes"><spring:message code="plane.model"/></th>
			<th width="10%" class="planes"><spring:message code="plane.pilot"/></th>
			<th width="10%" class="planes"><spring:message code="plane.navigator"/></th>
			<th width="10%" class="planes"><spring:message code="plane.radioman"/></th>
			<th width="10%" class="planes"><spring:message code="plane.stewardess"/></th>
			<th width="30%" class="flights"><spring:message code="flights.doaction"/></th>				
		</tr>				
		<c:forEach var="item" items="${planeList}" varStatus="plane">
			<c:choose>
				<c:when test="${plane.count mod 2 eq 0}">
			<tr bgcolor="#D3DFEE" >
				</c:when>
				<c:when test="${plane.count mod 2 eq 1}">
			<tr bgcolor="#FFFFF" >
				</c:when>
			</c:choose>
				<td>${plane.count}</td>				
				<td>${item.model}</td>
				<td>${item.pilotNeeds}</td>
				<td>${item.navigatorNeeds}</td>
				<td>${item.radiomanNeeds}</td>
				<td>${item.stewardessNeeds}</td>
				<td>
				<a href="editPlane?planeId=${item.id}"><spring:message code="flights.action.edit"/></a>
				/
				<a href="removePlane?planeId=${item.id}"><spring:message code="flights.action.delete"/></a>
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
