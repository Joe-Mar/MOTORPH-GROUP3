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
public class EmployeeServiceTest {
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Create mock employee
        EmployeeFinancials financials = new EmployeeFinancials(90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71);

        Employee testEmployee = new Employee(
            10001, "Garcia", "Manuel III", "10/11/1983",
            "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270",
            "44-4506057-3", "820127000000", "442-605-657-000", "691295000000",
            "Regular", "Chief Executive Officer", "N/A",
            financials
        );
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetEmployeeByEmployeeId() {
        System.out.println("getEmployeeByEmployeeId");
        int empId = 10001;
        Employee result = EmployeeService.getEmployeeByEmployeeId(empId);
        assertNotNull(result);
        assertEquals(empId, result.getEmployeeId());
    }

    @Test
    public void testViewEmployeeDetails() {
        System.out.println("viewEmployeeDetails");
        int employeeId = 10001;
        EmployeeService.viewEmployeeDetails(employeeId);
    }
}


