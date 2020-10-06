/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;

/**
 *
 * @author vagif
 */
public class OrderHandler 
{  
    public static boolean placeOrder(ArrayList<String> items, String userName, int orderID)
    {
        return Order.placeOrder(items, userName, orderID);
    }  
    
     public static Order getOrder(String username)
    {
        return Order.getOrder(username);
    }  
     
     public static void main(String[] args)
     {
         System.out.println(getOrder("vagge").getItems().get(0).getName());
     }
    
}
