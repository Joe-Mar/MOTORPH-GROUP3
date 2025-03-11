/*
 * AttendanceService.java
 * 
 * This class provides services related to employee attendance,
 * including viewing attendance records based on employee ID.
 */
package motor.ph;

import java.util.List;
import java.util.Scanner;

/**
 * The AttendanceService class handles operations related to employee attendance records.
 * It provides a method to view attendance records by employee ID.
 */
public class AttendanceService {
    
    /**
     * Displays the attendance records for a given employee ID.
     * 
     * @param scanner A Scanner object for user input.
     */
    public static void viewAttendance(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int searchEmployeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<AttendanceRecord> attendanceList = AttendanceManager.getAttendanceByEmployeeId(searchEmployeeId);

        if (!attendanceList.isEmpty()) {
            System.out.println("\n===== Attendance Records =====");
            for (AttendanceRecord attendance : attendanceList) {
                attendance.printAttendanceDetails();
            }
            System.out.println("==============================");
        } else {
            System.out.println("No attendance records found.");
        }
    }
}
