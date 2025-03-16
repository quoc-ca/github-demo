/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Product;
import model.ProductReport;
import model.RevenueReport;

/**
 *
 * @author Computer
 */
public class ReportDAO extends DBContext {

    public ReportDAO() {
        super();
    }
    ProductDAO productDAO = new ProductDAO();
    

    //Báo cáo doanh thu theo ngày
    public List<RevenueReport> getRevenueByDay() {
        String sql = """
                     SELECT 
                         DeliveryDate, 
                         COUNT(DISTINCT o.OrderID) AS TotalOrders, 
                         SUM(od.Quantity * od.UnitPrice) AS TotalRevenue
                     FROM Orders o
                     JOIN OrderDetails od ON o.OrderID = od.OrderID
                     WHERE o.Status = 'Delivered' 
                     GROUP BY DeliveryDate
                     ORDER BY DeliveryDate DESC;""";

        List<RevenueReport> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Date deliDate = rs.getDate("DeliveryDate");
                int totalOrder = rs.getInt("TotalOrders");
                double totalRevenue = rs.getDouble("TotalRevenue");

                RevenueReport rp = new RevenueReport(deliDate, totalOrder, totalRevenue);
                list.add(rp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        ReportDAO rP = new ReportDAO();
        List<RevenueReport> list = rP.getRevenueByYear();
        for (RevenueReport x : list) {
            System.out.println(x.getTotalRevenue());
        }
    }

    //Báo cáo doanh thu theo tháng
    public List<RevenueReport> getRevenueByMonth() {
        String sql = """
                     SELECT 
                         YEAR(DeliveryDate) AS Year, 
                         MONTH(DeliveryDate) AS Month, 
                         COUNT(DISTINCT o.OrderID) AS TotalOrders, 
                         SUM(od.Quantity * od.UnitPrice) AS TotalRevenue
                     FROM Orders o
                     JOIN OrderDetails od ON o.OrderID = od.OrderID
                     WHERE o.Status = 'Delivered'
                     GROUP BY YEAR(DeliveryDate), MONTH(DeliveryDate)
                     ORDER BY Year DESC, Month DESC;""";

        List<RevenueReport> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int year = rs.getInt("Year");
                int month = rs.getInt("Month");
                int totalOrder = rs.getInt("TotalOrders");
                double totalRevenue = rs.getDouble("TotalRevenue");

                RevenueReport rp = new RevenueReport(year, month, totalOrder, totalRevenue);
                list.add(rp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //Báo cáo doanh thu theo năm
    public List<RevenueReport> getRevenueByYear() {
        String sql = """
                     SELECT 
                         YEAR(DeliveryDate) AS Year,
                         COUNT(DISTINCT o.OrderID) AS TotalOrders, 
                         SUM(od.Quantity * od.UnitPrice) AS TotalRevenue
                     FROM Orders o
                     JOIN OrderDetails od ON o.OrderID = od.OrderID
                     WHERE o.Status = 'Delivered'
                     GROUP BY YEAR(DeliveryDate)
                     ORDER BY Year DESC;""";

        List<RevenueReport> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int year = rs.getInt("Year");
                int totalOrder = rs.getInt("TotalOrders");
                double totalRevenue = rs.getDouble("TotalRevenue");

                RevenueReport rp = new RevenueReport(year, totalOrder, totalRevenue);
                list.add(rp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //Lấy ra 5 sản phẩm bán chạy nhất
    public List<ProductReport> getTop5Product() {
        String sql = """
                     SELECT TOP 5
                         p.ProductID, 
                         SUM(od.Quantity) AS TotalSold
                     FROM OrderDetails od
                     JOIN Products p ON od.ProductID = p.ProductID
                     GROUP BY p.ProductID, p.ProductName
                     ORDER BY TotalSold DESC;""";
        
        List<ProductReport> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int productId = rs.getInt("ProductID");
                Product product  = productDAO.getProductById(productId);
                int totalSold = rs.getInt("TotalSold");
                
                ProductReport pr = new ProductReport(product, totalSold);
                
                list.add(pr);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
