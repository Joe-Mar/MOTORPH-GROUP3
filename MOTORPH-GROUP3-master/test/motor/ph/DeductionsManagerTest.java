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
public class DeductionsManagerTest {
    
    private DeductionsManager deductionsManager;

    public DeductionsManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Initialize DeductionsManager before each test
        deductionsManager = new DeductionsManager();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of computeSSS method, of class DeductionsManager.
     */
    @Test
    public void testComputeSSS() {
        System.out.println("computeSSS");
        double grossSalary = 20000.0;  // Sample salary
        double expResult = 900.0;  // Adjust based on your formula
        double result = deductionsManager.computeSSS(grossSalary);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of computePagIbig method, of class DeductionsManager.
     */
    @Test
    public void testComputePagIbig() {
        System.out.println("computePagIbig");
        double grossSalary = 20000.0;  // Sample salary
        double expResult = 100.0;  // Adjust based on your formula
        double result = deductionsManager.computePagIbig(grossSalary);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of computePhilHealth method, of class DeductionsManager.
     */
    @Test
    public void testComputePhilHealth() {
    System.out.println("computePhilHealth");
    double grossSalary = 20000.0;  // Sample salary
    double expResult = 700.0;  // Adjusted expected value (based on actual function)
    double result = deductionsManager.computePhilHealth(grossSalary);
    assertEquals(expResult, result, 0.01);
}
}

