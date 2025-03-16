<%-- admin_dashboard.jsp --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Dashboard</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f5f6fa;
                display: flex;
                min-height: 100vh;
            }

            .sidebar {
                width: 280px;
                background: linear-gradient(180deg, #1e3c72 0%, #2a5298 100%);
                height: 100vh;
                padding: 30px 20px;
                position: fixed;
                box-shadow: 2px 0 10px rgba(0,0,0,0.1);
                transition: width 0.3s ease;
            }

            .sidebar:hover {
                width: 300px;
            }

            .sidebar h2 {
                color: white;
                text-align: center;
                margin-bottom: 40px;
                font-size: 24px;
                letter-spacing: 1px;
            }

            .sidebar ul {
                list-style-type: none;
            }

            .sidebar ul li {
                margin: 15px 0;
            }

            .sidebar ul li a {
                color: #dfe6e9;
                text-decoration: none;
                display: flex;
                align-items: center;
                padding: 15px;
                border-radius: 8px;
                transition: all 0.3s ease;
                font-size: 16px;
            }

            .sidebar ul li a:hover {
                background-color: rgba(255,255,255,0.1);
                color: white;
                transform: translateX(5px);
            }

            .sidebar ul li a.active {
                background-color: #3498db;
                color: white;
            }

            .content {
                margin-left: 280px;
                padding: 40px;
                width: calc(100% - 280px);
            }

            .content h1 {
                color: #2d3436;
                margin-bottom: 20px;
                font-size: 28px;
            }

            .content p {
                color: #636e72;
                font-size: 16px;
            }

            .logout-btn {
                position: absolute;
                bottom: 30px;
                width: 240px;
            }

            .logout-btn a {
                display: block;
                padding: 15px;
                background-color: #e74c3c;
                color: white;
                text-decoration: none;
                border-radius: 8px;
                text-align: center;
                transition: all 0.3s ease;
            }

            .logout-btn a:hover {
                background-color: #c0392b;
                transform: scale(1.05);
            }

            /* Dropdown */
            /* Đảm bảo sidebar không bị lỗi */
            .sidebar ul {
                list-style-type: none;
                padding: 0;
                margin: 0;
            }

            /* Đảm bảo mục chứa dropdown có position: relative */
            .sidebar ul li {
                position: relative;
            }

            /* Thiết lập dropdown menu */
            .dropdown {
                display: none;
                position: absolute;
                left: 10px; /* Canh trái theo phần tử cha */
                top: 100%; /* Hiện dropdown ngay bên dưới */
                background: linear-gradient(180deg, #1e3c72 0%, #2a5298 100%);
                min-width: 200px;
                box-shadow: 0px 4px 8px rgba(0,0,0,0.2);
                z-index: 1000;
                border-radius: 5px;
                padding: 10px 0;
            }

            /* Hiển thị dropdown khi di chuột vào li chứa nó */
            .sidebar ul li:hover .dropdown {
                display: block;
            }

            /* Style cho các mục trong dropdown */
            .dropdown li {
                padding: 0px 15px;
            }

            .dropdown a {
                color: #dfe6e9;
                text-decoration: none;
                display: block;
                padding: 10px 15px;
            }

            .dropdown a:hover {
                background-color: #f1f1f1;
            }


            /* Responsive design */
            @media (max-width: 768px) {
                .sidebar {
                    width: 80px;
                }

                .sidebar:hover {
                    width: 280px;
                }

                .content {
                    margin-left: 80px;
                    width: calc(100% - 80px);
                }

                .logout-btn {
                    width: 40px;
                }
            }

        </style>
    </head>
    <body>


        <div class="sidebar">
            <h2>Admin Panel</h2>
            <ul>
                <li><a href="manage_users.jsp">Quản lý người dùng</a></li>
                <li><a href="manage_products.jsp">Quản lý sản phẩm</a></li>
                <li><a href="manage_orders.jsp">Quản lý đơn hàng</a></li>
                <li><a href="system_settings.jsp">Cài đặt hệ thống</a></li>
                <li>
                    <a>Báo cáo & Thống kê &nbsp;&nbsp;▼</a>
                    <ul class="dropdown">
                        <li><a href="revenue_by_day">Báo cáo theo ngày</a></li>
                        <li><a href="revenue_by_month">Báo cáo theo tháng</a></li>
                        <li><a href="revenue_by_year">Báo cáo theo năm</a></li>
                        <li><a href="top5_product">Top 5 sản phẩm bán chạy</a></li>
                    </ul>

                </li>
            </ul>
            <div class="logout-btn">
                <a href="logout.jsp">Đăng xuất</a>
            </div>
        </div>


        <!--    Right content-->
        <div class="content">

            <c:if test="${revenueDayList eq null and revenueMonthList eq null and revenueYearList eq null and list eq null}">
                <h1>Chào mừng đến với Dashboard Admin</h1>
                <p>Vui lòng chọn chức năng từ menu bên trái để bắt đầu.</p>
            </c:if>

            <c:if test="${revenueDayList ne null}">
                <jsp:include page="RevenueByDay.jsp"/>
            </c:if>

            <c:if test="${revenueMonthList ne null}">
                <jsp:include page="RevenueByMonth.jsp"/>
            </c:if>

            <c:if test="${revenueYearList ne null}">
                <jsp:include page="RevenueByYear.jsp"/>
            </c:if>

            <c:if test="${list ne null}">
                <jsp:include page="Top5Product.jsp"/>
            </c:if>
        </div>
    </body>
</html>