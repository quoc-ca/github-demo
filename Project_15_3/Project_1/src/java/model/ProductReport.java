/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Computer
 */
public class ProductReport {
    private Product product;
    private int totalSold;

    public ProductReport() {
    }

    public ProductReport(Product product, int totalSold) {
        this.product = product;
        this.totalSold = totalSold;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public String getProductName() {
        return product.getProductName();
    }
    
    public String getProductImg() {
        return product.getImgURL();
    }
}
