/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lasic
 */
public class AttendanceRecordTest {
    
    private AttendanceRecord instance;

    public AttendanceRecordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Initialize a valid instance before each test
        instance = new AttendanceRecord(10001, "Garcia", "Manuel", "2024-06-03", "08:00", "17:00");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDate method, of class AttendanceRecord.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        String expResult = "2024-06-03";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLogin method, of class AttendanceRecord.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        String expResult = "08:00";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLogout method, of class AttendanceRecord.
     */
    @Test
    public void testGetLogout() {
        System.out.println("getLogout");
        String expResult = "17:00";
        String result = instance.getLogout();
        assertEquals(expResult, result);
    }

    /**
     * Test of printAttendanceDetails method, of class AttendanceRecord.
     */
    @Test
    public void testPrintAttendanceDetails() {
        System.out.println("printAttendanceDetails");
        instance.printAttendanceDetails();  
    }

    /**
     * Test of printDetails method, of class AttendanceRecord.
     */
    @Test
    public void testPrintDetails() {
        System.out.println("printDetails");
        instance.printDetails();  
    }
}




