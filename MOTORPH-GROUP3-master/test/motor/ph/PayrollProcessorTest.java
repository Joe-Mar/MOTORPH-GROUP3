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
public class PayrollProcessorTest {

    public PayrollProcessorTest() {
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
     * Test of calculateGrossSalary method, of class PayrollProcessor.
     */
    @Test
    public void testCalculateGrossSalary() {
        System.out.println("calculateGrossSalary");
        // Creating a mock EmployeeFinancials object
        EmployeeFinancials financials = new EmployeeFinancials(90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71);
        double totalRegularHours = 40.0;  // Sample value for total regular hours worked in a week
        double expResult = 20454.545454545456;  // Expected result, calculated based on the given financials and hours
        double result = PayrollProcessor.calculateGrossSalary(financials, totalRegularHours);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of calculateOvertimePay method, of class PayrollProcessor.
     */
    @Test
    public void testCalculateOvertimePay() {
        System.out.println("calculateOvertimePay");
        // Creating a mock EmployeeFinancials object
        EmployeeFinancials financials = new EmployeeFinancials(90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71);
        double totalOvertimeHours = 5.0;  // Sample value for total overtime hours
        double expResult = 3196.0227272727275;  // Expected result based on the overtime calculation (25% of hourly rate)
        double result = PayrollProcessor.calculateOvertimePay(financials, totalOvertimeHours);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of calculateLateDeduction method, of class PayrollProcessor.
     */
    @Test
    public void testCalculateLateDeduction() {
        System.out.println("calculateLateDeduction");
        // Creating a mock EmployeeFinancials object
        EmployeeFinancials financials = new EmployeeFinancials(90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71);
        double totalLateMinutes = 30.0;  // Sample value for total late minutes
        double expResult = 255.6818181818182;  // Expected result based on late deduction formula
        double result = PayrollProcessor.calculateLateDeduction(financials, totalLateMinutes);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of calculateNetSalary method, of class PayrollProcessor.
     */
    @Test
    public void testCalculateNetSalary() {
        System.out.println("calculateNetSalary");
        double grossSalary = 100000.00;  // Sample gross salary
        double deductions = 20000.00;    // Sample total deductions
        double expResult = 80000.00;      // Expected result, calculated as grossSalary - deductions
        double result = PayrollProcessor.calculateNetSalary(grossSalary, deductions);
        assertEquals(expResult, result, 0);
    }
}


