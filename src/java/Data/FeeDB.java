/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Fee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CongSon
 */
public class FeeDB {

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

    
    public ArrayList<Fee> getMemberList() throws Exception {
        int status = 1;
        String sql = "";
        if (status == 1 || status == 2) {
            // Đã nhận nộp tiền bhxh
            sql = "AND BHXH.FEE_LIST.INSURANCEFEE<>0 "
                    + "AND BHXH.FEE_LIST.PAYMENT=?";
        } else if (status == 3 || status == 4) {
            //Nhận tiền hỗ trợ
            sql = "AND BHXH.FEE_LIST.SUBSIDY<>0 "
                    + "AND BHXH.FEE_LIST.RECEIVE=?";
        }
        ArrayList< Fee> list = new ArrayList<Fee>();
        String strSQL = "SELECT * FROM BHXH.FEE_LIST, BHXH.MEMBER_LIST "
                + "WHERE BHXH.FEE_LIST.ID=BHXH.MEMBER_LIST.ID "
                + "AND BHXH.FEE_LIST.TIME=? "
                + "AND BHXH.MEMBER_LIST.HOMETOWN=? "
                + sql;
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setString(1, "1-2019");
        pst.setString(2, "Nam định");
        if (status == 1) {
            pst.setString(3, "1");
        } else if (status == 2) {
            pst.setString(3, "0");
        } else if (status == 3) {
            pst.setString(3, "1");
        } else if (status == 4) {
            pst.setString(3, "0");
        }
        try {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("FEE_LIST.id");
                String time = rs.getString("FEE_LIST.time");
                String hometown = rs.getString("MEMBER_LIST.hometown");
                //int payment = rs.getInt("FEE_LIST.PAYMENT");
                System.out.println(id + " " + time + " " + hometown);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public static void main(String[] args) {
        try {
            new FeeDB().getMemberList();
        } catch (Exception ex) {
            Logger.getLogger(FeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
