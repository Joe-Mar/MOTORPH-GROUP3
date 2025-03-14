/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
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
public class WorkHoursServiceTest {
    
    public WorkHoursServiceTest() {
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
     * Test of readCSV method, of class WorkHoursService.
     */
    @Test
    public void testReadCSV() {
        System.out.println("readCSV");
        List<String[]> result = WorkHoursService.readCSV();
        assertNotNull(result);
        assertFalse(result.isEmpty());

        // Validate structure of first row
        String[] firstRow = result.get(0);
        assertNotNull(firstRow);
        assertTrue(firstRow.length > 0); 
    }
    
    /**
     * Test of isDateInRange method, of class WorkHoursService.
     */
     @Test
    public void testIsDateInRange() {
        System.out.println("isDateInRange");
        
        // Ensure date format matches the expected input format in WorkHoursService
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateStr = "03/08/2025";  // Format changed to MM/dd/yyyy to match common CSV formats

        LocalDate startDate = LocalDate.of(2025, 3, 1);
        LocalDate endDate = LocalDate.of(2025, 3, 15);
        
        boolean expResult = true;
        boolean result = WorkHoursService.isDateInRange(dateStr, startDate, endDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of viewWorkHours method, of class WorkHoursService.
     */
    @Test
    public void testViewWorkHours() {
        System.out.println("viewWorkHours");
        Scanner scanner = new Scanner("2025-03-08\n");
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            WorkHoursService.viewWorkHours(scanner, DATE_FORMATTER);
        } catch (Exception e) {
            fail("Exception thrown during viewWorkHours execution: " + e.getMessage());
        }
    }
}
