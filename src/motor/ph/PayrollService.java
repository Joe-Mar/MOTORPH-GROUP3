/*
 * PayrollService.java
 * 
 * This class handles payroll processing for employees. It calculates gross salary, 
 * deductions, allowances, and net salary for a given employee within a specified date range.
 */
package motor.ph;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * PayrollService provides methods for processing payroll, computing employee
 * salaries, deductions, and generating payroll slips.
 * 
 * @author lasic
 */
public class PayrollService {

    /**
     * Processes payroll for a given employee within a specified date range.
     *
     * @param employeeId The ID of the employee whose payroll is being processed.
     * @param startDate  The start date of the payroll period (format: MM/dd/yyyy).
     * @param endDate    The end date of the payroll period (format: MM/dd/yyyy).
     */
    public static void processPayroll(int employeeId, String startDate, String endDate) {
        // Retrieve employee details based on the provided ID
        Employee employee = EmployeeService.getEmployeeByEmployeeId(employeeId);
        if (employee == null) {
            System.out.println("Error: Employee not found.");
            return;
        }

        // Formatter to parse date strings into LocalDate objects
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            // Convert string dates to LocalDate format
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);
            
            // Create instance of WorkHoursManager to fetch work hour details
            WorkHoursManager workHoursManager = new WorkHoursManager();

            // Determine payroll type (Currently set to semi-monthly by default)
            boolean isWeekly = false;
            boolean isSemiMonthly = true;

            // Fetch employee's work details for the given payroll period
            double totalRegularHours = workHoursManager.calculateTotalRegularHours(employeeId, start, end);
            double totalLateMinutes = workHoursManager.calculateTotalLateMinutes(employeeId, start, end);
            double totalOvertimeHours = workHoursManager.calculateTotalOvertimeHours(employeeId, start, end);

            // Compute semi-monthly salary (Basic Salary / 2)
            double semiMonthlySalary = employee.getFinancials().getBasicSalary() / 2;

            // Compute Overtime Pay
            double overtimePay = PayrollProcessor.calculateOvertimePay(employee.getFinancials(), totalOvertimeHours);

            // Compute Gross Income (Basic Semi-Monthly Salary + Overtime Pay)
            double grossIncome = semiMonthlySalary + overtimePay;

            // Compute Late Deduction (Hourly Rate / 60 * Total Late Minutes)
            double hourlyRate = semiMonthlySalary / totalRegularHours;
            double lateDeduction = (hourlyRate / 60) * totalLateMinutes;

            // Compute Government Deductions (e.g., SSS, PhilHealth, Pag-IBIG)
            GovernmentDeduction deductions = new GovernmentDeduction(grossIncome);
            double totalDeductions = deductions.getTotalDeductions() + lateDeduction;

            // Compute Tax Deduction based on taxable income
            double taxDeduction = TaxComputation.computeTax(grossIncome - totalDeductions);
            totalDeductions += taxDeduction;

            // Compute Prorated Allowances for Semi-Monthly Payroll
            double proratedRiceSubsidy = employee.getFinancials().getRiceSubsidy() / 2;
            double proratedPhoneAllowance = employee.getFinancials().getPhoneAllowance() / 2;
            double proratedClothingAllowance = employee.getFinancials().getClothingAllowance() / 2;

            // Compute Net Salary (Gross Income + Allowances - Deductions)
            double netSalary = PayrollProcessor.calculateNetSalary(
                grossIncome + proratedRiceSubsidy + proratedPhoneAllowance + proratedClothingAllowance, 
                totalDeductions
            );

            // Generate Payroll Slip with all calculated details
            PayrollSlipGenerator.generatePayrollSlip(
                employee, startDate, endDate, totalRegularHours, totalOvertimeHours,
                overtimePay, grossIncome, totalLateMinutes, lateDeduction, 
                proratedRiceSubsidy, proratedPhoneAllowance, proratedClothingAllowance, 
                deductions, taxDeduction, totalDeductions, netSalary
            );

        } catch (DateTimeParseException e) {
            System.err.println("Error: Invalid date format. Expected MM/dd/yyyy but got: " + startDate + " or " + endDate);
        }
    }
}
