<%-- 
    Document   : shop
    Created on : Sep 30, 2020, 7:22:40 PM
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
        <a href="shop.jsp"></a>
        <form class="search" action="">
            <input type="text" placeholder="Search for item..." name="search" class="searchBar">
            <input type="button" onclick="handleSearch(this.form)" class="searchBt" value="Search">  
        </form>
        
        <table style='width: 60%' id="searchTable">
        </table>
        
        <script>
            var url = document.URL;
            function handleSearch(form)
            {
                xhttp = new XMLHttpRequest();
                xhttp.open("GET", "Shop?search=" + form.search.value, true);
                xhttp.onload = function() //gets search result from servler and places it innerhtml of table
                {
                    if (xhttp.status == 200)
                    {
			var item = xhttp.responseText;
                        item = JSON.parse(item);
                        var result="<tr><th>Name</th><th>Description</th><th>In stock</th><th>Add item</th></tr>";
                        for (var i = 0; i < item.length; i++) 
                        {
                            result += "<tr> <td>" + item[i].name + "</td>";
                            result += "<td>" + item[i].desc+ "</td>";;
                            result += "<td id='item" + i +"'>" + parseInt(item[i].nrOfItems) + "</td>";
                            result += "<td> <button type='button' id='";
                            result += "button" + i;
                            result += "'>Add</button></td>"; //adds button
                            result += "</tr> ";
                        }
                        document.getElementById("searchTable").innerHTML = result;
                        for (let i = 0; i < item.length; i++) //for every item places add button
                        {
                            document.getElementById("button"+i).addEventListener('click',function ()
                                                                            {
                                                                                if(item[i].nrOfItems>0)
                                                                                {
                                                                                    
                                                                                
                                                                                 xhttp2 = new XMLHttpRequest();
                                                                                 xhttp2.open("GET", "Shop?addItem=" + item[i].name, true);
                                                                                 xhttp2.onload = function() //adds item to cart by sending item name to servlet
                                                                                 {
                                                                                     if(xhttp2.status == 200)
                                                                                     {
                                                                                         
                                                                                         item[i].nrOfItems = item[i].nrOfItems - 1;
                                                                                         document.getElementById("item"+i).innerHTML = item[i].nrOfItems;
                                                                                     }
                                                                                     else
                                                                                    {
                                                                                        document.getElementById("errorMsg").value = xhttp2.statusText;
                                                                                    }
                                                                                 }
                                                                                 xhttp2.send();
                                                                             }});
                        }              
                    }
                    else
                    {
	      		document.getElementById("errorMsg").value = xhttp.statusText;
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
        
        th
        {
            background-color: #4CAF50;
            color: white;
        }
        
        .searchBt
        {
            font-size: 15px;
            width: 5%; 
            background-color: #807e7a;
            padding: 2px;
            margin-top: 10px;
        }
        
        button
        {
            width: 30%;
            color: white;
            padding: 2px;
            font-size: 15px;
            background-color: #4CAF50;
        }
    </style>
</html>
