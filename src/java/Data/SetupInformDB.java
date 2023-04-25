/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.FundPercent;
import Model.SalaryLimit;
import Model.SalaryRegion;
import Model.SetupInform;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CongSon
 */
public class SetupInformDB {

    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;

    protected void loadDriver() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    protected Connection getConnection() throws Exception {
        String userName = "root";
        String passWord = "2402";
        String url = "jdbc:mysql://localhost:3306/bhxh?autoReconnect=true&useSSL=true";
        if (connection == null) {
            loadDriver();
            try {
                this.connection = DriverManager.getConnection(url, userName, passWord);
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
        return connection;
    }

    protected Statement getStatement() throws SQLException, Exception {
        if (stmt == null) {
            stmt = getConnection().createStatement();
        }
        return stmt;
    }

    public void closeConnection() throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void executeUpdate(String strSQL) throws Exception {
        try {
            getStatement().executeUpdate(strSQL);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            this.closeConnection();
        }
    }

    public SalaryLimit getSalaryLimit() throws Exception {
        SalaryLimit salaryLimit = new SalaryLimit();
        String strSQL = "SELECT * FROM LIMIT_SALARY";
        long maxSalary = 0, minSalary = 0;
        try {
            rs = getStatement().executeQuery(strSQL);
            rs.next();
            maxSalary = Long.parseLong(rs.getString("valueLimit"));
            rs.next();
            minSalary = Long.parseLong(rs.getString("valueLimit"));
            System.out.println(maxSalary + " " + minSalary);
            salaryLimit = new SalaryLimit(maxSalary,minSalary);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        //closeConnection();
        return salaryLimit;
    }

    public long getSalaryRegion(int i) throws Exception {
        String strSQL = "SELECT * FROM SALARY_REGION "
                + "WHERE SALARY_REGION.IDREGION=?";
        long fund = 0;
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setInt(1, i);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            fund = rs.getLong("saraly");

        }
        return fund;
    }

    public double getFundPercent(int i) throws Exception {
        String strSQL = "SELECT * FROM FUND_PERCENT "
                + "WHERE FUND_PERCENT.IDFUND=?";
        double percent = 0;
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setInt(1, i);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            percent = rs.getDouble("PERCENT");

        }
        return percent;
    }

    public SetupInform getSetupImformation() throws Exception {
        SetupInform setupInform = new SetupInform();
        SalaryLimit SalaryLimit = new SetupInformDB().getSalaryLimit();
        double fund1 = new SetupInformDB().getFundPercent(1);
        double fund2 = new SetupInformDB().getFundPercent(2);
        double fund3 = new SetupInformDB().getFundPercent(3);
        double fund4 = new SetupInformDB().getFundPercent(4);
        double fund5 = new SetupInformDB().getFundPercent(5);
        FundPercent percent = new FundPercent(fund1, fund2, fund3, fund4, fund5);
        long region1 = new SetupInformDB().getSalaryRegion(1);
        long region2 = new SetupInformDB().getSalaryRegion(2);
        long region3 = new SetupInformDB().getSalaryRegion(3);
        long region4 = new SetupInformDB().getSalaryRegion(4);
        SalaryRegion salaryRegion = new SalaryRegion(region1, region2, region3, region4);
        setupInform = new SetupInform(percent, SalaryLimit, salaryRegion);
        return setupInform;
    }

    //sửa lại mức đóng quỹ
    public void setFundPercent(int i, double p) throws Exception {
        String strSQL = "UPDATE FUND_PERCENT "
                + "SET FUND_PERCENT.PERCENT=? "
                + "WHERE FUND_PERCENT.IDFUND=?";
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setDouble(1, p);
        pst.setInt(2, i);
        pst.executeUpdate();
    }

    public void setSalaryRegion(int i, long p) throws Exception {
        String strSQL = "UPDATE salary_region "
                + "SET salary_region.saraly=? "
                + "WHERE salary_region.idRegion=?";
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setLong(1, p);
        pst.setInt(2, i);
        pst.executeUpdate();
    }

    public void setSalaryLimit(String type, long v) throws Exception {
        String strSQL = "UPDATE limit_salary "
                + "SET limit_salary.valueLimit=? "
                + "WHERE limit_salary.type=?";
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setLong(1, v);
        pst.setString(2, type);
        pst.executeUpdate();
    }

    public static void main(String[] args) throws Exception {
        SetupInformDB setupInformDB = new SetupInformDB();
        SetupInform setupInform = setupInformDB.getSetupImformation();
        System.out.println(setupInform.getFundPercent().getFund1());
        System.out.println(setupInform.getSalaryLimit().getMaxSalary());
        System.out.println(setupInform.getSalaryRegion().getSalaryRegion1());
    }

}
