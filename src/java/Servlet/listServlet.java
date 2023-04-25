/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet;

import Data.InformationDB;
import Model.Information;
import Model.Province;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CongSon
 */
public class listServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String url = "/jsp/list.jsp";
        String messager = "";
        String action = (String) request.getParameter("action");
        if (action.equals("timkiem")) {
            //lấy thông tin yêu cầu
            int status = 0;
            String month = (String) request.getParameter("month");
            String year = (String) request.getParameter("year");
            String status_string = (String) request.getParameter("status");
            int index = Integer.parseInt(request.getParameter("prov"));
            if (status_string != null) {
                url = "/jsp/result_list.jsp";
                String messager2 = "";
                String time = month + "-" + year;
                status = Integer.parseInt(status_string);
                //lấy danh sách
                HttpSession session=request.getSession();
                ArrayList<Province>provinceList=(ArrayList<Province>)session.getAttribute("provinceList");
                String province=provinceList.get(index).getName();
                System.out.println(province);
                // danh sách kết quả
                ArrayList<Information> informationsList=new InformationDB().getImformationList(time, status, province);
                if (status == 1) {
                    messager2 = "đã đóng bảo hiểm, tháng " + time + ", tỉnh " + province;
                } else if (status == 2) {
                    messager2 = "chưa đóng bảo hiểm, tháng " + time + ", tỉnh " + province;
                } else if (status == 3) {
                    messager2 = "đã nhận trợ cấp bảo hiểm, tháng " + time + ", tỉnh " + province;
                } else if (status == 4) {
                    messager2 = "chưa nhận nhận trợ hiểm, tháng " + time + ", tỉnh " + province;
                }
                request.setAttribute("messager2", messager2);
                request.setAttribute("informationsList", informationsList);

            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
        else{
            url = "/jsp/home.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(listServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(listServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
