<%-- 
    Document   : shoppingCart
    Created on : Oct 4, 2020, 2:42:46 PM
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
        <form class="search" action="">
            <input type="button" onclick="placeOrder(this.form)" class="searchBt" value="Order">  
        </form>
        <script>
            viewCart();
            
            function placeOrder(form)
            {
                xhttp = new XMLHttpRequest();
                xhttp.open("GET", "shoppingCart?placeOrder", true);
                xhttp.onload = function()
                {
                    if (xhttp.status == 200)
                    {
                        document.getElementById("searchTable").innerHTML = "Items Ordered!";
                    }
                    else
                    {
                        document.getElementById("errorMsg").value = xhttp2.statusText;
                    }
                }
                xhttp.send();
            }
            
            function viewCart()
            {
                xhttp = new XMLHttpRequest();
                xhttp.open("GET", "shoppingCart?viewCart", true);
                xhttp.onload = function()
                {
                    if (xhttp.status == 200)
                    {
			var item = xhttp.responseText;                
                        item = JSON.parse(item);
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
                        for (let i = 0; i < item.length; i++) //for every item places a button to remove item
                        {
                            document.getElementById("button"+i).addEventListener('click',function () //removes item from session and cart
                                                                            {
                                                                                 xhttp2 = new XMLHttpRequest();
                                                                                 xhttp2.open("GET", "shoppingCart?removeItem=" + item[i].name, true);
                                                                                 xhttp2.onload = function()
                                                                                 {
                                                                                     if(xhttp2.status == 200)
                                                                                     { 
                                                                                        console.log(xhttp2.responseText);
                                                                                        document.getElementById("item"+i).innerHTML = "";
                                                                                     }
                                                                                     else
                                                                                    {
                                                                                        document.getElementById("errorMsg").value = xhttp2.statusText;
                                                                                    }
                                                                                 }
                                                                                 xhttp2.send();
                                                                             });
                        }     
                    }
                    else
                    {
                        
                    }
                }
                xhttp.send();
            }
        </script>
    </body>
    <style>
        ul 
       {
          list-style-type: none;
          margin: 0;
          padding: 0;
          overflow: hidden;
          background-color: #333;
        }

        li {
          float: left;
        }

        li a
        {
          display: block;
          color: white;
          text-align: center;
          padding: 14px 16px;
          text-decoration: none;
        }
         .searchBar
         {
             font-size: 20px;
         }

        li a:hover 
        {
          background-color: #111;
        }

        
        tr:hover {background-color: #f5f5f5;}
        tr:nth-child(even) {background-color: #f2f2f2;}
        
        th,td
        {
            border-bottom: 1px solid #ddd;
            padding: 15px;
            text-align: left;
        }
    </style>
</html>
