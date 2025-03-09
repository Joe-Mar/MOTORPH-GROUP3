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
public class EmployeeTest {
    
    private Employee instance;
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    instance = new Employee(
        10001,  // Employee ID
        "Garcia",  // Last Name
        "Manuel III",  // First Name
        "10/11/1983",  // Birthday
        "Valero Carpark Building Valero Street 1227, Makati City",  // Address
        "966-860-270",  // Phone Number
        "44-4506057-3",  // SSS
        "820127000000",  // PhilHealth
        "442-605-657-000",  // TIN
        "691295000000",  // Pag-IBIG
        "Regular",  // Status
        "Chief Executive Officer",  // Position
        "N/A",  // Immediate Supervisor
        new EmployeeFinancials(  // Financials
            90000.00,  // Basic Salary
            1500.00,   // Rice Subsidy
            2000.00,   // Phone Allowance
            1000.00,   // Clothing Allowance
            45000.00,  // Gross Semi-Monthly Rate
            535.71     // Hourly Rate
        )
    );
}

    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        assertEquals("10/11/1983", instance.getBirthday());
    }

    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        assertEquals("Valero Carpark Building Valero Street 1227, Makati City", instance.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        assertEquals("966-860-270", instance.getPhoneNumber());
    }

    @Test
    public void testGetSss() {
        System.out.println("getSss");
        assertEquals("44-4506057-3", instance.getSss());
    }

    @Test
    public void testGetPhilhealth() {
        System.out.println("getPhilhealth");
        assertEquals("820127000000", instance.getPhilhealth());
    }

    @Test
    public void testGetTin() {
        System.out.println("getTin");
        assertEquals("442-605-657-000", instance.getTin());
    }

    @Test
    public void testGetPagibig() {
        System.out.println("getPagibig");
        assertEquals("691295000000", instance.getPagibig());
    }

    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        assertEquals("Regular", instance.getStatus());
    }

    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        assertEquals("Chief Executive Officer", instance.getPosition());
    }

    @Test
    public void testGetImmediateSupervisor() {
        System.out.println("getImmediateSupervisor");
        assertEquals("N/A", instance.getImmediateSupervisor());
    }

    @Test
    public void testGetFinancials() {
        System.out.println("getFinancials");
        EmployeeFinancials financials = instance.getFinancials();
        assertNotNull(financials);
        assertEquals(90000.00, financials.getBasicSalary(), 0.01);
        assertEquals(1500.00, financials.getRiceSubsidy(), 0.01);
        assertEquals(2000.00, financials.getPhoneAllowance(), 0.01);
        assertEquals(1000.00, financials.getClothingAllowance(), 0.01);
        assertEquals(45000.00, financials.getGrossSemiMonthlyRate(), 0.01);
        assertEquals(535.71, financials.getHourlyRate(), 0.01);
    }

    @Test
    public void testPrintDetails() {
        System.out.println("printDetails");
        instance.printDetails();
    }
}

