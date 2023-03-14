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
            <h1>Danh sách đối tượng tham gia bảo hiểm ${requestScope.messager2}</h1>
            <form action="homeServlet?action=list" method="post">
                <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%;">
                    <thead>
                        <tr>
                            <th>MÃ BHXH</th>
                            <th>HỌ VÀ TÊN</th>
                            <th>QUÊ QUÁN</th>
                            <th>NĂM SINH</th>
                            <th>THỜI GIAN</th>
                            <th>KHOẢN TIỀN</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="information" items="${requestScope.informationsList}">
                        <tr>
                            <td>${information.getMember().getId()}</td>
                            <td>${information.getMember().getFullName()}</td>
                            <td>${information.getMember().getHomeTown()}</td>
                            <td>${information.getMember().getBirthYear()}</td>
                            <th>${information.getFee().getTime()}</th>
                            <th>${information.getFee().getInsuarance()!=0?information.getFee().getInsuarance():information.getFee().getSubsidy()}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input type="submit" value="Quay trở lại">
            </form>
        </div>
    </body>
</html>
