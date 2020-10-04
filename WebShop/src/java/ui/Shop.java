/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bo.ItemHandler;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "Shop", urlPatterns = {"/Shop"})
public class Shop extends HttpServlet {

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
    {
        
        Gson gson = new Gson();
        String json="";
        PrintWriter out = null;
        try
        {
            HttpSession s = request.getSession();
            
            if(!((boolean)s.getAttribute("loggedIn")))//if user is not logged in return
            {
                return;
            }
            response.setContentType("application/json");
            out = response.getWriter();
            if(request.getParameter("search")!=null)//searchs for items from database, converts result to json and sends it back
            {

                ArrayList<ItemInfo> result = ItemHandler.getItemsWithSearchFor(request.getParameter("search"));
                json="[";
                for (int i = 0; i < result.size(); i++) 
                {
                    if(i==result.size()-1)
                    {
                        json = json + gson.toJson(result.get(i)) + "";
                    }
                    else
                    {
                        json = json + gson.toJson(result.get(i)) + ",";
                    }
                    
                } 
                json=json+"]";
                out.println(json);
            }
            else if(request.getParameter("addItem")!=null) //adds item to cart
            {
                HttpSession session = request.getSession();
                String name = request.getParameter("addItem");
                if(session.getAttribute("items")!=null) //converts items in cart to string seperated by "newItem" and stores it in session
                {
                    String items = (String) session.getAttribute("items");
                    items = items + " newItem " + name;
                    session.setAttribute("items", items);
                }
                else
                {
                    session.setAttribute("items", name);
                }
                out.println(session.getAttribute("items"));
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }        finally
        {
            if(out != null)
            {
                out.close();
            }
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
