/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gtrun
 */
public class customersDAO extends DBContext {

    public customersDAO() {
        super();
    }

    //Hàm getAllUser 
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT [CustomerID]\n"
                + "      ,[CustomerName]\n"
                + "      ,[Sex]\n"
                + "      ,[Email]\n"
                + "      ,[Phone]\n"
                + "      ,[Password]\n"
                + "      ,[RoleID]\n"
                + "      ,[Address]\n"
                + "  FROM [dbo].[Customers]\n";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String customerName = rs.getString("CustomerName");
                String sex = rs.getString("Sex");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String password = rs.getString("Password");
                int roleID = rs.getInt("RoleID");
                String addr = rs.getString("Address");

                // Customer customers = new Customer(id, customerName, sex, Email, phone, Password, roleID);
                Customer customers = new Customer(id, roleID,
                        customerName, sex, email, phone, password, addr);
                list.add(customers);
            }

        } catch (SQLException ex) {
            Logger.getLogger(customersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    //Hàm getUserBy ID 
    public Customer getCustomersByID(int id) {
        String sql = "SELECT [CustomerID]\n"
                + "      ,[CustomerName]\n"
                + "      ,[Sex]\n"
                + "      ,[Email]\n"
                + "      ,[Phone]\n"
                + "      ,[Password]\n"
                + "      ,[RoleID]\n"
                + "      ,[Address]\n"
                + "  FROM [dbo].[Customers]\n"
                + "WHERE CustomerID = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("CustomerID");
                String customerName = rs.getString("CustomerName");
                String sex = rs.getString("Sex");

                String Email = rs.getString("Email");
                String phone = rs.getString("Phone");

                String Password = rs.getString("Password");
                int roleID = rs.getInt("RoleID");
                String addr = rs.getString("Address");

                Customer customers = new Customer(id, roleID, customerName, sex, Email, phone, Password, addr);
                return customers;
            }

        } catch (SQLException ex) {
            Logger.getLogger(customersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //Hàm checkUser để login
    public Customer getCustomers(String email, String password) {
        String sql = "SELECT [CustomerID]\n"
                + "      ,[CustomerName]\n"
                + "      ,[Sex]\n"
                + "      ,[Email]\n"
                + "      ,[Phone]\n"
                + "      ,[Password]\n"
                + "      ,[RoleID]\n"
                + "      ,[Address]\n"
                + "  FROM [dbo].[Customers]\n"
                + "WHERE Email = ? and Password = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String customerName = rs.getString("CustomerName");
                String sex = rs.getString("Sex");

                String Email = rs.getString("Email");
                String phone = rs.getString("Phone");

                String Password = rs.getString("Password");
                int roleID = rs.getInt("RoleID");
                String addr = rs.getString("Address");

                Customer customers = new Customer(id, roleID, customerName, sex, Email, phone, Password, addr);
                return customers;
            }

        } catch (SQLException ex) {
            Logger.getLogger(customersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // Hàm thêm 1 tài khoản
    public int addCustomer(Customer customer) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "           ([CustomerName]\n"
                + "           ,[Sex]\n"
                + "           ,[Email]\n"
                + "           ,[Phone]\n"
                + "           ,[Password]\n"
                + "           ,[RoleID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getSex());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getPassword());
            ps.setInt(6, customer.getRoleID());
            n = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(customersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    //Hàm update tài khoản
    public int updateCustomer(Customer customers) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customers]\n"
                + "   SET [CustomerName] = ?\n"
                + "      ,[Sex] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Password] = ?\n"
                + "      ,[RoleID] = ?\n"
                + " WHERE CustomerID = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customers.getCustomerName());
            ps.setString(2, customers.getSex());
            ps.setString(3, customers.getEmail());
            ps.setString(4, customers.getPhone());
            ps.setString(5, customers.getPassword());
            ps.setInt(6, customers.getRoleID());
            ps.setInt(7, customers.getCustomerID());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(customersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public boolean checkEmail(String email) {
        List<Customer> list = new ArrayList<>();

        for (Customer customers : list) {
            if (email.equals(customers.getEmail())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        customersDAO cus = new customersDAO();
        //Customers custom = new Customer("hieu", null, null, "hieu123", null, null, "123", 0);
        List<Customer> list = cus.getAllCustomers();
        //Customers customer = new Customer(customerName, sex, null, email, phone, null, password, 0);
        int id = 3;
        Customer cut = cus.getCustomersByID(id);
        System.out.println(cut);
    }

}
