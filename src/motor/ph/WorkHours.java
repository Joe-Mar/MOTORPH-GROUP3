/*
 * WorkHours.java
 * 
 * This class provides methods to retrieve various work hour details for employees,
 * such as regular hours, overtime hours, late minutes, and late deductions.
 * It acts as an interface to EmployeeWorkHours and WorkHoursManager classes.
 */
package motor.ph;

import java.time.LocalDate;
import java.util.List;

/**
 * The WorkHours class provides utility methods to retrieve employee work hours data.
 * It fetches data related to regular work hours, overtime, late minutes, and late deductions.
 */
public class WorkHours {
    
    /**
     * Retrieves a list of all work hours records.
     * 
     * @return a list of WorkHoursRecord objects containing work hours data.
     */
    public static List<WorkHoursRecord> getAllWorkHours() {
        return WorkHoursManager.computeWorkHours();
    }
    
    /**
     * Calculates the total regular hours worked by an employee within a specified date range.
     * 
     * @param empId The employee's ID.
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @return The total number of regular hours worked.
     */
    public static double getTotalRegularHours(int empId, LocalDate startDate, LocalDate endDate) {
        return EmployeeWorkHours.getTotalRegularHours(empId, startDate, endDate);
    }
    
    /**
     * Calculates the total overtime hours worked by an employee within a specified date range.
     * 
     * @param empId The employee's ID.
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @return The total number of overtime hours worked.
     */
    public static double getTotalOvertimeHours(int empId, LocalDate startDate, LocalDate endDate) {
        return EmployeeWorkHours.getTotalOvertimeHours(empId, startDate, endDate);
    }
    
    /**
     * Retrieves the total number of minutes an employee was late within a specified date range.
     * 
     * @param empId The employee's ID.
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @return The total number of late minutes.
     */
    public static double getTotalLateMinutes(int empId, LocalDate startDate, LocalDate endDate) {
        return EmployeeWorkHours.getTotalLateMinutes(empId, startDate, endDate);
    }
    
    /**
     * Calculates the total late deductions for an employee within a specified date range.
     * 
     * @param empId The employee's ID.
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @param hourlyRate The hourly rate of the employee.
     * @return The total amount deducted due to late minutes.
     */
    public static double getTotalLateDeductions(int empId, LocalDate startDate, LocalDate endDate, double hourlyRate) {
        return EmployeeWorkHours.getTotalLateDeductions(empId, startDate, endDate, hourlyRate);
    }
}
