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
import model.Customer;

/**
 *
 * @author gtrun
 */
public class updateCustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer cus = (Customer) session.getAttribute("customer");
        //Cho admin
        if(cus.getCustomerID() == 1){
               //String id_raw = 
            
            
            
            
                request.getRequestDispatcher("details-account.jsp").forward(request, response);
                
        }else{
        
        
        
        
        // Cho user
        
        int id = cus.getCustomerID();
        String customerName = request.getParameter("customerName");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        // Đoạn này đang sai contruster
        Customer customer = new Customer(id, customerName, sex, email, phone, password, id);
        customersDAO customerDao = new customersDAO();
        if (customerDao.checkEmail(email) == true) {
            if (customerDao.updateCustomer(customer) > 0) {
                request.setAttribute("mesUpdate", "Update Success");
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("details-account.jsp").forward(request, response);
            } else {
                request.setAttribute("mesUpdate", "Update false");
                request.getRequestDispatcher("details-account.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mesUpdate", "Email Exist");
            request.getRequestDispatcher("details-account.jsp").forward(request, response);
        }
        request.getRequestDispatcher("details-account.jsp").forward(request, response);
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Customer cus = (Customer) session.getAttribute("customer");
        

        int id = cus.getCustomerID();
        String customerName = request.getParameter("customerName");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        // Đoạn này đang sai contruster
        Customer customer = new Customer(id, customerName, sex, email, phone, password, id);
        customersDAO customerDao = new customersDAO();
        if (customerDao.checkEmail(email) == true) {
            if (customerDao.updateCustomer(customer) > 0) {
                request.setAttribute("mesUpdate", "Update Success");
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("details-account.jsp").forward(request, response);
            } else {
                request.setAttribute("mesUpdate", "Update false");
                request.getRequestDispatcher("details-account.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mesUpdate", "Email Exist");
            request.getRequestDispatcher("details-account.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
