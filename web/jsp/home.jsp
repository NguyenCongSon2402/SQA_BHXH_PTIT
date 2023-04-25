<%-- 
    Document   : home
    Created on : Mar 14, 2023, 4:57:11 PM
    Author     : CongSon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <style>
            .content {
                max-width: 500px;
                margin: auto;
            }
            </style>
                <style type="text/css">
		body {
			margin: 0;
			padding: 0;
		}
		header {
			position: relative;
			height: 100vh;
			overflow: hidden;
		}
		header img {
			position: absolute;
			top: 0;
			left: 0;
			right: 0;
			bottom: 0;
			margin: auto;
			height: 100%;
		}
	</style>
            
        </style>
    </head>
    <body>
        <div class="head">
            <img width="100%" src="image/BHXH.png">
            <%-- Thanh chức năng  --%>
            <nav class="navbar navbar-expand-sm bg-success navbar-dark top-menu">
                <div class="container">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="homeServlet?action=list">Theo dõi danh sách</a>
                        </li>
                        <li>
                            <a href="homeServlet?action=report">Thống kê báo cáo</a>
                        </li>
                        <li>
                            <a href="homeServlet?action=setup">Quản lý cấu hình</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <div class="content">
            <h1>Trang Chủ</h1>
            <table width="100%">
                <tr>
                    <th>Họ và tên</th>
                    <th>: ${sessionScope.staff.getFullName()}</th>
                </tr>
                <tr>
                    <th>Bộ phận</th>
                    <th>: ${sessionScope.staff.getDepartment()}</th>
                </tr>
                <tr>
                    <th>Năm sinh</th>
                    <th>: ${sessionScope.staff.getBirthYear()}</th>
                </tr>
                <tr>
                    <th>Quê quán</th>
                    <th>: ${sessionScope.staff.getHomeTown()}</th>
                </tr>
                <tr>
                    <th>Cơ quan</th>
                    <th>: Bảo Hiểm Xã Hội</th>
                </tr>
            </table>
        </div>
    </body>
</html>
