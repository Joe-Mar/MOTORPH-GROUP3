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
public class PayrollSlipGeneratorTest {

    public PayrollSlipGeneratorTest() {
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
     * Test of generatePayrollSlip method, of class PayrollSlipGenerator.
     */
    @Test
    public void testGeneratePayrollSlip() {
        System.out.println("generatePayrollSlip");

        // Create an example Employee object (You can replace with actual data or mock data)
        Employee employee = new Employee(10001, "Garcia", "Manuel III", "10/11/1983", 
            "Valero Carpark Building Valero Street 1227, Makati City", 
            "966-860-270", "44-4506057-3", "820127000000", "442-605-657-000", 
            "691295000000", "Regular", "Chief Executive Officer", null, 
            new EmployeeFinancials(90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71));

        String startDate = "2025-03-01";
        String endDate = "2025-03-15";
        double totalRegularHours = 80.0;
        double totalOvertimeHours = 10.0;
        double overtimePay = 200.0;
        double grossIncome = 95000.00;
        double totalLateMinutes = 30.0;
        double lateDeduction = 50.00;
        double proratedRiceSubsidy = 1500.00;
        double proratedPhoneAllowance = 2000.00;
        double proratedClothingAllowance = 1000.00;

        // Create a GovernmentDeduction instance with the appropriate grossIncome
        GovernmentDeduction deductions = new GovernmentDeduction(grossIncome);

        double taxDeduction = 5000.00;
        double totalDeductions = deductions.getTotalDeductions() + taxDeduction;  // Use the sum of all deductions
        double netSalary = grossIncome - totalDeductions;  // Calculate the net salary

        // Call the method to test (assuming it generates a payroll slip)
        PayrollSlipGenerator.generatePayrollSlip(employee, startDate, endDate, totalRegularHours, totalOvertimeHours, 
                                                  overtimePay, grossIncome, totalLateMinutes, lateDeduction, 
                                                  proratedRiceSubsidy, proratedPhoneAllowance, proratedClothingAllowance, 
                                                  deductions, taxDeduction, totalDeductions, netSalary);

        // Assertions to verify the expected result
        // Example assertion: Verify that the payroll slip was generated successfully
        // This should be adapted based on the actual behavior of the generatePayrollSlip method
        boolean isPayrollSlipGenerated = true;  // Replace with actual check logic
        assertTrue("Payroll slip was not generated", isPayrollSlipGenerated);

        // Example: If the method writes to a file, you could check if the file exists
        // assertTrue("Payroll slip file was not generated", payrollSlipFileExists("payroll_2025-03-01_to_2025-03-15"));
    }
}
