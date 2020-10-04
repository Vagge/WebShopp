/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author vagif
 */
public class UserHandler 
{
    public static boolean identifyUser(String username, String password)
    {
        return User.identifyUser(username, password);
    }
    
    public static void main(String[] args)
    {
        System.out.println(UserHandler.identifyUser("vagge", "vagge"));
    }
}
