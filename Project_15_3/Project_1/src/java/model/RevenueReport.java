/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Computer
 */
public class RevenueReport {
    private Date deliveryDate;
    private int month, year;
    private int totalOrder;
    private double totalRevenue;

    public RevenueReport() {
    }

    //Báo cáo doanh thu theo ngày
    public RevenueReport(Date deliveryDate, int totalOrder, double totalRevenue) {
        this.deliveryDate = deliveryDate;
        this.totalOrder = totalOrder;
        this.totalRevenue = totalRevenue;
    }

    //Báo cáo doanh thu theo tháng
    public RevenueReport(int year, int month, int totalOrder, double totalRevenue) {
        this.year = year;
        this.month = month;        
        this.totalOrder = totalOrder;
        this.totalRevenue = totalRevenue;
    }

    //Báo cáo doanh thu theo năm
    public RevenueReport(int year, int totalOrder, double totalRevenue) {
        this.year = year;
        this.totalOrder = totalOrder;
        this.totalRevenue = totalRevenue;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    
    
}
