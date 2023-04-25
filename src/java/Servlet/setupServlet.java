/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Data.SetupInformDB;
import Model.FundPercent;
import Model.SalaryLimit;
import Model.SalaryRegion;
import Model.SetupInform;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author CongSon
 */
public class setupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/jsp/setup.jsp";

        //fund
        String fund1_String = request.getParameter("fund1");
        String fund2_String = request.getParameter("fund2");
        String fund3_String = request.getParameter("fund3");
        String fund4_String = request.getParameter("fund4");
        String fund5_String = request.getParameter("fund5");
        //region
        String region1_String = request.getParameter("region1");
        String region2_String = request.getParameter("region2");
        String region3_String = request.getParameter("region3");
        String region4_String = request.getParameter("region4");
        //limit
        String minSalary_String = request.getParameter("minSalary");
        String maxSalary_String = request.getParameter("maxSalary");

        System.out.println(fund1_String);
        System.out.println(fund2_String);
        System.out.println(fund3_String);
        System.out.println(fund4_String);
        System.out.println(fund5_String);
        System.out.println(region1_String);
        System.out.println(region2_String);
        System.out.println(region3_String);
        System.out.println(region4_String);
        System.out.println(region1_String);
        System.out.println(region2_String);
        System.out.println(region3_String);
        System.out.println(region4_String);

       
        if (fund1_String == null || fund2_String == null || fund3_String == null || fund4_String == null || fund5_String == null
                || region1_String == null || region2_String == null || region3_String == null || region4_String == null || minSalary_String == null || maxSalary_String == null
                || fund1_String.equals("") || fund2_String.equals("") || fund3_String.equals("") || fund4_String.equals("") || fund5_String.equals("") || region1_String.equals("")
                || region2_String.equals("") || region3_String.equals("") || region4_String.equals("") || minSalary_String.equals("") || maxSalary_String.equals("")
                || fund1_String.length() == 0 || fund2_String.length() == 0 || fund3_String.length() == 0 || fund4_String.length() == 0 || fund5_String.length() == 0 || region1_String.length() == 0
                || region2_String.length() == 0 || region3_String.length() == 0 || region4_String.length() == 0 || minSalary_String.length() == 0 || maxSalary_String.length() == 0
                || Long.parseLong(minSalary_String) >= Long.parseLong(maxSalary_String)) {
            String messager3 = "Dữ liệu nhập vào không hợp lệ!";
            request.setAttribute("messager3", messager3);
            //chuyen giao dien
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } else {
            try {
                //
                double fund1 = Double.parseDouble(fund1_String);
                double fund2 = Double.parseDouble(fund2_String);
                double fund3 = Double.parseDouble(fund3_String);
                double fund4 = Double.parseDouble(fund4_String);
                double fund5 = Double.parseDouble(fund5_String);
                //
                long region1 = Long.parseLong(region1_String);
                long region2 = Long.parseLong(region2_String);
                long region3 = Long.parseLong(region3_String);
                long region4 = Long.parseLong(region4_String);
                //
                long minSalary = Long.parseLong(minSalary_String);
                long maxSalary = Long.parseLong(maxSalary_String);

                SetupInform setupInform = new SetupInform(new FundPercent(fund1, fund2, fund3, fund4, fund5)
                        , new SalaryLimit(maxSalary, minSalary)
                        , new SalaryRegion(region1, region2, region3, region4));
                //update
                SetupInformDB setupInformDB = new SetupInformDB();
                setupInformDB.setFundPercent(1, fund1);
                setupInformDB.setFundPercent(2, fund2);
                setupInformDB.setFundPercent(3, fund3);
                setupInformDB.setFundPercent(4, fund4);
                setupInformDB.setFundPercent(5, fund5);

                setupInformDB.setSalaryRegion(1, region1);
                setupInformDB.setSalaryRegion(2, region2);
                setupInformDB.setSalaryRegion(3, region3);
                setupInformDB.setSalaryRegion(4, region4);

                setupInformDB.setSalaryLimit("max", maxSalary);
                setupInformDB.setSalaryLimit("min", minSalary);
                //
                //System.out.println(minSalary_String);
                HttpSession session = request.getSession();
                session.setAttribute("setupInform", setupInform);
            } catch (Exception e) {
            }
            url = "/jsp/home.jsp";
            //chuyen giao dien
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
