<%-- 
    Document   : RevenueByDay
    Created on : Mar 15, 2025, 5:05:44 PM
    Author     : Computer
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f8f9fa;
                text-align: center;
            }

            h1 {
                color: #2c3e50;
            }

            table {
                width: 80%;
                margin: 20px auto;
                border-collapse: collapse;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
                border-radius: 8px;
                overflow: hidden;
                background-color: #fff;
            }

            thead {
                background-color: #264B8A;
                color: white;
                text-transform: uppercase;
            }

            th, td {
                padding: 12px;
                border: 1px solid #ddd;
                text-align: center;
            }

            tbody tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tbody tr:hover {
                background-color: #d5dbdb;
                cursor: pointer;
            }
        </style>

    </head>
    <body>
        <h1>
            REVENUE BY DAY
        </h1>
        <table border = 1>
            <thead>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        DAY
                    </th>
                    <th>
                        TOTAL ORDER
                    </th>
                    <th>
                        TOTAL REVENUE
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${revenueDayList}" var="d" varStatus="i">
                    <tr>
                        <td>${i.index + 1}</td>
                        <td>
                            <fmt:formatDate value="${d.deliveryDate}" pattern="dd-MM-yyyy"/>
                        </td>
                        <td>${d.totalOrder}</td>
                        <td>${d.totalRevenue}</td>
                    </tr>
                </c:forEach>

            </tbody>    
        </table>
    </body>
</html>
