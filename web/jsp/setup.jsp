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
            <h1>Cài đặt cấu hình</h1>
            <p style="text-align:center;color: red"><b>${requestScope.messager3}</b></p>
            <form action="setupServlet" method="post">
                <table class="table table-bordered table-hover" border="0" cellpadding="5" style="max-width: 100%;">
                    <tbody>
                        <%--Mức đóng--%>
                        <tr>
                            <td><b>Mức đóng</b></td>
                            <td>(%)</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Quỹ hưu trí và tử tuất</td>
                            <td><input type="number" name="fund1" min="0" max="100" step="0.1" value="${sessionScope.setupInform.getFundPercent().getFund1()}"></td>
                            <td>Quỹ bảo hiểm thất nghiệp</td>
                            <td><input type="number" name="fund3" min="0" max="100" step="0.1" value="${sessionScope.setupInform.getFundPercent().getFund3()}"></td>
                        </tr>
                        <tr>
                            <td>Quỹ ốm đau thai sản</td>
                            <td><input type="number" name="fund2" min="0" max="100" step="0.1" value="${sessionScope.setupInform.getFundPercent().getFund2()}"></td>
                            <td>Quỹ bảo hiểm y tế</td>
                            <td><input type="number" name="fund4" min="0" max="100" step="0.1" value="${sessionScope.setupInform.getFundPercent().getFund4()}"></td>
                        </tr>
                        <tr>
                            <td>Tai nạn lao động</td>
                            <td><input type="number" name="fund5" min="0" max="100" step="0.1" value="${sessionScope.setupInform.getFundPercent().getFund5()}"></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <%--Mức đóng--%>
                        <tr>
                            <td><b>Mức đóng lương tối thiểu từng vùng</b></td>
                            <td>(đồng/tháng)</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Vùng I</td>
                            <td><input type="number" name="region1" min="0" max="100000000"value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion1()}"></td>

                            <td>Vùng II</td>
                            <td><input type="number" name="region2" min="0"  max="100000000"value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion2()}"></td>
                        </tr>
                        <tr>
                            <td>Vùng III</td>
                            <td><input type="number" name="region3" min="0"  max="100000000"value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion3()}"></td>
                            <td>Vùng IV</td>
                            <td><input type="number" name="region4" min="0" max="100000000"value="${sessionScope.setupInform.getSalaryRegion().getSalaryRegion4()}"></td>
                        </tr>
                        <%--Mức đóng--%>
                        <tr>
                            <td><b>Hạn mức lương tham gia</b></td>
                            <td>(đồng/tháng)</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Tối thiểu</td>
                            <td><input type="number" name="minSalary" min="0" max="100000000" value="${sessionScope.setupInform.getSalaryLimit().getMinSalary()}"></td>
                            <td>tối đa</td>
                            <td><input type="number" name="maxSalary" min="0" max="100000000" value="${sessionScope.setupInform.getSalaryLimit().getMaxSalary()}"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" class="csw-btn-button" value="Lưu cấu hình"></td>
                           
                            <td><a href="listServlet?action=return" class="csw-btn-button" target="_self" >Trở về</a></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table> 
            </form>
        </div>
    </body>
</html>
