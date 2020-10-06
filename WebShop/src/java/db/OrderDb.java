/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bo.Item;
import bo.Order;
import bo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vagif
 */
public class OrderDb extends bo.Order
{
    private OrderDb(ArrayList<Item> items, User user, int orderID)
    {
        super(items, user, orderID);
    }
    
    public static Order getOrder(String username)
    {
        ArrayList<Item> items = new ArrayList<>();
        try
        {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM t_orders WHERE userName LIKE '" + username + "%';";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String name = rs.getString("itemName");
                int nrOfItems = rs.getInt("nrOfItems");
                items.add(new ItemDB(1, name, "", nrOfItems));
            }        
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return new Order(items, new User(username, ""), 1);
    }
    
    public static boolean placeOrder(ArrayList<String> items, String userName, int orderID)
    {
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = null;
        try
        {
            con = DBManager.getConnection();
            con.setAutoCommit(false);
            
            for (int i = 0; i < items.size(); i++) 
            {
                 st = con.prepareStatement("INSERT INTO t_orders (userName, itemName, nrOfItems) VALUES"
                         + "('" + userName+ "', '" + items.get(i) + "', '" + orderID + "');");
                 st.execute();
            }
            con.commit();
        } catch (SQLException ex) 
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            if(con!=null)
            {
                try
                {
                    con.rollback();
                }
                catch(SQLException ex2)
                {
                    Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex2);
                }
            }
        }
        finally
        {
            if(con!=null)
            {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        
        System.out.println(getOrder("vagge").getItems().get(0).getName());
    }
}
