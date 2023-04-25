 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Fee;
import Model.Information;
import Model.Member;
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
public class InformationDB {

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

    //statust=1 phai dong bao hiem va da nop
    //statust=2 phai dong bao hiem va chua nop
    //statust=3 duoc huong tro cap va da nhan
    //statust=4 duoc huong tro cap va chua nhan
    public ArrayList<Information> getImformationList(String t, int status, String province) throws Exception {
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
        ArrayList< Information> list = new ArrayList<Information>();
        String strSQL = "SELECT * FROM BHXH.FEE_LIST, BHXH.MEMBER_LIST "
                + "WHERE BHXH.FEE_LIST.ID=BHXH.MEMBER_LIST.ID "
                + "AND BHXH.FEE_LIST.TIME=? "
                + "AND BHXH.MEMBER_LIST.HOMETOWN=? "
                + sql;
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setString(1, t);
        pst.setString(2, province);
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
                String id = rs.getString("FEE_LIST.ID");
                String fullName = rs.getString("MEMBER_LIST.FULLNAME");
                int birthYear = rs.getInt("MEMBER_LIST.BIRTHYEAR");
                String hometown = rs.getString("MEMBER_LIST.HOMETOWN");
                String time = rs.getString("FEE_LIST.TIME");
                long salary = rs.getLong("FEE_LIST.SALARY");
                long insuarance = rs.getLong("FEE_LIST.SALARY");
                int payment = rs.getInt("FEE_LIST.PAYMENT");
                long subsidy = rs.getLong("FEE_LIST.SUBSIDY");
                int receive = rs.getInt("FEE_LIST.RECEIVE");
                Member member = new Member(id, fullName, birthYear, hometown);
                Fee fee = new Fee(id, time, salary, insuarance, payment, subsidy, receive);
                Information imformation = new Information(member, fee);
                list.add(imformation);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    //statust=1 phai dong bao hiem va da nop
    //statust=2 phai dong bao hiem va chua nop
    //statust=3 duoc huong tro cap va da nhan
    //statust=4 duoc huong tro cap va chua nhan
    public long CountFee(String t, int status, String province) throws Exception {
        long count = 0;
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
        ArrayList< Information> list = new ArrayList<Information>();
        String strSQL = "SELECT * FROM BHXH.FEE_LIST, BHXH.MEMBER_LIST "
                + "WHERE BHXH.FEE_LIST.ID=BHXH.MEMBER_LIST.ID "
                + "AND BHXH.FEE_LIST.TIME=? "
                + "AND BHXH.MEMBER_LIST.HOMETOWN=? "
                + sql;
        PreparedStatement pst = getConnection().prepareStatement(strSQL);
        pst.setString(1, t);
        pst.setString(2, province);
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
                if (status == 1 || status == 2) {
                    long insuarance = rs.getLong("FEE_LIST.SALARY");
                    count = count + insuarance;
                } else if (status == 1 || status == 2) {
                    long subsidy = rs.getLong("FEE_LIST.SUBSIDY");
                    count = count + subsidy;
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return count;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Information> list = new InformationDB().getImformationList("1-2019", 1, "An Giang");

            for (Information imformation : list) {
                System.out.println(imformation.getMember().getFullName());
                System.out.println(imformation.getMember().getId());
            }
        } catch (Exception ex) {
            Logger.getLogger(InformationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
