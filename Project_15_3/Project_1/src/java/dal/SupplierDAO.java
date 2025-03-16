/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Computer
 */
public class SupplierDAO extends DBContext{

    public SupplierDAO() {
        super();
    }
    
    public Supplier getSupplierById(int id) {
        Supplier supplier = null;
        try {
            String sql = "select * from Suppliers where SupplierID = " + id;
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {//Kiểm tra xem có tồn tại dữ liệu trong ResultSet hay ko
                int sId = rs.getInt("SupplierID");
                String name = rs.getString("SupplierName");
                String addr = rs.getString("Address");
                String hotline = rs.getString("Hotline");
                
                supplier = new Supplier(sId, name, addr, hotline);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return supplier;
    }
    
    
}
