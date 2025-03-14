/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lasic
 */
public class GovernmentDeductionTest {

    private GovernmentDeduction deduction;

    @Before
    public void setUp() {
        // Using a test salary that covers different deduction calculations
        deduction = new GovernmentDeduction(90000.00);
    }

    @After
    public void tearDown() {
        deduction = null;
    }

    @Test
    public void testGetSSS() {
        System.out.println("getSSS");
        double expected = GovernmentDeduction.calculateSSS(90000.00);
        double actual = deduction.getSSS();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testGetPagIbig() {
        System.out.println("getPagIbig");
        double expected = GovernmentDeduction.calculatePagIbig(90000.00);
        double actual = deduction.getPagIbig();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testGetPhilHealth() {
        System.out.println("getPhilHealth");
        double expected = GovernmentDeduction.calculatePhilHealth(90000.00);
        double actual = deduction.getPhilHealth();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testGetTotalDeductions() {
        System.out.println("getTotalDeductions");
        double expected = deduction.getSSS() + deduction.getPagIbig() + deduction.getPhilHealth();
        double actual = deduction.getTotalDeductions();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateSSS() {
        System.out.println("calculateSSS");
        double grossSalary = 90000.00;
        double expected = 1125.00;
        double actual = GovernmentDeduction.calculateSSS(grossSalary);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculatePagIbig() {
        System.out.println("calculatePagIbig");
        double grossPay = 90000.00;
        double expected = 100.00; // Pag-IBIG maxes out at 100
        double actual = GovernmentDeduction.calculatePagIbig(grossPay);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculatePhilHealth() {
        System.out.println("calculatePhilHealth");
        double grossIncome = 90000.00;
        double expected = 900.00; // PhilHealth cap for 90k salary
        double actual = GovernmentDeduction.calculatePhilHealth(grossIncome);
        assertEquals(expected, actual, 0.01);
    }
}
