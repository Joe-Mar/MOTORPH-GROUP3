/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
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
public class WorkHoursTest {
    
    public WorkHoursTest() {
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
     * Test of getAllWorkHours method, of class WorkHours.
     */
    @Test
public void testGetAllWorkHours() {
    System.out.println("getAllWorkHours");

    //  Get Actual Data from WorkHoursManager
    List<WorkHoursRecord> result = WorkHours.getAllWorkHours();

    // Print the Actual Output
    System.out.println("===== ACTUAL OUTPUT FROM WorkHoursManager.computeWorkHours() =====");
    result.forEach(System.out::println);

    //  Debugging: Comment out `fail()`
    // fail("Debugging output only - check actual data");

    //  Manually check output before adding assertions
    assertNotNull("Result should not be null", result);
    assertFalse("Result should not be empty", result.isEmpty());
}

    
    /**
     * Test of getTotalRegularHours method, of class WorkHours.
     */
    @Test
    public void testGetTotalRegularHours() {
        System.out.println("getTotalRegularHours");
        int empId = 10001;
        
        // Convert string date to LocalDate
        LocalDate startDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        double expResult = 8.0;  // Expected Regular Hours
        double result = WorkHours.getTotalRegularHours(empId, startDate, endDate);
        
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getTotalOvertimeHours method, of class WorkHours.
     */
    @Test
    public void testGetTotalOvertimeHours() {
        System.out.println("getTotalOvertimeHours");
        int empId = 10001;
        
        // Convert string date to LocalDate
        LocalDate startDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        double expResult = 1.53;  // Expected Overtime Hours
        double result = WorkHours.getTotalOvertimeHours(empId, startDate, endDate);
        
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getTotalLateMinutes method, of class WorkHours.
     */
    @Test
    public void testGetTotalLateMinutes() {
        System.out.println("getTotalLateMinutes");
        int empId = 10001;
        
        // Convert string date to LocalDate
        LocalDate startDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        double expResult = 59.0;  // Expected Late Minutes
        double result = WorkHours.getTotalLateMinutes(empId, startDate, endDate);
        
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getTotalLateDeductions method, of class WorkHours.
     */
    @Test
    public void testGetTotalLateDeductions() {
        System.out.println("getTotalLateDeductions");
        int empId = 10001;
        double hourlyRate = 535.71;
        
        // Convert string date to LocalDate
        LocalDate startDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse("06/03/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        // Late Deduction Formula: (Hourly Rate ÷ 60) × Late Minutes
        double expResult = (hourlyRate / 60) * 59.0;
        double result = WorkHours.getTotalLateDeductions(empId, startDate, endDate, hourlyRate);
        
        assertEquals(expResult, result, 0.01);
    }
}


