/*
 * GovernmentDeduction.java
 * 
 * This class calculates and stores government-mandated deductions for an employee, 
 * including SSS, Pag-IBIG, and PhilHealth, based on their gross income.
 */
package motor.ph;

/**
 * The GovernmentDeduction class computes government-mandated deductions 
 * (SSS, Pag-IBIG, and PhilHealth) based on an employee's gross income.
 */
public class GovernmentDeduction {
    
    /** The SSS deduction amount. */
    private double sssDeduction;
    
    /** The Pag-IBIG deduction amount. */
    private double pagIbigDeduction;
    
    /** The PhilHealth deduction amount. */
    private double philHealthDeduction;

    /**
     * Constructs a GovernmentDeduction object and calculates deductions 
     * based on the provided gross income.
     * 
     * @param grossIncome The employee's gross income.
     */
    public GovernmentDeduction(double grossIncome) {
        this.sssDeduction = calculateSSS(grossIncome);
        this.pagIbigDeduction = calculatePagIbig(grossIncome);
        this.philHealthDeduction = calculatePhilHealth(grossIncome);
    }

    /**
     * Gets the computed SSS deduction.
     * 
     * @return The SSS deduction amount.
     */
    public double getSSS() {
        return sssDeduction;
    }

    /**
     * Gets the computed Pag-IBIG deduction.
     * 
     * @return The Pag-IBIG deduction amount.
     */
    public double getPagIbig() {
        return pagIbigDeduction;
    }

    /**
     * Gets the computed PhilHealth deduction.
     * 
     * @return The PhilHealth deduction amount.
     */
    public double getPhilHealth() {
        return philHealthDeduction;
    }

    /**
     * Computes the total government deductions (SSS, Pag-IBIG, and PhilHealth).
     * 
     * @return The total deductions amount.
     */
    public double getTotalDeductions() {
        return sssDeduction + pagIbigDeduction + philHealthDeduction;
    }

    /**
     * Calculates the SSS deduction based on the gross salary using predefined contribution brackets.
     * 
     * @param grossSalary The employee's gross salary.
     * @return The computed SSS deduction amount.
     */
    public static double calculateSSS(double grossSalary) {
        if (grossSalary <= 3250) return 135;
        else if (grossSalary <= 3750) return 157.50;
        else if (grossSalary <= 4250) return 180;
        else if (grossSalary <= 4750) return 202.50;
        else if (grossSalary <= 5250) return 225;
        else if (grossSalary <= 5750) return 247.50;
        else if (grossSalary <= 6250) return 270;
        else if (grossSalary <= 6750) return 292.50;
        else if (grossSalary <= 7250) return 315;
        else if (grossSalary <= 7750) return 337.50;
        else if (grossSalary <= 8250) return 360;
        else if (grossSalary <= 8750) return 382.50;
        else if (grossSalary <= 9250) return 405;
        else if (grossSalary <= 9750) return 427.50;
        else if (grossSalary <= 10250) return 450;
        else if (grossSalary <= 10750) return 472.50;
        else if (grossSalary <= 11250) return 495;
        else if (grossSalary <= 11750) return 517.50;
        else if (grossSalary <= 12250) return 540;
        else if (grossSalary <= 12750) return 562.50;
        else if (grossSalary <= 13250) return 585;
        else if (grossSalary <= 13750) return 607.50;
        else if (grossSalary <= 14250) return 630;
        else if (grossSalary <= 14750) return 652.50;
        else if (grossSalary <= 15250) return 675;
        else if (grossSalary <= 15750) return 697.50;
        else if (grossSalary <= 16250) return 720;
        else if (grossSalary <= 16750) return 742.50;
        else if (grossSalary <= 17250) return 765;
        else if (grossSalary <= 17750) return 787.50;
        else if (grossSalary <= 18250) return 810;
        else if (grossSalary <= 18750) return 832.50;
        else if (grossSalary <= 19250) return 855;
        else if (grossSalary <= 19750) return 877.50;
        else if (grossSalary <= 20250) return 900;
        else if (grossSalary <= 20750) return 922.50;
        else if (grossSalary <= 21250) return 945;
        else if (grossSalary <= 21750) return 967.50;
        else if (grossSalary <= 22250) return 990;
        else if (grossSalary <= 22750) return 1012.50;
        else if (grossSalary <= 23250) return 1035;
        else if (grossSalary <= 23750) return 1057.50;
        else if (grossSalary <= 24250) return 1080;
        else if (grossSalary <= 24750) return 1102.50;
        else return 1125;
    }

    /**
     * Calculates the Pag-IBIG contribution, which is 2% of the gross pay 
     * but capped at a maximum of 100.
     * 
     * @param grossPay The employee's gross pay.
     * @return The computed Pag-IBIG contribution amount.
     */
    public static double calculatePagIbig(double grossPay) {
        return Math.min(grossPay * 0.02, 100);
    }

    /**
     * Calculates the PhilHealth contribution based on the employee's gross income.
     * 
     * - If the gross income is 10,000 or below, the fixed rate is 300.
     * - Otherwise, the contribution is 3% of the gross income, capped at a maximum of 900.
     * 
     * @param grossIncome The employee's gross income.
     * @return The computed PhilHealth contribution amount.
     */
    public static double calculatePhilHealth(double grossIncome) {
        return (grossIncome <= 10000) ? 300 : Math.min((grossIncome * 0.03) / 2, 900);
    }
}
