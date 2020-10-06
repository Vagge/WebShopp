/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import db.OrderDb;
import java.util.ArrayList;

/**
 *
 * @author vagif
 */
public class Order 
{
    private ArrayList<Item> items;
    private User user;
    private int orderId;
    
    public Order(ArrayList<Item> items, User user, int orderID)
    {
        this.items = items;
        this.user = user;
        this.orderId = orderId;
    }
    
    public static boolean placeOrder(ArrayList<String> items, String userName, int orderID)
    {
        return OrderDb.placeOrder(items, userName, orderID);
    }
    
    public static Order getOrder(String userName)
    {
        return OrderDb.getOrder(userName);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    
}
