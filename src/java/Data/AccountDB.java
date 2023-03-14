/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Account;
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
public class AccountDB {

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

    //Kiểm tra tài khoản đăng nhập.
    public boolean Login(String userName, String passWord) throws Exception {
        String sql = "SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, userName);
        pst.setString(2, passWord);
        ResultSet rs = pst.executeQuery();
        Account account = null;
        if (rs.next()) {
            String u = rs.getString("username");
            String p = rs.getString("password");
            account = new Account(u, p);
        }
        return account != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Login:" + new AccountDB().Login("son", "2402"));
    }
}

/*
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
        String passWord = "admin123";
        String url = "jdbc:mysql://localhost:3306/shopping?autoReconnect=true&useSSL=false";
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

    public ArrayList<Account> getAllAccount() throws Exception {
        ArrayList<Account> list = new ArrayList<Account>();
        String strSQL = "SELECT * FROM ACCOUNT";
        try {
            rs = getStatement().executeQuery(strSQL);
            while (rs.next()) {
                String userName = rs.getString(1);
                String passWord = rs.getString(2);
                int roleId = rs.getInt(3);
                Account user = new Account(userName, passWord, roleId);
                list.add(user);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public boolean Login(String userName, String passWord) throws Exception {
        String sql = "SELECT * FROM ACCOUNT WHERE USERNAME=? AND PASSWORD=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, userName);
        pst.setString(2, passWord);
        ResultSet rs = pst.executeQuery();
        Account account = null;
        if (rs.next()) {
            String u = rs.getString("username");
            String p = rs.getString("password");
            int roleId = rs.getInt("roleId");
            account = new Account(u, p, roleId);
        }
        return account != null;
    }

    public int getRole(String userName, String passWord) throws Exception {
        String sql = "SELECT * FROM ACCOUNT WHERE USERNAME=? AND PASSWORD=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, userName);
        pst.setString(2, passWord);
        ResultSet rs = pst.executeQuery();
        Account account = null;
        if (rs.next()) {
            int roleId = rs.getInt("roleId");
            return roleId;
        }
        return 0;
    }

    public boolean isExistAccount(String userName) throws Exception {
        String sql = "SELECT * FROM ACCOUNT WHERE USERNAME=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, userName);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int roleId = rs.getInt("roleId");
            if ((roleId == 0) || (roleId == 1)) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account user) throws Exception {
        if (!isExistAccount(user.getUserName())) {
            String sql = "INSERT INTO ACCOUNT VALUES(?,?,?)";
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassWord());
            pst.setInt(3, user.getRoleId());
            pst.executeUpdate();
        }
    }

    public void updateAccount(String name, String pass, Account account) throws Exception {
        String sql = "UPDATE ACCOUNT SET USERNAME=?, PASSWORD=?, ROLEID=? WHERE USERNAME=? AND PASSWORD=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, account.getUserName());
        pst.setString(2, account.getPassWord());
        pst.setInt(3, account.getRoleId());
        pst.setString(4, name);
        pst.setString(5, pass);
        pst.executeUpdate();
    }

    public void deleteAccount(String useName, String PassWord) throws Exception {
        String sql = "DELETE FROM ACCOUNT WHERE USERNAME=? AND PASSWORD=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, useName);
        pst.setString(2, PassWord);
        pst.executeUpdate();
    }

    public static void main(String[] args) throws Exception {
        /*ArrayList<Account> list = new AccountDB().getAllAccount();
        for (Account u : list) {
            System.out.println(u);
        }*/
// new AccountDB().addAccount(new Account("vando", "vando", 0));
/*System.out.println(new AccountDB().Login("tandfo","tando"));
    }*/
