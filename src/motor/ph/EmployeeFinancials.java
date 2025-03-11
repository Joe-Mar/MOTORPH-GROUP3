/*
 * EmployeeFinancials.java
 * 
 * This class represents the financial details of an employee, including salary, allowances, 
 * and methods for computing various financial aspects based on payroll type.
 */
package motor.ph;

/**
 * The EmployeeFinancials class stores and manages salary-related data for an employee.
 */
public class EmployeeFinancials {
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    /**
     * Constructs an EmployeeFinancials object with specified financial details.
     *
     * @param basicSalary The basic salary of the employee.
     * @param riceSubsidy The monthly rice subsidy allowance.
     * @param phoneAllowance The monthly phone allowance.
     * @param clothingAllowance The monthly clothing allowance.
     * @param grossSemiMonthlyRate The semi-monthly gross salary.
     * @param hourlyRate The hourly rate of the employee.
     */
    public EmployeeFinancials(double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance,
                              double grossSemiMonthlyRate, double hourlyRate) {
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    // Getters for financial details
    public double getBasicSalary() { return basicSalary; }
    public double getRiceSubsidy() { return riceSubsidy; }
    public double getPhoneAllowance() { return phoneAllowance; }
    public double getClothingAllowance() { return clothingAllowance; }
    public double getGrossSemiMonthlyRate() { return grossSemiMonthlyRate; }
    public double getHourlyRate() { return hourlyRate; }

    /**
     * Computes the total monthly allowances.
     * 
     * @return The sum of rice subsidy, phone allowance, and clothing allowance.
     */
    public double getTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    /**
     * Computes the prorated total allowance based on the number of workdays.
     *
     * @param totalWorkDays The total number of working days in a month.
     * @param workDays The actual number of days worked.
     * @return The prorated allowance amount.
     */
    public double getProratedTotalAllowance(long totalWorkDays, long workDays) {
        double totalMonthlyAllowance = riceSubsidy + phoneAllowance + clothingAllowance;
        if (totalWorkDays > 0) {
            return (totalMonthlyAllowance / totalWorkDays) * workDays; // Prorated allowance calculation
        }
        return 0;
    }

    /**
     * Computes the allowance based on the payroll type.
     *
     * @param payrollType The payroll type (weekly, semi-monthly, or monthly).
     * @return The computed allowance based on the payroll type.
     */
    public double computeAllowance(String payrollType) {
        double rice, phone, clothing;

        switch (payrollType.toLowerCase()) {
            case "weekly":
                rice = riceSubsidy / 4.0;
                phone = phoneAllowance / 4.0;
                clothing = clothingAllowance / 4.0;
                break;
            case "semi-monthly":
                rice = riceSubsidy / 2.0;
                phone = phoneAllowance / 2.0;
                clothing = clothingAllowance / 2.0;
                break;
            case "monthly":
            default:
                rice = riceSubsidy;
                phone = phoneAllowance;
                clothing = clothingAllowance;
                break;
        }

        return rice + phone + clothing;
    }

    /**
     * Prints the financial details of the employee.
     */
    public void printFinancialDetails() {
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Rice Subsidy: " + riceSubsidy);
        System.out.println("Phone Allowance: " + phoneAllowance);
        System.out.println("Clothing Allowance: " + clothingAllowance);
        System.out.println("Gross Semi-Monthly Rate: " + grossSemiMonthlyRate);
        System.out.println("Hourly Rate: " + hourlyRate);
    }
}
