/*
 * WorkHoursRecord.java
 * 
 * This class represents a record of an employee's work hours for a specific date.
 * It stores details such as regular hours worked, overtime hours, late minutes, 
 * and deductions due to late arrivals.
 */

package motor.ph;

/**
 * The WorkHoursRecord class holds information about an employee's work hours
 * for a specific day, including regular hours, overtime, late minutes, and
 * corresponding deductions.
 */
public class WorkHoursRecord {
    
    private int employeeId;       // Employee's unique identifier
    private String date;          // Date of the work record (format: MM/dd/yyyy)
    private double regularHours;  // Regular working hours (capped at 8 hours)
    private double overtimeHours; // Overtime hours (beyond 8 hours)
    private double lateMinutes;   // Total minutes late for the day
    private double lateDeduction; // Deduction amount due to lateness

    /**
     * Constructor to initialize a WorkHoursRecord object.
     * 
     * @param employeeId    The ID of the employee.
     * @param date          The date of the work record.
     * @param regularHours  The number of regular hours worked.
     * @param overtimeHours The number of overtime hours worked.
     * @param lateMinutes   The number of minutes late.
     * @param lateDeduction The deduction amount due to lateness.
     */
    public WorkHoursRecord(int employeeId, String date, double regularHours, double overtimeHours, double lateMinutes, double lateDeduction) {
        this.employeeId = employeeId;
        this.date = date;
        this.regularHours = regularHours;
        this.overtimeHours = overtimeHours;
        this.lateMinutes = lateMinutes;
        this.lateDeduction = lateDeduction;
    }
    
    /**
     * Gets the employee ID.
     * 
     * @return The employee's unique identifier.
     */
    public int getEmployeeId() { return employeeId; }

    /**
     * Gets the date of the work record.
     * 
     * @return The date as a String.
     */
    public String getDate() { return date; }

    /**
     * Gets the number of regular hours worked.
     * 
     * @return The total regular hours (maximum of 8).
     */
    public double getRegularHours() { return regularHours; }

    /**
     * Gets the number of overtime hours worked.
     * 
     * @return The total overtime hours (beyond 8 regular hours).
     */
    public double getOvertimeHours() { return overtimeHours; }

    /**
     * Gets the total minutes the employee was late.
     * 
     * @return The total late minutes for the day.
     */
    public double getLateMinutes() { return lateMinutes; }

    /**
     * Gets the total late deduction amount.
     * 
     * @return The deduction amount based on late minutes.
     */
    public double getLateDeduction() { return lateDeduction; }
}
