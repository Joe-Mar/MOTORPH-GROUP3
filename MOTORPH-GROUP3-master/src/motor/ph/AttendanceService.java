/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lasic
 */
public class AttendanceService {
    //Method Use to View and Scan the Attendance on Main Class
    public static void viewAttendance(Scanner scanner) {
        System.out.print("Enter Employee ID (10001-10034): ");
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

