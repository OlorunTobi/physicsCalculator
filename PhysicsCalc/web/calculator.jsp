<%-- 
    Document   : calculator
    Created on : Jan 27, 2014, 10:56:42 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="calculation" class="PhysicsCalc.Calculation" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
        <body>
            <form action="Calculate" method="post" >
                <br>Velocity (initial): <input name="vzero" value="<jsp:getProperty name="calculation" property="vzero"/>" />
                <br>Acceleration: <input name="accel" value="<jsp:getProperty name="calculation" property="accel" />" />
                <br>Time: <input name="timeval" value="<jsp:getProperty name="calculation" property="timeval" />" />
                <br><input type="submit" name="submit" value="Calculate" />
            </form>
                <br><br><br>
            <form action="VarInit" method="post" >
                <input type="submit" name="submit2" value="Find Equations" />
            </form>
            </body>
</html>
