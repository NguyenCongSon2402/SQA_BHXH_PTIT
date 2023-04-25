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
    public void testGetStaff() throws Exception {
        String key1="son";
        String key2="2402";
        
        StaffDB staffDB = new StaffDB();
        Staff staff = staffDB.getStaff(key1,key2);
        assertEquals("son", staff.getUserName());
        assertEquals("Dev", staff.getDepartment());
        assertEquals("Nguyễn Công Sơn", staff.getFullName());
        assertEquals(2001, staff.getBirthYear());
        assertEquals("Nam Định", staff.getHomeTown());
    }   
}
