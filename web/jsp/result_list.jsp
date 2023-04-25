<%-- 
    Document   : result_list
    Created on : Mar 14, 2023, 5:03:13 PM
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
            <h1>Danh sách đối tượng tham gia bảo hiểm ${requestScope.messager2}</h1>
            <form action="homeServlet?action=list" method="post">
                <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%;">
                    <thead>
                        <tr>
                            <th>MÃ BHXH</th>
                            <th>HỌ VÀ TÊN</th>
                            <th>QUÊ QUÁN</th>
                            <th>NĂM SINH</th>
                            <th>NGÀY ĐĂNG KÍ</th>
                            <th>SỐ TIỀN ĐÃ ĐÓNG</th>
                            <th>LOẠI GÓI</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="information" items="${requestScope.informationsList}">
                        <tr>
                            <td>${information.getMember().getId()}</td>
                            <td><a href="">${information.getMember().getFullName()}</a></td>
                            <td>${information.getMember().getHomeTown()}</td>
                            <td>${information.getMember().getBirthYear()}</td>
                            <th>${information.getFee().getTime()}</th>
                            <th>${information.getFee().getInsuarance()!=0?information.getFee().getInsuarance():information.getFee().getSubsidy()}</th>
                            <th>6 tháng</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input type="submit" class="csw-btn-button" value="Trở về">
            </form>
        </div>
    </body>
</html>
