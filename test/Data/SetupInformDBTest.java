/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Data;

import Model.SalaryLimit;
import Model.SetupInform;
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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoadDriver() throws Exception {
    }

    @Test
    public void testGetConnection() throws Exception {
    }

    @Test
    public void testGetStatement() throws Exception {
    }

    @Test
    public void testCloseConnection() throws Exception {
    }

    @Test
    public void testExecuteUpdate() throws Exception {
    }

    @Test
    public void testGetSalaryLimit() throws Exception {
        try {
            double maxSalary = 22.0, minSalary =22.0;
            SetupInformDB dao = new SetupInformDB(); // replace with your DAO class
            SalaryLimit result = dao.getSalaryLimit();
            Assert.assertEquals(maxSalary, result.getMaxSalary(),0.0);
            Assert.assertEquals(minSalary, result.getMinSalary(),0.0);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetSalaryRegion() throws Exception {
        SetupInformDB dao = new SetupInformDB();
        long expected = 300000;
        int key=1;
        long actual = dao.getSalaryRegion(key);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFundPercent() throws Exception {
        SetupInformDB dao = new SetupInformDB();
        double expected = 7;
        int key=1;
        double actual = dao.getFundPercent(key);
        assertEquals(expected, actual,0.0);
        
    }

    @Test
    public void testGetSetupImformation() throws Exception {
        SetupInform setupInform = new SetupInformDB().getSetupImformation();
        
        // check fund percent values
        assertEquals(0.015, setupInform.getFundPercent().getFund1(), 0.001);
        assertEquals(0.01, setupInform.getFundPercent().getFund2(), 0.001);
        assertEquals(0.02, setupInform.getFundPercent().getFund3(), 0.001);
        assertEquals(0.015, setupInform.getFundPercent().getFund4(), 0.001);
        assertEquals(0.01, setupInform.getFundPercent().getFund5(), 0.001);
        
        // check salary limit values
        assertEquals(25000000.0, setupInform.getSalaryLimit().getMaxSalary(), 0.001);
        assertEquals(1500000.0, setupInform.getSalaryLimit().getMinSalary(), 0.001);
        
        // check salary region values
        assertEquals(5000000, setupInform.getSalaryRegion().getRegion1());
        assertEquals(6000000, setupInform.getSalaryRegion().getRegion2());
        assertEquals(7000000, setupInform.getSalaryRegion().getRegion3());
        assertEquals(8000000, setupInform.getSalaryRegion().getRegion4());
    }

    @Test
    public void testSetFundPercent() throws Exception {
    }

    @Test
    public void testSetSalaryRegion() throws Exception {
    }

    @Test
    public void testSetSalaryLimit() throws Exception {
    }

    @Test
    public void testMain() throws Exception {
    }
    
}
