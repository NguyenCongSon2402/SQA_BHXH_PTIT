<%-- 
    Document   : result_report
    Created on : Mar 14, 2023, 5:03:32 PM
    Author     : CongSon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .content {
                max-width:500px;
                margin: auto;
            }
            .csw-btn-button {
                cursor: pointer;
                font-size: 16px;
                padding: 2px 8px;
                color: #000 !important;
                border-radius: 5px;
                background: #fff;
                border: 1px solid #9B6A1D;
                transition: 0.4s;
            }
            .csw-btn-button:hover {
                background: #292929;
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
        </div>

        <div class="content">
            <h1>Báo cáo số lượng người tham gia BHXH</h1>
            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="width: 100%;">
                <thead>
                    <tr>
                        <th>Đối tượng</th>
                        <th>Số lượng</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Người tham gia bhxh </td>
                        <td>${requestScope.allMember}</td>
                    </tr>
                    <tr>
                        <td>Người mới tham gia bhxh</td>
                        <td>${requestScope.newMember}</td>
                    </tr>
                    <tr>
                        <td>Người bỏ tham gia bhxh</td>
                        <td>${requestScope.outMember}</td>
                    </tr>
                    <tr>
                        <td>Tỉ lệ tăng/giảm so với tháng trước</td>
                        <td>${requestScope.outMember}</td>
                    </tr>
                </tbody>
            </table>
            <h1>Báo cáo doanh thu theo tháng </h1>
            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="width: 100%;">
                <thead>
                    <tr>
                        <th>Khoản tiền</th>
                        <th>Số lượng</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Tổng thu trong tháng </td>
                        <td>100000</td>
                    </tr>
                    <tr>
                        <td>Chưa thu được trong tháng</td>
                        <td>100</td>
                    </tr>
                    <tr>
                        <td>Tiền trợ cấp là</td>
                        <td>147124</td>
                    </tr>
                    <tr>
                        <td>Tỉ lệ tăng/giảm so với tháng trước</td>
                        <td>${requestScope.outMember}</td>
                    </tr>
                </tbody>
            </table>
                    <td><input type="button" class="csw-btn-button" value="Xuất báo cáo"></td>
                    <td><a href="homeServlet?action=list" class="csw-btn-button" target="_self" >Trở về</a></td>
        </div>
    </body>
</html>
