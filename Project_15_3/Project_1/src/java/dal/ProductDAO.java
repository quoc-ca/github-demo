/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Category;
import model.Product;
import model.Supplier;

/**
 *
 * @author Computer
 */
public class ProductDAO extends DBContext {

    public ProductDAO() {
        super();
    }

    SupplierDAO supplierDAO = new SupplierDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    
    public Product getProductById(int id) {
        Product product = null;
        try {
            String sql = "select * from Products where ProductID = " + id;
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {//Kiểm tra xem có tồn tại dữ liệu trong ResultSet hay ko
                int pId = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                Supplier supplier = supplierDAO.getSupplierById(rs.getInt("SupplierID"));
                Category category = categoryDAO.getCategoryById(rs.getInt("CategoryID"));
                int quantity = rs.getInt("Quantity");
                double price = rs.getDouble("UnitPrice");
                String img = rs.getString("ImgURL");
                String des = rs.getString("Description");
                String status = rs.getString("Status");

                product = new Product(pId, name, supplier, category, quantity, price, img, des, status);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }

    
    public static void main(String[] args) {
        ProductDAO sD = new ProductDAO();
        Product supplier = sD.getProductById(2);
        System.out.println(supplier.getDescription());
    }
}
