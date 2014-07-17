<%-- 
    Document   : search_result
    Created on : Mar 8, 2014, 11:44:12 PM
    Author     : Administrator

--%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="eqlist" class="java.util.LinkedList<PhysicsCalc.Equation>" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equation Finder Search Results</title>
    </head>
    <body>
        <h1>Search Results:</h1><br><br>
       <table id="resultTable" width="650x" border="2">
           <c:forEach var="item" items="${eqlist}">
              <tr>
                <td>id: &nbsp ${item.id}</td>
                <td>function: &nbsp ${item.funcstring}</td>
                <td><a href="calculator.jsp?eqid=${item.id}">Use equation</a></td>  
              </tr>
           </c:forEach>
        </table>
  
    </body>
</html>
