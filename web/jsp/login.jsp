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
            <h1>Đăng nhập tài khoản</h1>
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
                        <td><input type="submit" class="csw-btn-button" value="Đăng nhập"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>

</html>
