<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="editflight.title" /></title>

<script type="text/javascript"
	src="<c:url value="/resources/datetimepicker/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/datetimepicker/jquery.datetimepicker.full.min.js"/>"></script>

<script type="text/javascript">
jQuery(function(){
	 jQuery('#datetime_departure').datetimepicker({	  
	  step:20,
	  format:'Y-m-d H:i:00',
	
	  minDate:'0',
	 
	  onSelect:function( ct ){
	   this.setOptions({
	    maxDate:jQuery('#datetime_arrival').val()?jQuery('#datetime_arrival').val():false,
	   })
	  },
	 	
	 });
	 jQuery('#datetime_arrival').datetimepicker({		
		step:20,
		format:'Y-m-d H:i:00',
		
		
	  onSelect:function( ct ){
	   this.setOptions({
	    minDate:jQuery('#datetime_departure').val()?jQuery('#datetime_departure').val():false,
	   })
	  },
	  
	 });
});

 </script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datetimepicker/jquery.datetimepicker.css"/>">
<body>
	<div style="text-align: right; vertical-align: text-top;">
		<jsp:include page="../header.jsp" />
	</div>

	<h2 align="center">
		<spring:message code="editflight.header" />
	</h2>
	<form:form modelAttribute="flight" name="adminEditFlight" method="post"
		action="confirmEditFlight">
		<input type="hidden" name="flightId" value="${flightId }"/>
 		<table align="center" border="1" cellpadding="5" width="360">
			<tr>
				<th width="120">Edit flight</th>
				<th width="120">Fields</th>
			</tr>

			<tr>
				<td><spring:message code="flight.flightName" /></td>
				<td><form:input type="text" path="name" value="${(flight.name != null)? flight.name: flightOriginal.name}"/><br>				
				<c:if test="${flight.name != null and flight.name != flightOriginal.name}">
					${flightOriginal.name}<br>				
				</c:if>
					<form:errors path="name" /></td>
			</tr>

			<tr>
				<td><spring:message code="flight.route" /></td>
				<td><form:select path="route" id="id">				
						<form:option value="${flightOriginal.route.id}">
							${flightOriginal.route.destinationFrom.city} (${flightOriginal.route.destinationFrom.airport}) -
         			  ${flightOriginal.route.destinationTo.city} (${flightOriginal.route.destinationFrom.airport}) 
						
						</form:option>
						<c:forEach items="${routeList}" var="route">
							<form:option value="${route.id}">
         			 ${route.destinationFrom.city} (${route.destinationFrom.airport}) -
         			  ${route.destinationTo.city} (${route.destinationFrom.airport})         			 
         			 </form:option>
						</c:forEach>
					</form:select> <br> <form:errors path="route" /></td>
			</tr>

			<tr>
				<td><spring:message code="flight.plane" /></td>
				<td><form:select path="plane" id="id">
						<form:option value="${flightOriginal.plane.id}">
								${flightOriginal.plane.model}. Staff quantity:
         			  			${flightOriginal.plane.pilotNeeds + flightOriginal.plane.navigatorNeeds
         			  			 + flightOriginal.plane.radiomanNeeds + flightOriginal.plane.stewardessNeeds}  
						</form:option>
						<c:forEach items="${planeList}" var="plane">
							<form:option value="${plane.id}">
         						 ${plane.model}. Staff quantity:
         			  			${plane.pilotNeeds + plane.navigatorNeeds + plane.radiomanNeeds + plane.stewardessNeeds}         			 
         			 </form:option>
						</c:forEach>
					</form:select> <br> <form:errors path="plane" /></td>
			</tr>

			<tr>
				<td><spring:message code="flight.departure" /></td>
				<td><form:input id="datetime_departure" type="text"
						path="departure" value="${flightOriginal.departure}" /> <form:errors path="departure" /></td>
			</tr>
			<tr>
				<td><spring:message code="flight.arrival" /></td>
				<td><form:input id="datetime_arrival" type="text"
						path="arrival" value="${flightOriginal.arrival}" /> <form:errors path="arrival" /></td>
			</tr>

			<tr>
				<td align="center"><a href="home">HOME</a></td>
				<td><input type="submit"
					value="<spring:message code="editflight.button.confirm"/>" /></td>
			</tr>

		</table>
	</form:form>
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>