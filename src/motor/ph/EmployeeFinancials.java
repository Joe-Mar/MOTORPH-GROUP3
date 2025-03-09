/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
public class EmployeeFinancials {
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    public EmployeeFinancials(double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance,
                              double grossSemiMonthlyRate, double hourlyRate) {
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    // Getters
    public double getBasicSalary() { return basicSalary; }
    public double getRiceSubsidy() { return riceSubsidy; }
    public double getPhoneAllowance() { return phoneAllowance; }
    public double getClothingAllowance() { return clothingAllowance; }
    public double getGrossSemiMonthlyRate() { return grossSemiMonthlyRate; }
    public double getHourlyRate() { return hourlyRate; }

    // Compute total allowances
    public double getTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    // Compute prorated total allowances
    public double getProratedTotalAllowance(long totalWorkDays, long workDays) {
        double totalMonthlyAllowance = riceSubsidy + phoneAllowance + clothingAllowance;
        if (totalWorkDays > 0) {
            return (totalMonthlyAllowance / totalWorkDays) * workDays; // Prorated allowance calculation
        }
        return 0;
    }

    // Compute allowance based on payroll type (weekly, semi-monthly, monthly)
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

    public void printFinancialDetails() {
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Rice Subsidy: " + riceSubsidy);
        System.out.println("Phone Allowance: " + phoneAllowance);
        System.out.println("Clothing Allowance: " + clothingAllowance);
        System.out.println("Gross Semi-Monthly Rate: " + grossSemiMonthlyRate);
        System.out.println("Hourly Rate: " + hourlyRate);
    }
}


