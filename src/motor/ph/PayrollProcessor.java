/*
 * PayrollProcessor.java
 * 
 * This class is responsible for payroll calculations, including gross salary, 
 * overtime pay, late deductions, and net salary.
 */

package motor.ph;

/**
 * The PayrollProcessor class provides methods for computing various payroll-related
 * amounts such as gross salary, overtime pay, late deductions, and net salary.
 */
public class PayrollProcessor {
    
    /** The multiplier applied to overtime hours. */
    private static final double OVERTIME_RATE = 1.25; 

    /** The number of working days in a month (typically 22 days). */
    private static final int WORK_DAYS_PER_MONTH = 22; 

    /** The standard number of working hours per day. */
    private static final int WORK_HOURS_PER_DAY = 8; 

    /**
     * Calculates the gross salary based on total regular hours worked.
     * 
     * @param financials The EmployeeFinancials object containing salary details.
     * @param totalRegularHours The total number of regular hours worked by the employee.
     * @return The computed gross salary.
     */
    public static double calculateGrossSalary(EmployeeFinancials financials, double totalRegularHours) {
        double hourlyRate = financials.getBasicSalary() / WORK_DAYS_PER_MONTH / WORK_HOURS_PER_DAY;
        return totalRegularHours * hourlyRate;
    }

    /**
     * Calculates overtime pay based on overtime hours worked.
     * 
     * @param financials The EmployeeFinancials object containing salary details.
     * @param totalOvertimeHours The total number of overtime hours worked.
     * @return The computed overtime pay.
     */
    public static double calculateOvertimePay(EmployeeFinancials financials, double totalOvertimeHours) {
        double hourlyRate = financials.getBasicSalary() / WORK_DAYS_PER_MONTH / WORK_HOURS_PER_DAY;
        return totalOvertimeHours * hourlyRate * OVERTIME_RATE;
    }

    /**
     * Calculates late deduction based on total late minutes.
     * 
     * @param financials The EmployeeFinancials object containing salary details.
     * @param totalLateMinutes The total minutes an employee was late.
     * @return The computed deduction due to lateness.
     */
    public static double calculateLateDeduction(EmployeeFinancials financials, double totalLateMinutes) {
        double hourlyRate = financials.getBasicSalary() / WORK_DAYS_PER_MONTH / WORK_HOURS_PER_DAY;
        return (hourlyRate / 60) * totalLateMinutes;
    }

    /**
     * Calculates the net salary after deductions.
     * 
     * @param grossSalary The total gross salary before deductions.
     * @param deductions The total amount of deductions (e.g., government contributions).
     * @return The net salary after deductions.
     */
    public static double calculateNetSalary(double grossSalary, double deductions) {
        return grossSalary - deductions;
    }
}
