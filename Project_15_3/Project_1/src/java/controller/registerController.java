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
import model.Customer;

/**
 *
 * @author gtrun
 */
public class registerController extends HttpServlet {
   
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        customersDAO customerDao = new customersDAO();
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //String rePassword = request.getParameter("rePassword");
        
        if( customerDao.checkEmail(email) == true){
            // Đoạn này đang sai contruster
            Customer customers = new Customer(username, email, email, email, password, 0);
            customerDao.addCustomer(customers);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            request.setAttribute("mesRegis", "Email Exis!!! Please enter new email!!!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        
        
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
