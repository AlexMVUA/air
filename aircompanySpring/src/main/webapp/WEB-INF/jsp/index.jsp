<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!Doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Aircompany</title>   
  
</head>
<body>

<h2 align="center"><spring:message code="index.header" /></h2>
	<div align="center" >
		<form id="loginForm" action="login" method="post" >                    
                    <table>
                        <tr>
                            <td><spring:message code="index.login"/></td>
                            <td><input type="text" name="login" required="required"></td>
                        </tr>
                        <tr>
                            <td><spring:message code="index.password"/></td>
                            <td><input type="password"  name="password" required="required"></td>
                        </tr>
                        <tr>
                            
                            <td colspan="2" style="color: green; font-weight: bold; text-align: center;">${success }</td>
                        </tr>
                    </table>
                     <input type="submit" name="submit" value='<spring:message code= "index.button.submit"/>'>                 
         </form>
    <p style="color: red; font-weight: bold; text-align: center;">     
         <a href="registration">Registration</a>
    </p>     
	</div>
	<p style="color: red; font-weight: bold; text-align: center;">
		${infoString}
	</p>
	<div style="text-align: center; vertical-align: text-bottom;">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>