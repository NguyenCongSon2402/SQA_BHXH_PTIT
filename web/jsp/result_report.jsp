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
                max-width:600px;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <div class="head">
            <img width="100%" src="image/BHXH.png">
        </div>

        <div class="content">
            <h1>Báo cáo thống kê đối tượng tham gia</h1>
            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="width: 100%;">
                <thead>
                    <tr>
                        <th>Đối tượng</th>
                        <th>Số liệu</th>
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
                </tbody>
            </table>
            <h1>Báo cáo thống kê kế toán</h1>
            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="width: 100%;">
                <thead>
                    <tr>
                        <th>Khoản tiền</th>
                        <th>Số liệu</th>
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
                        <td>tiền trợ cấp là</td>
                        <td>147124</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
