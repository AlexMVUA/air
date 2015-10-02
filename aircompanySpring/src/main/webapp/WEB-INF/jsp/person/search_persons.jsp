<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- <%@ taglib prefix="ctag" uri="http://pagination/tag"%>-->
 
 

<html>
<head>
    <title><spring:message code="persons.title"/></title>   
	 
</head>
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp"/>
	</div>

<div align="center">
<h3><spring:message code="persons.header"/></h3>

<p align="center">
 Search parameter: <c:out value="${searchString}"/>
</p>
     <table border="1" style="width:80% ">		
		<tr>
			<th width="5%" class="persons">#</th>
			<th width="15%" class="persons"><spring:message code="person.surname"/></th>
			<th width="15%" class="persons"><spring:message code="person.name"/></th>
			<th width="15%" class="persons"><spring:message code="person.lastName"/></th>
			<th width="5%" class="persons"><spring:message code="person.positionId"/></th>
			<th width="10%" class="persons"><spring:message code="person.birthday"/></th>
			<th width="10%" class="persons"><spring:message code="person.mobile"/></th>
			<th width="10%" class="persons"><spring:message code="person.email"/></th>
			<th width="5%" class="persons"><spring:message code="person.experience"/></th>
			<th width="10%" class="persons"><spring:message code="persons.doaction"/></th>					
		</tr>
		<c:forEach var="item" items="${personList}" varStatus="person" >
			<c:choose>
				<c:when test="${person.count mod 2 eq 0}">
			<tr bgcolor="#D3DFEE" >
				</c:when>
				<c:when test="${person.count mod 2 eq 1}">
			<tr bgcolor="#FFFFF" >
				</c:when>
			</c:choose>				
				<td>${person.count+(currentPage-1)*10}</td>
				<td><c:out value="${item.surname}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.lastName}" /></td>
				<td><c:out value="${item.position.specialty}" /></td>
				<td><c:out value="${item.birthday}" /></td>
				<td><c:out value="${item.mobile}" /></td>
				<td><c:out value="${item.email}" /></td>
				<td><c:out value="${item.experience}" /></td>
				<td>
				<a href="editPerson?personId=${item.id}"><spring:message code="persons.action.edit"/></a>
				/
				<a href="removePerson?personId=${item.id}"><spring:message code="persons.action.delete"/></a>
				</td>				
			</tr>
		</c:forEach>        
    </table>
    
    <p>
    	<a href="home">HOME</a>
    </p>
    <p>   		
   		<c:url var="searchUri" value="/aircompanyController?command=PERSON_VIEW_ALL&&currentPage=##" />
    	<!--<ctag:display maxLinks="5" currentPage="${currentPage}" totalPages="${totalPages}" uri="${searchUri}" />-->
    </p>
</div>

<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>
