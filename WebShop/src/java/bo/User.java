/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import db.UserDB;

/**
 *
 * @author vagif
 */
public class User 
{
    private final String username;
    private final String password;
    
    public User(String username, String password)
    {
        this.password = password;
        this.username = username;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    static public boolean identifyUser(String username, String password)
    {
        return UserDB.identifyUser(username, password);
    }
}
