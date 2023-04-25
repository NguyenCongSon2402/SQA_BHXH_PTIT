/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Data;

import Model.Staff;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CongSon
 */
public class StaffDBTest {
    
    public StaffDBTest() {
    }
    
   
    @Test
    public void testLoadDriver() throws Exception {
        StaffDB staffDB = new StaffDB();
        staffDB.loadDriver();
        assertNotNull(staffDB.getConnection());
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
        StaffDB staffDB = new StaffDB();
        String strSQL = "INSERT INTO STAFF_LIST VALUES('test', 'test', 'test', 1990, 'test')";
        staffDB.executeUpdate(strSQL);

        Staff staff = staffDB.getStaff("test", "test");
        assertNotNull(staff);
        assertEquals("test", staff.getUserName());
        assertEquals("test", staff.getDepartment());
        assertEquals("test", staff.getFullName());
        assertEquals(1990, staff.getBirthYear());
        assertEquals("test", staff.getHomeTown());
    }

    @Test
    public void testGetStaff() throws Exception {
        StaffDB staffDB = new StaffDB();
        Staff staff = staffDB.getStaff("tando", "12345678");
        assertEquals("tando", staff.getUserName());
        assertEquals("Phòng nhân sự", staff.getDepartment());
        assertEquals("Nguyễn Văn Tân", staff.getFullName());
        assertEquals(1990, staff.getBirthYear());
        assertEquals("Bắc Ninh", staff.getHomeTown());
    }

    
}
