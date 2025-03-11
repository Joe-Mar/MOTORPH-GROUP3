/*
 * PayrollSlipGenerator.java
 * 
 * This class generates and prints the payroll slip for an employee.
 * It displays the earnings, benefits, deductions, and net salary 
 * based on payroll calculations.
 */
package motor.ph;

/**
 * PayrollSlipGenerator is responsible for formatting and printing
 * the payroll slip for an employee, including salary details, 
 * benefits, and deductions.
 * 
 * @author lasic
 */
public class PayrollSlipGenerator {

    /**
     * Generates and prints the payroll slip for a given employee.
     *
     * @param employee              The employee whose payroll slip is being generated.
     * @param startDate             The start date of the payroll period.
     * @param endDate               The end date of the payroll period.
     * @param totalRegularHours     Total number of regular work hours for the period.
     * @param totalOvertimeHours    Total number of overtime hours worked.
     * @param overtimePay           Overtime compensation amount.
     * @param grossIncome           Employee's gross income before deductions.
     * @param totalLateMinutes      Total number of minutes the employee was late.
     * @param lateDeduction         Deduction amount due to lateness.
     * @param proratedRiceSubsidy   Half-month rice subsidy amount.
     * @param proratedPhoneAllowance Half-month phone allowance.
     * @param proratedClothingAllowance Half-month clothing allowance.
     * @param deductions            Government-mandated deductions (SSS, PhilHealth, Pag-IBIG).
     * @param taxDeduction          Income tax deduction.
     * @param totalDeductions       Total amount of all deductions.
     * @param netSalary             Employee's take-home pay after deductions.
     */
    public static void generatePayrollSlip(Employee employee, String startDate, String endDate,
                                           double totalRegularHours, double totalOvertimeHours, double overtimePay,
                                           double grossIncome, double totalLateMinutes, double lateDeduction,
                                           double proratedRiceSubsidy, double proratedPhoneAllowance, 
                                           double proratedClothingAllowance, GovernmentDeduction deductions,
                                           double taxDeduction, double totalDeductions, double netSalary) {
        // Print payslip header
        System.out.println("\n====================================");
        System.out.println("        MOTORPH PAYSLIP");
        System.out.println("====================================");
        System.out.println("Period Start: " + startDate);
        System.out.println("Period End: " + endDate);
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("====================================");
        
        // Print earnings section
        System.out.println("\nEARNINGS:");
        System.out.printf("Monthly Rate (Basic Pay): %.2f\n", employee.getFinancials().getBasicSalary());
        System.out.printf("Total Regular Hours: %.2f\n", totalRegularHours);
        System.out.printf("Total Overtime Hours: %.2f\n", totalOvertimeHours);
        System.out.printf("Overtime Pay: %.2f\n", overtimePay);
        System.out.printf("Gross Income: %.2f\n", grossIncome);
        
        // Print late deductions section
        System.out.println("====================================");
        System.out.println("LATE DETAILS:");
        System.out.printf("Total Late Minutes: %.2f\n", totalLateMinutes);
        System.out.printf("Late Deduction: %.2f\n\n", lateDeduction);
        
        // Print benefits section
        System.out.println("====================================");
        System.out.println("BENEFITS:");
        System.out.printf("Rice Subsidy: %.2f\n", proratedRiceSubsidy);
        System.out.printf("Phone Allowance: %.2f\n", proratedPhoneAllowance);
        System.out.printf("Clothing Allowance: %.2f\n", proratedClothingAllowance);
        double totalAllowances = proratedRiceSubsidy + proratedPhoneAllowance + proratedClothingAllowance;
        System.out.printf("Total Benefits: %.2f\n\n", totalAllowances);
        
        // Print deductions section
        System.out.println("====================================");
        System.out.println("DEDUCTIONS:");
        System.out.printf("SSS: %.2f\n", deductions.getSSS());
        System.out.printf("Pag-IBIG: %.2f\n", deductions.getPagIbig());
        System.out.printf("PhilHealth: %.2f\n", deductions.getPhilHealth());
        System.out.printf("Tax: %.2f\n", taxDeduction);
        System.out.printf("Total Deductions: %.2f\n", totalDeductions);
        
        // Print net salary
        System.out.println("====================================");
        System.out.printf("NET SALARY (Take Home Pay): %.2f\n", netSalary);
        System.out.println("====================================");
    }
}
