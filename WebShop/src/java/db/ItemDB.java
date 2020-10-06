/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vagif
 */
public class ItemDB extends bo.Item
{
    public static List searchItems(String searchFor)
    {
        ArrayList<ItemDB> items = new ArrayList<>();
        try
        {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM t_item WHERE name LIKE '" + searchFor + "%';";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                int nrOfItems = rs.getInt("nrOfItems");
                items.add(new ItemDB(id, name, desc, nrOfItems)); 
            }        
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return items;
    }
    
    ItemDB(int id, String name, String desc, int nrOfItems)
    {
        super(id,name,desc,nrOfItems);
    }
}
