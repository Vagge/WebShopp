<%-- 
    Document   : myOrders
    Created on : Oct 6, 2020, 1:55:43 AM
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
        <ul>
            <li><a href="shop.jsp">Home</a></li>
            <li><a href="shoppingCart.jsp">Shopping Cart</a></li>
            <li><a href="myOrders.jsp">My Orders</a></li>
            <li><a href="loggedOut.jsp">Logout</a></li>         
        </ul>
        <table style='width: 60%' id="searchTable">
                
        </table>
        <script>
            
            viewOrders();
            
            function viewOrders()
            {
                xhttp = new XMLHttpRequest();
                xhttp.open("GET", "myOrders?viewOrders", true);
                xhttp.onload = function()
                {
                    if (xhttp.status == 200)
                    {
			var item = xhttp.responseText;                
                        item = JSON.parse(item);
                        console.log(item);
                        var result="";
                        for (var i = 0; i < item.length; i++) //gets item result from servlet and places it in inner html of result table
                        {
                            result += "<tr id='item" + i + "'> <td>" + item[i] + "</td>";
                            result += "<td> <button type='button' id='";
                            result += "button" + i;
                            result += "'>Remove</button></td>";
                            result += "</tr> ";
                        }
                        document.getElementById("searchTable").innerHTML = result;
                    }
                }
                xhttp.send();
            }    
        </script>  
    </body>
</html>
