<%-- 
    Document   : GraphicApp
    Created on : Mar 10, 2014, 8:27:53 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <h1>Pendulum graphic</h1>
        <script src="https://www.java.com/js/deployJava.js"></script>
        <script>
            var attributes = {code:'pendulumrogram.PendulumProgram.class',
                archive:'JPendulum.jar', width:710, height:540};
            var parameters = { fontSize:16, permissions:'all-permissions' };
            var version = '1.7.0_51';
            deployJava.runApplet(attributes, parameters, version);
        </script>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Applet</title>
    </head>
    <body>
    </body>
</html>
