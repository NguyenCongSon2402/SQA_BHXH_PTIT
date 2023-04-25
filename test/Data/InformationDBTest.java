/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Data;

import Model.Information;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CongSon
 */
public class InformationDBTest {
    
    public InformationDBTest() {
    }

    @Test
    public void testGetImformationListEx1() throws Exception {
        InformationDB informationDAO = new InformationDB();
        String t = "2-2019";
        int status1 = 1; // Đã nhận nộp tiền bhxh
        int status2 = 2;
        int status3 = 3; //Nhận tiền hỗ trợ
        int status4 = 4;
        String province = "Nam Định";
        
        // test status 1
        ArrayList<Information> result1 = informationDAO.getImformationList(t, status1, province);
        for (Information info : result1) {
            assertTrue(info.getFee().getPayment() == 1);
            assertTrue(info.getFee().getInsuarance() != 0);
        }
        
//        // test status 2
//        ArrayList<Information> result2 = informationDAO.getImformationList(t, status2, province);
//        for (Information info : result2) {
//            assertTrue(info.getFee().getPayment() == 0);
//            //assertTrue(info.getFee().getInsuarance() != 0);
//        }
//        
//        // test status 3
//        ArrayList<Information> result3 = informationDAO.getImformationList(t, status3, province);
//        for (Information info : result3) {
//            assertTrue(info.getFee().getRecive() == 1);
//            //assertTrue(info.getFee().getSubsidy() != 0);
//        }
//        
//        // test status 4
//        ArrayList<Information> result4 = informationDAO.getImformationList(t, status4, province);
//        for (Information info : result4) {
//            assertTrue(info.getFee().getRecive() == 0);
//            //assertTrue(info.getFee().getSubsidy() != 0);
//        }
   
    }
    public void testGetImformationListEx2() throws Exception {
        InformationDB informationDAO = new InformationDB();
        String t = "2-2019";
        // Đã nhận nộp tiền bhxh
        int status2 = 2;
        
        String province = "Nam Định";
        
                // test status 2
        ArrayList<Information> result2 = informationDAO.getImformationList(t, status2, province);
        for (Information info : result2) {
            assertTrue(info.getFee().getPayment() == 0);
            assertTrue(info.getFee().getInsuarance() != 0);
        }
    }
    public void testGetImformationListEx3() throws Exception {
        InformationDB informationDAO = new InformationDB();
        String t = "2-2019";
        // Đã nhận nộp tiền bhxh
        int status3 = 3;
        
        String province = "Nam Định";
        
                // test status 3
        ArrayList<Information> result3 = informationDAO.getImformationList(t, status3, province);
        for (Information info : result3) {
            assertTrue(info.getFee().getRecive() == 1);
            assertTrue(info.getFee().getSubsidy() != 0);
        }
    }
    public void testGetImformationListEx4() throws Exception {
        InformationDB informationDAO = new InformationDB();
        String t = "2-2019";
        // Đã nhận nộp tiền bhxh
        int status4 = 4;
        
        String province = "Nam Định";
        
         //test status 4
        ArrayList<Information> result4 = informationDAO.getImformationList(t, status4, province);
        for (Information info : result4) {
            assertTrue(info.getFee().getRecive() == 0);
            assertTrue(info.getFee().getSubsidy() != 0);
        }
    }
    
}
