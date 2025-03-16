<%-- 
    Document   : Top5Product
    Created on : Mar 15, 2025, 6:13:33 PM
    Author     : Computer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top 5 Best-Selling Products</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f8f9fa;
                text-align: center;
            }

            h1 {
                color: #2c3e50;
                font-size: 28px;
                text-transform: uppercase;
                letter-spacing: 1px;
            }

            .product-list {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                gap: 20px;
                margin-top: 20px;
            }

            .product-card {
                background: white;
                width: 250px;
                padding: 15px;
                border-radius: 10px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
                text-align: center;
                transition: transform 0.3s ease-in-out;
            }

            .product-card:hover {
                transform: translateY(-5px);
            }

            .rank {
                font-size: 20px;
                font-weight: bold;
                color: #e74c3c;
                margin-bottom: 5px;
            }

            .product-image {
                width: 100%;
                height: 150px;
                object-fit: contain; /* Hiển thị toàn bộ ảnh mà không bị cắt */
                border-radius: 8px;
                margin-bottom: 10px;
                background-color: white; /* Nếu ảnh không full khung, nền sẽ là trắng */
            }


            .product-name {
                font-size: 18px;
                font-weight: bold;
                color: #34495e;
                margin-bottom: 5px;
            }

            .product-sales {
                font-size: 16px;
                color: #27ae60;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1>TOP 5 BEST-SELLING PRODUCTS</h1>
        <div class="product-list">
            <c:forEach items="${list}" var="p" varStatus="status">
                <div class="product-card">
                    <div class="rank">#${status.index + 1}</div>
                    <img src="img/img1/${p.productImg}" alt="${p.product.productName}" class="product-image">
                    <div class="product-name">${p.productName}</div>
                    <div class="product-sales">Sold: ${p.totalSold} times</div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
