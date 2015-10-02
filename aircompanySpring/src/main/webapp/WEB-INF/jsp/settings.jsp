<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<c:choose>
            <c:when test="${sessionScope.userValue != null}">
                <form action="aircompanyController" method="get" >
                    <input type="hidden" name="command" value="LOGOUT_COMMAND"/>
                    
                    <p>
                    	${userValue.login}, 
                    	<a href=""><spring:message code="index.logout.link"/></a>
                    	<input type="submit" value='<spring:message code="index.button.submit"/>'>
                    </p>
                </form>
            </c:when>
            <c:otherwise>
                <ul>
                    <li><a href="index.jsp">HOME</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
        
     <br>            
     
     <form action="aircompanyController" method="post">
            <input type="hidden" name="command" value="CHANGE_LANGUAGE_COMMAND"/>
            <input type="hidden" name="page" value="${page}" />
            <p><select id="language" name="language" onchange="this.form.submit()">
                    <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
                    <option value="ru_RU" ${language == 'ru_RU' ? 'selected' : ''}>Русский</option>
                </select>
            </p>
        </form>
        
</body>
</html>