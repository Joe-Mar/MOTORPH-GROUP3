/*
 * EmployeeWorkHours.java
 * 
 * This class provides methods to calculate an employee's total regular work hours, 
 * overtime hours, late minutes, and late deductions within a given date range.
 */
package motor.ph;

import java.time.LocalDate;

/**
 * The EmployeeWorkHours class contains static methods to calculate work-related 
 * metrics such as regular hours, overtime hours, late minutes, and deductions 
 * based on employee attendance records.
 * 
 * This class interacts with WorkHoursManager to fetch and process work hours data.
 */
public class EmployeeWorkHours {

    /**
     * Computes the total regular work hours of an employee within a specified date range.
     *
     * @param empId      The employee ID.
     * @param startDate  The start date of the range.
     * @param endDate    The end date of the range.
     * @return The total number of regular hours worked within the date range.
     */
    public static double getTotalRegularHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getRegularHours)
                .sum();
    }

    /**
     * Computes the total overtime hours of an employee within a specified date range.
     *
     * @param empId      The employee ID.
     * @param startDate  The start date of the range.
     * @param endDate    The end date of the range.
     * @return The total number of overtime hours worked within the date range.
     */
    public static double getTotalOvertimeHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getOvertimeHours)
                .sum();
    }

    /**
     * Computes the total late minutes of an employee within a specified date range.
     *
     * @param empId      The employee ID.
     * @param startDate  The start date of the range.
     * @param endDate    The end date of the range.
     * @return The total number of minutes the employee was late within the date range.
     */
    public static double getTotalLateMinutes(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getLateMinutes)
                .sum();
    }

    /**
     * Calculates the total late deductions for an employee based on their late minutes 
     * and hourly rate.
     *
     * @param employeeId  The employee ID.
     * @param startDate   The start date of the range.
     * @param endDate     The end date of the range.
     * @param hourlyRate  The hourly rate of the employee.
     * @return The total late deductions in monetary value.
     */
    public static double getTotalLateDeductions(int employeeId, LocalDate startDate, LocalDate endDate, double hourlyRate) {
        int totalLateMinutes = (int) getTotalLateMinutes(employeeId, startDate, endDate);
        return (hourlyRate / 60) * totalLateMinutes;
    }
}
