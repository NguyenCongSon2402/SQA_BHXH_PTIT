/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Data.AccountDB;
import Data.StaffDB;
import Model.Province;
import Model.Staff;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CongSon
 */
public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String userName = (String) request.getParameter("userName");
        String passWord = (String) request.getParameter("passWord");
        System.out.println("hiển thị");
        System.out.println(passWord.length());
        System.out.println(userName.length());
        String url = "/jsp/login.jsp";
        String messager = "";
        if (userName.length() == 0 || passWord.length() == 0) {
            messager = "Vui lòng nhập đủ tài khoản hoặc mật khẩu";
        } else if (new AccountDB().Login(userName, passWord) == false) {
            messager = "Tài khoản hoặc mật khẩu không chính xác";
        } else {
            //lấy thông tin staff
            Staff staff = new StaffDB().getStaff(userName, passWord);
            //lay danh sach cac tinh thanh.
            String s = getServletContext().getInitParameter("provinceList");
            ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(s.split(";")));
            ArrayList<Province> provinceList = new ArrayList<Province>();
            for (int i = 0; i < nameList.size(); i++) {
                provinceList.add(new Province(i, nameList.get(i)));
            }
            //chuyen giao dien
            url = "/jsp/home.jsp";
            //Dat danh sach tinh thanh vao session
            HttpSession session = request.getSession();
            session.setAttribute("provinceList", provinceList);
            session.setAttribute("staff", staff);
        }

        request.setAttribute("messager", messager);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
