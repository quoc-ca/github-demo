/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.customersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author gtrun
 */
public class loginController extends HttpServlet { //login
   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        customersDAO customersDao = new customersDAO();
        List<Customer> list = customersDao.getAllCustomers();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mes = "";
        
        HttpSession session = request.getSession();
        if( customersDao.getCustomers(email, password) != null){
            if( customersDao.getCustomers(email, password).getRoleID() == 1){
                session.setAttribute("list", list);
            }
            
            
            session.setAttribute("customer", customersDao.getCustomers(email, password));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            mes = "Invalid password or username, please re enter!!!";
            request.setAttribute("mes", mes);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
