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
public class WorkHoursRecordTest {
    
    public WorkHoursRecordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getEmployeeId method, of class WorkHoursRecord.
     */
    @Test
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        WorkHoursRecord instance = new WorkHoursRecord(10001, "2025-03-08", 8.0, 2.0, 10.0, 50.0);
        int expResult = 10001;
        int result = instance.getEmployeeId();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getDate method, of class WorkHoursRecord.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        WorkHoursRecord instance = new WorkHoursRecord(10001, "2025-03-08", 8.0, 2.0, 10.0, 50.0);
        String expResult = "2025-03-08";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRegularHours method, of class WorkHoursRecord.
     */
    @Test
    public void testGetRegularHours() {
        System.out.println("getRegularHours");
        WorkHoursRecord instance = new WorkHoursRecord(10001, "2025-03-08", 8.0, 2.0, 10.0, 50.0);
        double expResult = 8.0;
        double result = instance.getRegularHours();
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of getOvertimeHours method, of class WorkHoursRecord.
     */
    @Test
    public void testGetOvertimeHours() {
        System.out.println("getOvertimeHours");
        WorkHoursRecord instance = new WorkHoursRecord(10001, "2025-03-08", 8.0, 2.0, 10.0, 50.0);
        double expResult = 2.0;
        double result = instance.getOvertimeHours();
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of getLateMinutes method, of class WorkHoursRecord.
     */
    @Test
    public void testGetLateMinutes() {
        System.out.println("getLateMinutes");
        WorkHoursRecord instance = new WorkHoursRecord(10001, "2025-03-08", 8.0, 2.0, 10.0, 50.0);
        double expResult = 10.0;
        double result = instance.getLateMinutes();
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of getLateDeduction method, of class WorkHoursRecord.
     */
    @Test
    public void testGetLateDeduction() {
        System.out.println("getLateDeduction");
        WorkHoursRecord instance = new WorkHoursRecord(10001, "2025-03-08", 8.0, 2.0, 10.0, 50.0);
        double expResult = 50.0;
        double result = instance.getLateDeduction();
        assertEquals(expResult, result, 0);
    }
}


