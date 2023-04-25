<%-- 
    Document   : list
    Created on : Mar 14, 2023, 5:01:42 PM
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
            <h1>Theo dõi danh sách</h1>
            <form action="listServlet?action=timkiem" method="post">
                <table width="100%">
                    <%-- khung thời gian --%>
                    <tr>
                        <td>Thời gian</td>
                        <td>
                            <select id="month" name="month">
                                <c:forEach var = "i" begin = "1" end = "12">
                                    <option value="${i}">Tháng ${i}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select id="year" name="year">
                                <c:forEach var = "i" begin = "2001" end = "2023">
                                    <option value="${i}">Năm ${i}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <%-- Hiển thị thông tin --%>
                    <%-- Trạng thái --%>
                    <tr>
                        <td>Trạng thái:</td>
                        <td>
                            <input type="radio" name="status" value="1" checked>Đã đóng bảo hiểm</br>
                            <input type="radio" name="status" value="2">Chưa đóng bảo hiểm</br>
                            <input type="radio" name="status" value="3">Đã nhận tiền trợ cấp</br>
                            <input type="radio" name="status" value="4">Chưa nhận trợ cấp</br>
                        </td>
                        <td></td>
                    </tr>
                    <%-- Không gian --%>
                    <td>Tỉnh thành:</td>
                    <td>
                        <select id="prov" name="prov">
                            <c:forEach var="province" items="${sessionScope.provinceList}" >
                                <option value="${province.getIndex()}">${province.getName()}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                    <%-- Nút hiện thị--%>
                    <tr>
                        <td><input type="submit" class="csw-btn-button" value="Tìm kiếm"></td>
                        
                        <td><a href="listServlet?action=return" class="csw-btn-button" target="_self" >Trở về</a></td>
                    </tr>
                </table>
            </form>
           
        </div>
    </body>
</html>
