/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;
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
public class EmployeeWorkHoursTest {
    
    public EmployeeWorkHoursTest() {
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
     * Test of getTotalRegularHours method, of class EmployeeWorkHours.
     */
    @Test
    public void testGetTotalRegularHours() {
        System.out.println("getTotalRegularHours");
        int empId = 10001;
        LocalDate startDate = LocalDate.of(2024, 6, 3);
        LocalDate endDate = LocalDate.of(2024, 6, 3);
        
        double expResult = 8.0;  // Expected Regular Hours
        double result = EmployeeWorkHours.getTotalRegularHours(empId, startDate, endDate);
        
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getTotalOvertimeHours method, of class EmployeeWorkHours.
     */
    @Test
    public void testGetTotalOvertimeHours() {
        System.out.println("getTotalOvertimeHours");
        int empId = 10001;
        LocalDate startDate = LocalDate.of(2024, 6, 3);
        LocalDate endDate = LocalDate.of(2024, 6, 3);
        
        double expResult = 1.53;  // Expected Overtime Hours
        double result = EmployeeWorkHours.getTotalOvertimeHours(empId, startDate, endDate);
        
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getTotalLateMinutes method, of class EmployeeWorkHours.
     */
    @Test
    public void testGetTotalLateMinutes() {
        System.out.println("getTotalLateMinutes");
        int empId = 10001;
        LocalDate startDate = LocalDate.of(2024, 6, 3);
        LocalDate endDate = LocalDate.of(2024, 6, 3);
        
        double expResult = 59.0;  // Expected Late Minutes
        double result = EmployeeWorkHours.getTotalLateMinutes(empId, startDate, endDate);
        
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getTotalLateDeductions method, of class EmployeeWorkHours.
     */
    @Test
    public void testGetTotalLateDeductions() {
        System.out.println("getTotalLateDeductions");
        int employeeId = 10001;
        LocalDate startDate = LocalDate.of(2024, 6, 3);
        LocalDate endDate = LocalDate.of(2024, 6, 3);
        double hourlyRate = 535.71;
        
        // Late Deduction Formula: (Hourly Rate ÷ 60) × Late Minutes
        double expResult = (hourlyRate / 60) * 59.0;
        double result = EmployeeWorkHours.getTotalLateDeductions(employeeId, startDate, endDate, hourlyRate);
        
        assertEquals(expResult, result, 0.01);
    }
}


