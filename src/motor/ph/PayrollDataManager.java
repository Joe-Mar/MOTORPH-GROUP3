/*
 * PayrollDataManager.java
 * 
 * This class handles payroll processing for all employees. It calculates 
 * total work hours, gross salary, deductions, and net salary for each employee.
 */

package motor.ph;

import java.time.LocalDate;
import java.util.List;

/**
 * The PayrollDataManager class processes payroll for all employees by 
 * calculating work hours, gross salary, deductions, and net salary.
 */
public class PayrollDataManager {

    /**
     * Processes payroll for all employees in the provided list.
     * 
     * @param employees List of Employee objects whose payroll needs to be processed.
     */
    public static void processPayrollForAllEmployees(List<Employee> employees) {
        WorkHoursManager workHoursManager = new WorkHoursManager(); // Create an instance of WorkHoursManager
        LocalDate today = LocalDate.now(); // Get the current date

        // Iterate through each employee and compute payroll details
        for (Employee employee : employees) {
            // Calculate total work hours for the employee (for the current day)
            double totalHours = workHoursManager.calculateTotalWorkHours(0, today, today);

            // Compute the employee's gross salary based on total hours worked
            double grossSalary = PayrollProcessor.calculateGrossSalary(employee.getFinancials(), totalHours);

            // Compute total deductions for the employee
            double deductions = SalaryCalculator.computeDeductions(grossSalary);

            // Compute the net salary after deductions
            double netSalary = PayrollProcessor.calculateNetSalary(grossSalary, deductions);

            // Print the payroll summary for the employee
            System.out.printf("Payroll Processed: ID: %d | Name: %s %s | Gross: %.2f | Deductions: %.2f | Net: %.2f\n",
                    employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), grossSalary, deductions, netSalary);
        }
    }
}
