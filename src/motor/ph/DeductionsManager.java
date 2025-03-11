/*
 * DeductionsManager.java
 * 
 * This class provides methods for computing various payroll deductions,
 * including SSS, Pag-IBIG, and PhilHealth contributions.
 */
package motor.ph;

/**
 * The DeductionsManager class calculates mandatory salary deductions
 * such as SSS, Pag-IBIG, and PhilHealth based on the employee's gross salary.
 */
public class DeductionsManager {
    
    /**
     * Computes the SSS contribution based on the given gross salary.
     *
     * @param grossSalary The employee's gross salary.
     * @return The computed SSS contribution.
     */
    public static double computeSSS(double grossSalary) {
        return grossSalary * 0.045; // Example rate
    }

    /**
     * Computes the Pag-IBIG contribution based on the given gross salary.
     * The contribution is capped at a maximum of 100 PHP.
     *
     * @param grossSalary The employee's gross salary.
     * @return The computed Pag-IBIG contribution.
     */
    public static double computePagIbig(double grossSalary) {
        return Math.min(grossSalary * 0.02, 100); // Max limit of 100 PHP
    }

    /**
     * Computes the PhilHealth contribution based on the given gross salary.
     *
     * @param grossSalary The employee's gross salary.
     * @return The computed PhilHealth contribution.
     */
    public static double computePhilHealth(double grossSalary) {
        return grossSalary * 0.035; // Example rate
    }
}