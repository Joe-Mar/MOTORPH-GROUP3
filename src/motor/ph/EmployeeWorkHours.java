/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.time.LocalDate;

/**
 *
 * @author lasic
 */
public class EmployeeWorkHours {
    //Method On Gettting Regular Hours
    public static double getTotalRegularHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getRegularHours)
                .sum();
    }
//Method to Get Total Overtime
    public static double getTotalOvertimeHours(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getOvertimeHours)
                .sum();
    }
//Method To Get Total LateMinutes
    public static double getTotalLateMinutes(int empId, LocalDate startDate, LocalDate endDate) {
        return WorkHoursManager.computeWorkHours().stream()
                .filter(wh -> wh.getEmployeeId() == empId && WorkHoursService.isDateInRange(wh.getDate(), startDate, endDate))
                .mapToDouble(WorkHoursRecord::getLateMinutes)
                .sum();
    }
//Method to Get LateDeduction
    public static double getTotalLateDeductions(int employeeId, LocalDate startDate, LocalDate endDate, double hourlyRate) {
        int totalLateMinutes = (int) getTotalLateMinutes(employeeId, startDate, endDate);
        return (hourlyRate / 60) * totalLateMinutes;
    }
}

