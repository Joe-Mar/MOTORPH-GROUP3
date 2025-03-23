/*
 * WorkHoursManager.java
 * 
 * This class is responsible for managing and computing employee work hours.
 * It reads work hour data from a CSV file, processes login/logout times, 
 * calculates regular and overtime hours, and applies late deduction.
 */

package motor.ph;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The WorkHoursManager class processes and manages employee work hour records.
 * It calculates regular work hours, overtime, late minutes, and deductions.
 * This class also interacts with EmployeeWorkHours for extended functionality.
 * 
 * Methods:
 * - computeWorkHours(): Reads CSV data and computes work hour details.
 * - calculateTotalRegularHours(): Computes an employee's total regular hours.
 * - calculateTotalLateMinutes(): Computes an employee's total late minutes.
 * - calculateTotalOvertimeHours(): Computes an employee's total overtime hours.
 * - calculateTotalWorkHours(): Computes the sum of regular and overtime hours.
 * 
 * Dependencies:
 * - WorkHoursService (for reading CSV data)
 * - EmployeeWorkHours (for additional calculations)
 */
public class WorkHoursManager {
    
    // Date & Time Formatter for parsing CSV data
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

    /**
     * Reads work hours data from a CSV file, processes login/logout times, 
     * and calculates work details such as regular hours, overtime, and late minutes.
     * 
     * @return A list of WorkHoursRecord objects containing computed work hour details.
     */
    public static List<WorkHoursRecord> computeWorkHours() {
        List<WorkHoursRecord> workHoursList = new ArrayList<>();
        List<String[]> data = WorkHoursService.readCSV(); // Read CSV file data

        for (String[] row : data) {
            try {
                // Extract and parse data fields from the CSV row
                int empId = Integer.parseInt(row[0]); // Employee ID
                LocalDate date = LocalDate.parse(row[3], dateFormatter); // Work date
                LocalTime login = LocalTime.parse(row[4], timeFormatter); // Login time
                LocalTime logout = LocalTime.parse(row[5], timeFormatter); // Logout time

                // Determine shift start time (default: 8 AM, unless login is significantly later)
                int shiftHour = (login.getMinute() > 10) ? login.getHour() : Math.max(8, login.getHour());
                LocalTime shiftStart = LocalTime.of(shiftHour, 0);

                // Calculate late minutes (if logged in more than 10 minutes after shift start)
                long lateMinutes = login.isAfter(shiftStart.plusMinutes(10)) ? Duration.between(shiftStart, login).toMinutes() : 0;

                // Compute total work hours (in decimal format)
                double totalWorkHours = (double) Duration.between(login, logout).toMinutes() / 60;
                double regularHours = Math.min(8, totalWorkHours); // Cap regular hours at 8
                double overtimeHours = Math.max(0, totalWorkHours - 8); // Overtime is anything beyond 8 hours

                // Placeholder hourly rate (should be fetched from employee records)
                double hourlyRate = 100;

                // Calculate late deduction based on hourly rate
                double lateDeduction = (hourlyRate / 60) * lateMinutes;

                // Store computed work hours data in a WorkHoursRecord object
                workHoursList.add(new WorkHoursRecord(empId, row[3], regularHours, overtimeHours, lateMinutes, lateDeduction));

            } catch (Exception e) {
                // Handle invalid records gracefully and continue processing
                System.out.println("Skipping invalid record: " + Arrays.toString(row) + " - Error: " + e.getMessage());
            }
        }
        return workHoursList;
    }
    
    // Instance of EmployeeWorkHours for extended calculations
    private EmployeeWorkHours employeeWorkHours;

    /**
     * Constructor: Initializes WorkHoursManager with an instance of EmployeeWorkHours.
     */
    public WorkHoursManager() {
        this.employeeWorkHours = new EmployeeWorkHours();
    }

    /**
     * Calculates the total regular hours worked by an employee within a given date range.
     * 
     * @param employeeId The ID of the employee.
     * @param startDate The start date of the period.
     * @param endDate The end date of the period.
     * @return The total number of regular work hours.
     */
    public double calculateTotalRegularHours(int employeeId, LocalDate startDate, LocalDate endDate) {
        return employeeWorkHours.getTotalRegularHours(employeeId, startDate, endDate);
    }

    /**
     * Calculates the total late minutes accumulated by an employee within a given date range.
     * 
     * @param employeeId The ID of the employee.
     * @param startDate The start date of the period.
     * @param endDate The end date of the period.
     * @return The total number of late minutes.
     */
    public double calculateTotalLateMinutes(int employeeId, LocalDate startDate, LocalDate endDate) {
        return employeeWorkHours.getTotalLateMinutes(employeeId, startDate, endDate);
    }

    /**
     * Calculates the total overtime hours worked by an employee within a given date range.
     * 
     * @param employeeId The ID of the employee.
     * @param startDate The start date of the period.
     * @param endDate The end date of the period.
     * @return The total number of overtime hours.
     */
    public double calculateTotalOvertimeHours(int employeeId, LocalDate startDate, LocalDate endDate) {
        return employeeWorkHours.getTotalOvertimeHours(employeeId, startDate, endDate);
    }

    /**
     * Calculates the total work hours (regular + overtime) for an employee within a given date range.
     * 
     * @param employeeId The ID of the employee.
     * @param startDate The start date of the period.
     * @param endDate The end date of the period.
     * @return The total number of work hours.
     */
    public double calculateTotalWorkHours(int employeeId, LocalDate startDate, LocalDate endDate) {
        double regularHours = employeeWorkHours.getTotalRegularHours(employeeId, startDate, endDate);
        double overtimeHours = employeeWorkHours.getTotalOvertimeHours(employeeId, startDate, endDate);
        return regularHours + overtimeHours;
    }
}
