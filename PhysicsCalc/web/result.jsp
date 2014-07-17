<%-- 
    Document   : result
    Created on : Jan 27, 2014, 10:58:31 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="calculation" class="PhysicsCalc.Calculation" scope="request"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculation Result Page</title>
    </head>
        <body>
            <p>The result of the calculation was ${calculation.resultval}</p>
            <form action="GraphicsController" method="post" >
                <input type="submit" name="submit" value="Launch Graphical Demonstration" />
            </form>
        </body>
</html>
