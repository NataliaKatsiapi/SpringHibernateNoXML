<%-- 
    Document   : insert
    Created on : 30 Ιουν 2019, 7:08:02 μμ
    Author     : kat26
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style href="D:\AFDEMP\Web\SpringJPA\src\main\webapp\WEB-INF\style.css" type="stylesheet"></style>
        <!--link href="style.css" type='text/css'-->
    

    </head>
    <body>
        <h1>Complete Fields</h1>
        <form:form method="POST" modelAttribute="employee">
            Name: <form:input path="name" id="name"/><br>
            Joining date:<form:input path="joiningDate" id="date" width="35"/><br>
            Salary: <form:input path="salary" id="salary" width="35"/><br>
            SSN: <form:input path="ssn"  width="35" id="ssn"/><br>
            <p><form:button type="submit" value="Submit"/></p>
        </form:form>
            
    </body>
</html>
