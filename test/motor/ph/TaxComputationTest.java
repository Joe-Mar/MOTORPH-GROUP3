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
public class TaxComputationTest {
    
    public TaxComputationTest() {
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
     * Test of computeTax method, of class TaxComputation.
     */
    @Test
public void testComputeTax() {
    System.out.println("computeTax");

    // Taxable income = 20,000 should result in no tax (0)
    assertEquals(0.0, TaxComputation.computeTax(20000), 0.01);

    // Taxable income = 20,833 should result in no tax (0)
    assertEquals(0.0, TaxComputation.computeTax(20833), 0.01);

    // Taxable income = 20,933 should be taxed at 20% above 20,833
    assertEquals(20.0, TaxComputation.computeTax(20933), 0.01); // Expected tax = (20933 - 20833) * 0.20 = 20.0

    // Taxable income = 33,333 should be taxed at 20% above 20,833
    assertEquals(2500.0, TaxComputation.computeTax(33333), 0.01); // Expected tax = 2500.0 (fixed + 20% of amount over 20,833)

    // Taxable income = 36,667 should be taxed at 25% above 33,333, plus 2500.0
    assertEquals(3333.5, TaxComputation.computeTax(36667), 0.01);

    // Taxable income = 66,667 should be taxed at 25% above 33,333, plus 2500.0
    assertEquals(10833.5, TaxComputation.computeTax(66667), 0.01);

    // Taxable income = 166,667 should be taxed at 30% above 66,667, plus 10,833
    assertEquals(40833.0, TaxComputation.computeTax(166667), 0.01);

    // Taxable income = 666,667 should be taxed at 32% above 166,667, plus 40,833.33
    assertEquals(200833.33, TaxComputation.computeTax(666667), 0.01);

    // Taxable income = 1,166,667 should be taxed at 35% above 666,667, plus 200,833.33
    assertEquals(375833.329, TaxComputation.computeTax(1166667), 0.01);
}

    /**
     * Test of getTaxableAllowances method, of class TaxComputation.
     */
   @Test
public void testGetTaxableAllowances() {
    System.out.println("getTaxableAllowances");

    // No allowances exceed non-taxable limits
    assertEquals(0.0, TaxComputation.getTaxableAllowances(1000, 1500, 800), 0.01);

    // Phone allowance exceeds non-taxable by 500
    assertEquals(700.0, TaxComputation.getTaxableAllowances(1700, 1500, 800), 0.01);

    // Rice subsidy exceeds non-taxable by 200
    assertEquals(200.0, TaxComputation.getTaxableAllowances(1000, 1500, 1000), 0.01);

    // Phone and rice exceed non-taxable, so total taxable = 1000 (phone) + 500 (rice)
    assertEquals(1700.0, TaxComputation.getTaxableAllowances(2000, 2000, 1000), 0.01);

    // Phone allowance exceeds non-taxable by 200, rice exceeds by 300
    assertEquals(700.0, TaxComputation.getTaxableAllowances(1200, 1800, 1000), 0.01);
}
}


