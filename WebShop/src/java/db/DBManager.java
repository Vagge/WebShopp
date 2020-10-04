/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vagif
 */
public class DBManager
{
    private static DBManager instance = null;
    private Connection con = null;
    
    private static DBManager getInstance()
    {
        if(instance == null)
        {
            instance = new DBManager();
        }
        return instance;
    }
    
    private DBManager()
    {
        String url = "jdbc:mysql://localhost:3306/webshop";
        String username = "root";
        String password = "root";
        try 
        {
           con = DriverManager.getConnection (url,username,password);
        } catch (SQLException ex) {
           Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection()
    {
        return getInstance().con;
    }

    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        DBManager db = new DBManager();
    }
    
}
