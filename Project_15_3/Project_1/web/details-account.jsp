<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Customer Detail</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">

    <!-- CSS tùy chỉnh -->
    <style>
        .customer-detail-section {
            padding: 80px 0;
            min-height: 100vh;
        }
        .customer-detail-container {
            max-width: 800px; /* Chiều rộng container */
            margin: 0 auto;
            padding: 30px;
        }
        .form-group {
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            gap: 20px; /* Khoảng cách giữa label và ô nhập liệu */
        }
        .form-group label {
            flex: 0 0 150px; /* Chiều rộng cố định cho label */
            font-size: 16px;
            color: #333;
            text-align: right;
        }
        .form-group input {
            flex: 1; /* Ô nhập liệu chiếm phần còn lại */
            padding: 15px; /* Tăng padding để ô to hơn */
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
            color: #666;
            min-height: 50px; /* Tăng chiều cao tối thiểu */
            box-sizing: border-box; /* Đảm bảo padding không làm tăng kích thước tổng */
        }
        .form-group input[readonly] {
            background-color: #f9f9f9; /* Màu nền cho ô chỉ đọc (CustomerID) */
        }
        .text-center {
            text-align: center;
        }
        .update-btn {
            margin-top: 30px;
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="img/language.png" alt="">
                <div>English</div>
            </div>
            <div class="header__top__right__auth">
                <c:if test="${sessionScope.customer eq null}">
                    <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                </c:if>
                <c:if test="${sessionScope.customer ne null}">
                    <a href="logout"><i class="fa fa-user"></i> Logout</a>
                </c:if>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./index.jsp">Home</a></li>
                <li><a href="./shop-grid.jsp">About Us</a></li>
               
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> Snackexpress@gmail.com</li>
                <li>Products are served with the best quality</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> Snackexpress@gmail.com</li>
                                <li>Products are served with the best quality</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="img/language.png" alt="">
                                <div>English</div>
                            </div>
                            <div class="header__top__right__auth">
                                <c:if test="${sessionScope.customer eq null}">
                                    <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                                </c:if>
                                <c:if test="${sessionScope.customer ne null}">
                                    <a href="logout"><i class="fa fa-user"></i> Logout</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="./index.jsp">Home</a></li>
                            <li><a href="./shop-grid.jsp">About Us</a></li>
                            
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Customer Detail Section Begin -->
    <section class="customer-detail-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="customer-detail-container">
                        <h2 class="text-center">Customer Detail</h2> <br> <br>
                        <form action="update" method="get">
                            
                            <c:if test="${sessionScope.customer ne null and sessionScope.customer.roleID == 1}">
                                <div class="form-group">
                                    <label>CustomerID:</label>
                                    <input type="text" name="customerName" value="${sessionScope.customer.customerID}" readonly>
                                </div>
                            </c:if>
                            
                            <div class="form-group">
                                <label>Customer Name:</label>
                                <input type="text" name="customerName" value="${sessionScope.customer.customerName}">
                            </div>
                            <div class="form-group">
                                <label>Sex:</label>
                                <input type="text" name="sex" value="${sessionScope.customer.sex}" required>
                            </div>
                            <div class="form-group">
                                <label>Email:</label>
                                <input type="email" name="email" value="${sessionScope.customer.email}">
                            </div>
                            <div class="form-group">
                                <label>Phone:</label>
                                <input type="text" name="phone" value="${sessionScope.customer.phone}" required>
                            </div>
                            <div class="form-group">
                                <label>Password:</label>
                                <input type="text" name="password" value="${sessionScope.customer.password}" required>
                            </div> 
                            
                            <c:if test="${sessionScope.customer ne null and sessionScope.customer.roleID == 1}">
                                <div class="form-group">
                                    <label>RoleID:</label>
                                    <input type="text" name="customerName" value="${sessionScope.customer.roleID}">
                                </div>
                            </c:if>
                            
                            <br> <br>
                            
                            <div>
                                ${requestScope.mesUpdate}
                            </div> <br> <br> 
                            
                            <div class="update-btn">
                                <button type="submit" class="site-btn">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Customer Detail Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: Hola H Town</li>
                            <li>Phone: +84 668 752 04</li>
                            <li>Email: SnackExpess@gmail.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Sign up now for updates on our latest store and special offers.</p>
                        
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text">
                            <p>Copyright ©<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                        </div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>