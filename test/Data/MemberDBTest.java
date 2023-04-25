/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Data;

import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author CongSon
 */
public class MemberDBTest {
    private MemberDB memberDB;

    
    public MemberDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        memberDB = new MemberDB();
    }
    
    @After
    public void tearDown() throws SQLException {
        memberDB.closeConnection();
    }


    @Test
    public void testCountMember() throws Exception {
        int newMember = memberDB.countMember(1, "2019-01___", "Nam Định");
        int allMember = memberDB.countMember(2, "2019-01___", "Nam Định");
        int outMember = memberDB.countMember(3, "1-2019", "Nam Định");

        Assert.assertEquals(7, newMember); // change expected value based on your database
        Assert.assertEquals(0, allMember);
        Assert.assertEquals(7, outMember);
    }

   
    
}
