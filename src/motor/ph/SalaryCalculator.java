/*
 * SalaryCalculator.java
 * 
 * This class is responsible for calculating total deductions 
 * based on the employee's gross salary.
 */
package motor.ph;

/**
 * The SalaryCalculator class provides methods for calculating 
 * salary-related deductions.
 * 
 * This includes government-mandated deductions such as 
 * SSS, Pag-IBIG, and PhilHealth.
 * 
 * @author lasic
 */
public class SalaryCalculator {

    /**
     * Computes the total deductions based on the employee's gross salary.
     * 
     * This method calculates deductions for SSS, Pag-IBIG, and PhilHealth,
     * and returns the total deduction amount.
     * 
     * @param grossSalary The gross salary of the employee.
     * @return The total deduction amount.
     */
    public static double computeDeductions(double grossSalary) {
        // Compute government-mandated deductions
        double sss = DeductionsManager.computeSSS(grossSalary);
        double pagIbig = DeductionsManager.computePagIbig(grossSalary);
        double philHealth = DeductionsManager.computePhilHealth(grossSalary);

        // Return the total deduction amount
        return sss + pagIbig + philHealth;
    }
}
