/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Data;

import Model.SalaryLimit;
import Model.SetupInform;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CongSon
 */
public class SetupInformDBTest {

    public SetupInformDBTest() {
    }
    @Test
    public void testGetSalaryLimit() throws Exception {
        try {
            double maxSalary = 36000000, minSalary = 26000000;
            SetupInformDB dao = new SetupInformDB(); // replace with your DAO class
            SalaryLimit result = dao.getSalaryLimit();
            Assert.assertEquals(maxSalary, result.getMaxSalary(), 0.0);
            Assert.assertEquals(minSalary, result.getMinSalary(), 0.0);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetSalaryRegion() throws Exception {
        SetupInformDB dao = new SetupInformDB();
        long expected = 4680001;
        int key = 1;
        long actual = dao.getSalaryRegion(key);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFundPercent() throws Exception {
        SetupInformDB dao = new SetupInformDB();
        double expected = 0.4;
        int key = 1;
        double actual = dao.getFundPercent(key);
        assertEquals(expected, actual, 0.0);

    }

    @Test
    public void testGetSetupImformation() throws Exception {
        SetupInform setupInform = new SetupInformDB().getSetupImformation();

        // check fund percent values
        assertEquals(0.4, setupInform.getFundPercent().getFund1(), 0.001);
        assertEquals(3, setupInform.getFundPercent().getFund2(), 0.001);
        assertEquals(3, setupInform.getFundPercent().getFund3(), 0.001);
        assertEquals(1, setupInform.getFundPercent().getFund4(), 0.001);
        assertEquals(4, setupInform.getFundPercent().getFund5(), 0.001);

        // check salary limit values
        assertEquals(36000000, setupInform.getSalaryLimit().getMaxSalary(), 0.001);
        assertEquals(26000000, setupInform.getSalaryLimit().getMinSalary(), 0.001);

        // check salary region values
        assertEquals(4680001, setupInform.getSalaryRegion().getSalaryRegion1());
        assertEquals(4160000, setupInform.getSalaryRegion().getSalaryRegion2());
        assertEquals(3640000, setupInform.getSalaryRegion().getSalaryRegion3());
        assertEquals(3250000, setupInform.getSalaryRegion().getSalaryRegion4());
    }

    @Test
    public void testSetFundPercent() throws Exception {
        Connection connection = null;
        // Chuẩn bị dữ liệu
        double fund1 = 0.8;
        int id = 1;
        SetupInformDB setupInformDB = new SetupInformDB();
        connection=setupInformDB.getConnection();
        try {
            connection.setAutoCommit(false);
            setupInformDB.setFundPercent(id, fund1);
            // Kiểm tra kết quả
            double actual = setupInformDB.getFundPercent(id);
            assertEquals(fund1, actual, 0.0);
            connection.rollback();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
                connection.setAutoCommit(true);
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return;
    }

    @Test
    public void testSetSalaryRegion() throws Exception {
        Connection connection = null;
        // Chuẩn bị dữ liệu
        long fund1 = 20;
        int id = 1;
        SetupInformDB setupInformDB = new SetupInformDB();
        connection=setupInformDB.getConnection();
        try {
            connection.setAutoCommit(false);
            setupInformDB.setSalaryRegion(id, fund1);
            // Kiểm tra kết quả
            double actual = setupInformDB.getSalaryRegion(id);
            assertEquals(fund1, actual, 0.0);
            connection.rollback();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
                connection.setAutoCommit(true);
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return;
    }

    @Test
    public void testSetSalaryLimit() throws Exception {
        // Chuẩn bị dữ liệu
        long valueLimit =22,valueLimit1 =21;
        String type ="max";
        String type1="min";
        SetupInformDB setupInformDB = new SetupInformDB();
        Connection connection=setupInformDB.getConnection();
        try {
            connection.setAutoCommit(false);
            setupInformDB.setSalaryLimit(type, valueLimit);
            setupInformDB.setSalaryLimit(type1, valueLimit1);
            // Kiểm tra kết quả
            SalaryLimit actual = setupInformDB.getSalaryLimit();
            //double actual1 = setupInformDB.getSalaryLimit().getMinSalary();
            assertEquals(valueLimit, actual.getMaxSalary(), 0.0);
            assertEquals(valueLimit1, actual.getMinSalary(), 0.0);
            connection.rollback();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
                connection.setAutoCommit(true);
            }
            e.printStackTrace();
        }finally{
            if (connection != null) {
               connection.close();
            }
        }
        return;
    }

}
