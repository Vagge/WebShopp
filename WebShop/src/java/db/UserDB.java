/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;  
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vagif
 */
public class UserDB extends bo.User
{
    private UserDB(String username, String password)
    {
        super(username, password);
    }
    
    public static boolean identifyUser(String username, String password) 
    {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT users FROM users WHERE users = '" + username + "'"
                + " AND password = '" + password + "';"; 
        try 
        {
            Connection con = DBManager.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        System.out.println(UserDB.identifyUser("vagge", "vagge"));
    }
}
