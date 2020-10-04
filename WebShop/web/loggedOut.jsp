<%-- 
    Document   : loggedOut
    Created on : Oct 4, 2020, 11:10:10 PM
    Author     : vagif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Logged out</h1>
    </body>
    <script>
        xhttp = new XMLHttpRequest();
        xhttp.open("GET", "Logout", true); //logs out user
        xhttp.send();
    </script>
</html>
