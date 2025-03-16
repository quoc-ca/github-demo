/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Category;

/**
 *
 * @author Computer
 */
public class CategoryDAO extends DBContext{

    public CategoryDAO() {
        super();
    }
    
    public Category getCategoryById(int id) {
        Category category = null;
        try {
            String sql = "select * from Categories where CategoryID = " + id;
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {//Kiểm tra xem có tồn tại dữ liệu trong ResultSet hay ko
                int Cid = rs.getInt("CategoryID");
                String name = rs.getString("CategoryName");
                category = new Category(Cid, name);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return category;
    }
    
    public static void main(String[] args) {
        CategoryDAO cd = new CategoryDAO();
        Category supplier = cd.getCategoryById(1);
        System.out.println(supplier.getCategoryName());
    }
}
