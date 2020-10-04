/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vagif
 */
@WebServlet(name = "shoppingCart", urlPatterns = {"/shoppingCart"})
public class shoppingCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            if(request.getParameter("viewCart")!=null) 
            {
                viewCart(request, response);
            }
            else if(request.getParameter("removeItem")!=null)
            {
                removeItem(request, response);
            }
    }
    
    private void viewCart(HttpServletRequest request, HttpServletResponse response) //loads items from session to cart
            throws ServletException, IOException
    {
        response.setContentType("application/json");
        PrintWriter out = null;
        try
        {
            
        
            HttpSession session = request.getSession();
            out = response.getWriter();
            if(session.getAttribute("items")!=null)
            {
                String json;
                Gson gson = new Gson();
                String[] items = ((String)session.getAttribute("items")).split("newItem"); //gets all items from session, converts them to json ands sends to webpage
                json="[";
                for (int i = 0; i < items.length; i++) 
                {
                    if(i==items.length-1)
                    {
                        json = json + gson.toJson(items[i]) + "";
                    }
                    else
                    {
                        json = json + gson.toJson(items[i]) + ",";
                    }
                } 
                json=json+"]";
                out.println(json);
            } 
        }
        finally
        {
            if(out!=null)
            {
                out.close();
            }
        }
    }
    
    private void removeItem(HttpServletRequest request, HttpServletResponse response)
             //removes specified item from cart
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try
        {     
            HttpSession session = request.getSession();
            out = response.getWriter();
            if(session.getAttribute("items")!=null)
            {        
                String[] items = ((String)session.getAttribute("items")).split("newItem"); //converts string of item names to arraylist and removes specified item
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < items.length; i++) 
                {
                    list.add(items[i]);
                }
                for (int i = 0; i < list.size(); i++) 
                {
                    if(list.get(i).equals(request.getParameter("removeItem")))
                    {
                        list.remove(i);
                    }
                }
                String newResult = "";
                for (int i = 0; i < list.size(); i++) //builds new string and places to session
                {
                    newResult += list.get(i) + " newItem ";    
                }
                session.setAttribute("items", newResult);
                out.println(newResult); 
            } 
        }
        catch (IOException ex) {
            Logger.getLogger(shoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }        
        finally
        {
            if(out!=null)
            {
                out.close();
            }
        }
    }
    
    public static void main(String[] args)
    {
        String s = "sam2 newItem sam0 newItem sam3";
         String[] items = s.split("newItem");
                    for (int i = 0; i < items.length; i++) 
                    {
                        System.out.println(items[i]);
                    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
