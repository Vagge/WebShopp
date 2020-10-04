<%-- 
    Document   : index
    Created on : Sep 28, 2020, 9:57:53 PM
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
        <form action="WebShop" method="post">
            <table border="1">
                <tbody>
                    <tr>
                        <td> Username </td>
                        <td> <input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td> Password </td>
                        <td> <input type="password" name="password" /> </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
