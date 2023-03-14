/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CongSon
 */
public class StaffDB {

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
        String url = "jdbc:mysql://localhost:3306/bhxh?autoReconnect=true&useSSL=false";
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

    public Staff getStaff(String userName, String passWord) throws Exception {
        Staff staff = new Staff();
        if (new AccountDB().Login(userName, passWord)) {
            String strSQL = "SELECT * FROM STAFF_LIST "
                    + "WHERE STAFF_LIST.USERNAME=?";
            PreparedStatement pst = getConnection().prepareStatement(strSQL);
            pst.setString(1, userName);
            try {
                rs = pst.executeQuery();
                if (rs.next()) {
                    String user = rs.getString("username");
                    String department = rs.getString("department");
                    String fullName = rs.getString("fullName");
                    int birthYear = rs.getInt("birthYear");
                    String hometown = rs.getString("hometown");
                    staff = new Staff(userName, department, fullName, birthYear, hometown);
                    System.out.println(staff);
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
            closeConnection();
        }
        return staff;
    }

    public static void main(String[] args) {
        try {
            new StaffDB().getStaff("tando", "12345678");
        } catch (Exception ex) {
            Logger.getLogger(StaffDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
