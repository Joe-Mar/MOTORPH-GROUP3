/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

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
public class EmployeeDataManagerTest {
    
    public EmployeeDataManagerTest() {
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
     * Test of readFromCSV method, of class EmployeeDataManager.
     */
    @Test
public void testReadFromCSV() {
    System.out.println("readFromCSV");

    // Call the method
    List<Employee> result = EmployeeDataManager.readFromCSV();

    // Ensure the result is NOT null
    assertNotNull("Employee list should not be null", result);

    // Optionally, check if it contains expected data (e.g., size > 0)
    assertFalse("Employee list should not be empty", result.isEmpty());

    // Print the size for debugging
    System.out.println("Employee list size: " + result.size());
}
}