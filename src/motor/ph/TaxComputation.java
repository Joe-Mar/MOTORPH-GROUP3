/*
 * TaxComputation.java
 * 
 * This class provides methods for computing income tax based on taxable income
 * and determining taxable allowances for employees.
 */
package motor.ph;

/**
 * The TaxComputation class is responsible for calculating tax deductions
 * based on taxable income and taxable allowances.
 * 
 * It includes methods for computing tax according to predefined tax brackets 
 * and determining taxable portions of employee allowances.
 * 
 * @author lasic
 */
public class TaxComputation {

    /**
     * Computes the tax based on the taxable income using a progressive tax system.
     * 
     * The tax rates are applied according to predefined income brackets.
     * 
     * @param taxableIncome The taxable income of the employee.
     * @return The calculated tax amount.
     */
    public static double computeTax(double taxableIncome) {
        if (taxableIncome <= 20833) {
            return 0; // No tax for incomes up to 20,833
        } else if (taxableIncome <= 33333) {
            return (taxableIncome - 20833) * 0.20;
        } else if (taxableIncome <= 66667) {
            return 2500 + (taxableIncome - 33333) * 0.25;
        } else if (taxableIncome <= 166667) {
            return 10833 + (taxableIncome - 66667) * 0.30;
        } else if (taxableIncome <= 666667) {
            return 40833.33 + (taxableIncome - 166667) * 0.32;
        } else {
            return 200833.33 + (taxableIncome - 666667) * 0.35;
        }
    }

    /**
     * Calculates the taxable portion of employee allowances.
     * 
     * Certain allowances (phone, rice subsidy, and clothing) have non-taxable limits. 
     * Any amount exceeding these limits is considered taxable.
     * 
     * @param phoneAllowance The phone allowance received by the employee.
     * @param riceSubsidy The rice subsidy allowance received by the employee.
     * @param clothingAllowance The clothing allowance received by the employee.
     * @return The total taxable portion of the allowances.
     */
    public static double getTaxableAllowances(double phoneAllowance, double riceSubsidy, double clothingAllowance) {
        double taxableAllowances = 0;

        // Defined non-taxable limits for each type of allowance
        double nonTaxablePhone = 1000;
        double nonTaxableRice = 1500;
        double nonTaxableClothing = 800;

        // Calculate taxable portion for each allowance
        if (phoneAllowance > nonTaxablePhone) {
            taxableAllowances += (phoneAllowance - nonTaxablePhone);
        }
        if (riceSubsidy > nonTaxableRice) {
            taxableAllowances += (riceSubsidy - nonTaxableRice);
        }
        if (clothingAllowance > nonTaxableClothing) {
            taxableAllowances += (clothingAllowance - nonTaxableClothing);
        }

        return taxableAllowances;
    }
}
