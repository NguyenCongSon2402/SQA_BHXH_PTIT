<%-- 
    Document   : setup
    Created on : Mar 14, 2023, 5:04:00 PM
    Author     : CongSon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            h1{
                text-align:center
            }
            .content {
                margin: auto;
                padding-left: 200px;
            }
        </style>
    </head>
    <body>
        <div class="head">
            <img width="100%" src="image/BHXH.png">
        </div>
        <div class="content">
            <h1>Cài đặt cấu hình</h1>
            <p style="text-align:center;color: red"><b>${requestScope.messager3}</b></p>
            <form action="setupServlet" method="post">
                <table class="table table-bordered table-hover" border="0" cellpadding="5" style="max-width: 100%;">
                    <tbody>
                        <%--Mức đóng--%>
                        <tr>
                            <td><b>Mức đóng</b></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Quỹ hưu trí và tử tuất</td>
                            <td><input type="text" name="fund1" value="${sessionScope.setupInform.getFundPercent().getFund1()}"></td>
                            <td>Quỹ bảo hiểm thất nghiệp</td>
                            <td><input type="text" name="fund3" value="${sessionScope.setupInform.getFundPercent().getFund3()}"></td>
                        </tr>
                        <tr>
                            <td>Quỹ ốm đau thai sản</td>
                            <td><input type="text" name="fund2" value="${sessionScope.setupInform.getFundPercent().getFund2()}"></td>
                            <td>Quỹ bảo hiểm y tế</td>
                            <td><input type="text" name="fund4" value="${sessionScope.setupInform.getFundPercent().getFund4()}"></td>
                        </tr>
                        <tr>
                            <td>Tai nạn lao động</td>
                            <td><input type="text" name="fund5" value="${sessionScope.setupInform.getFundPercent().getFund5()}"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <%--Mức đóng--%>
                        <tr>
                            <td><b>Mức đóng lương tối thiểu từng vùng</b></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Vùng I</td>
                            <td><input type="text" name="region1" value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion1()}"></td>
                            <td>Vùng II</td>
                            <td><input type="text" name="region2" value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion2()}"></td>
                        </tr>
                        <tr>
                            <td>Vùng III</td>
                            <td><input type="text" name="region3" value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion3()}"></td>
                            <td>Vùng IV</td>
                            <td><input type="text" name="region4" value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion4()}"></td>
                        </tr>
                        <%--Mức đóng--%>
                        <tr>
                            <td><b>Hạn mức lương tham gia</b></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Tối thiểu</td>
                            <td><input type="text" name="minSalary" value="${sessionScope.setupInform.getSalaryLimit().getMinSalary()}"></td>
                            <td>tối đa</td>
                            <td><input type="text" name="maxSalary" value="${sessionScope.setupInform.getSalaryLimit().getMaxSalary()}"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Lưu cấu hình"></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table> 
            </form>
        </div>
    </body>
</html>
