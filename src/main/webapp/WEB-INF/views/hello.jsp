<%-- 
    Document   : home
    Created on : Aug 21, 2018, 7:41:12 PM
    Author     : astan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Page</title>
    </head>
    <body>
        <h1>Hello <%= request.getSession().getAttribute("username").toString() %> !</h1>
    </body>
</html>
