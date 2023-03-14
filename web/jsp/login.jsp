<%-- 
    Document   : login
    Created on : Mar 14, 2023, 4:59:08 PM
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
                max-width: 500px;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <div class="head">
            <img width="100%" src="image/BHXH.png">
        </div>
        <div class="content">
            <h1>Đặng nhập tài khoản</h1>
            <form action="loginServlet" method="post">
                <table>
                    <tr>
                        <td>Tài khoản</td>
                        <td><input type="text" name="userName"></td>
                    </tr>
                    <tr>
                        <td>Mật khẩu</td>
                        <td><input type="password" name="passWord"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>${requestScope.messager}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Đăng nhập"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>

</html>
