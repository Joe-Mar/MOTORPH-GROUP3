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
public class EmployeeFinancialsTest {
    
    private EmployeeFinancials instance;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Instantiate with test data
        instance = new EmployeeFinancials(90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetBasicSalary() {
        System.out.println("getBasicSalary");
        assertNotNull(instance);
        assertEquals(90000.00, instance.getBasicSalary(), 0);
    }

    @Test
    public void testGetRiceSubsidy() {
        System.out.println("getRiceSubsidy");
        assertNotNull(instance);
        assertEquals(1500.00, instance.getRiceSubsidy(), 0);
    }

    @Test
    public void testGetPhoneAllowance() {
        System.out.println("getPhoneAllowance");
        assertNotNull(instance);
        assertEquals(2000.00, instance.getPhoneAllowance(), 0);
    }

    @Test
    public void testGetClothingAllowance() {
        System.out.println("getClothingAllowance");
        assertNotNull(instance);
        assertEquals(1000.00, instance.getClothingAllowance(), 0);
    }

    @Test
    public void testGetGrossSemiMonthlyRate() {
        System.out.println("getGrossSemiMonthlyRate");
        assertNotNull(instance);
        assertEquals(45000.00, instance.getGrossSemiMonthlyRate(), 0);
    }

    @Test
    public void testGetHourlyRate() {
        System.out.println("getHourlyRate");
        assertNotNull(instance);
        assertEquals(535.71, instance.getHourlyRate(), 0.01);
    }

    @Test
    public void testGetTotalAllowances() {
        System.out.println("getTotalAllowances");
        assertNotNull(instance);
        assertEquals(4500.00, instance.getTotalAllowances(), 0);
    }

    @Test
    public void testGetProratedTotalAllowance() {
        System.out.println("getProratedTotalAllowance");
        assertNotNull(instance);
        assertEquals(2250.00, instance.getProratedTotalAllowance(20, 10), 0);
    }

    @Test
    public void testComputeAllowance() {
        System.out.println("computeAllowance");
        assertNotNull(instance);
        assertEquals(1125.00, instance.computeAllowance("weekly"), 0);
        assertEquals(2250.00, instance.computeAllowance("semi-monthly"), 0);
        assertEquals(4500.00, instance.computeAllowance("monthly"), 0);
    }

    @Test
    public void testPrintFinancialDetails() {
        System.out.println("printFinancialDetails");
        assertNotNull(instance);
        instance.printFinancialDetails();
    }
}




