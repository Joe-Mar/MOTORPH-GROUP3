/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
public class DeductionsManager {
    //Method to Compute Deduction
    public static double computeSSS(double grossSalary) {
        return grossSalary * 0.045; // Example rate
    }

    public static double computePagIbig(double grossSalary) {
        return Math.min(grossSalary * 0.02, 100); // Max limit of 100 PHP
    }

    public static double computePhilHealth(double grossSalary) {
        return grossSalary * 0.035; // Example rate
    }
}
