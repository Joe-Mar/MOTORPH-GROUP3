/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;
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
public class WorkHoursManagerTest {
    
    public WorkHoursManagerTest() {
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
     * Test of computeWorkHours method, of class WorkHoursManager.
     */
    @Test
    public void testComputeWorkHours() {
        System.out.println("computeWorkHours");
        
        //  Expected result should not be null
        List<WorkHoursRecord> result = WorkHoursManager.computeWorkHours();
        
        //  Assertions: Hindi dapat null o empty ang result
        assertNotNull("Result should not be null", result);
        assertFalse("Result should not be empty", result.isEmpty());
        
        //  Print output for debugging
        System.out.println("===== ACTUAL OUTPUT FROM computeWorkHours() =====");
        result.forEach(System.out::println);
    }

    /**
     * Test of calculateTotalRegularHours method, of class WorkHoursManager.
     */
    @Test
    public void testCalculateTotalRegularHours() {
        System.out.println("calculateTotalRegularHours");

        int employeeId = 10001;  // Sample Employee ID (Garcia, Manuel III)
        LocalDate startDate = LocalDate.of(2024, 3, 1);
        LocalDate endDate = LocalDate.of(2024, 3, 7);

        WorkHoursManager instance = new WorkHoursManager();
        double result = instance.calculateTotalRegularHours(employeeId, startDate, endDate);

        //  Assertion:Should not be negative
        assertTrue("Total regular hours should be >= 0", result >= 0);

        System.out.println("Total Regular Hours: " + result);
    }

    /**
     * Test of calculateTotalLateMinutes method, of class WorkHoursManager.
     */
    @Test
    public void testCalculateTotalLateMinutes() {
        System.out.println("calculateTotalLateMinutes");

        int employeeId = 10001;
        LocalDate startDate = LocalDate.of(2024, 3, 1);
        LocalDate endDate = LocalDate.of(2024, 3, 7);

        WorkHoursManager instance = new WorkHoursManager();
        double result = instance.calculateTotalLateMinutes(employeeId, startDate, endDate);

        //  Assertion: Should not be Negative
        assertTrue("Total late minutes should be >= 0", result >= 0);

        System.out.println("Total Late Minutes: " + result);
    }

    /**
     * Test of calculateTotalOvertimeHours method, of class WorkHoursManager.
     */
    @Test
    public void testCalculateTotalOvertimeHours() {
        System.out.println("calculateTotalOvertimeHours");

        int employeeId = 10001;
        LocalDate startDate = LocalDate.of(2024, 3, 1);
        LocalDate endDate = LocalDate.of(2024, 3, 7);

        WorkHoursManager instance = new WorkHoursManager();
        double result = instance.calculateTotalOvertimeHours(employeeId, startDate, endDate);

        //  Assertion: Should not be Ngeative
        assertTrue("Total overtime hours should be >= 0", result >= 0);

        System.out.println("Total Overtime Hours: " + result);
    }

    /**
     * Test of calculateTotalWorkHours method, of class WorkHoursManager.
     */
    @Test
    public void testCalculateTotalWorkHours() {
        System.out.println("calculateTotalWorkHours");

        int employeeId = 10001;
        LocalDate startDate = LocalDate.of(2024, 3, 1);
        LocalDate endDate = LocalDate.of(2024, 3, 7);

        WorkHoursManager instance = new WorkHoursManager();
        double result = instance.calculateTotalWorkHours(employeeId, startDate, endDate);

        //  Assertion: Should not be negative
        assertTrue("Total work hours should be >= 0", result >= 0);

        System.out.println("Total Work Hours: " + result);
    }
}
