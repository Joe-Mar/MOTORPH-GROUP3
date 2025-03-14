/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lasic
 */
public class AttendanceManager {
    private static final String FILE_NAME = "src/motor/resources/attendance_data.csv";

    public static void saveAttendanceToCSV(AttendanceRecord attendance) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(attendance.getEmployeeId() + "," + attendance.getLastName() + "," + attendance.getFirstName() + "," +
                    attendance.getDate() + "," + attendance.getLogin() + "," + attendance.getLogout());
        } catch (IOException e) {
            System.out.println("Error saving attendance data: " + e.getMessage());
        }
    }
    
    public static List<AttendanceRecord> readFromCSV() {
    List<AttendanceRecord> attendanceList = new ArrayList<>();
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        System.out.println("File not found: Returning empty list.");
        return attendanceList;  //  Return empty list if the file doesn't exist
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        boolean firstLine = true;
        boolean isEmpty = true; // Flag to check if the file has any data
        
        while ((line = reader.readLine()) != null) {
            if (firstLine) { 
                firstLine = false; 
                continue; // Skip header row
            }
            
            isEmpty = false; //  If we read at least one line, file isn't empty
            
            String[] data = line.split(",");
            if (data.length == 6) {
                try {
                    AttendanceRecord attendance = new AttendanceRecord(
                        Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]
                    );
                    attendanceList.add(attendance);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid record: " + line);
                }
            }
        }
        
        if (isEmpty) {
            System.out.println("CSV file is empty: Returning empty list.");
            return new ArrayList<>(); // Explicitly return an empty list
        }
        
    } catch (IOException e) {
        System.out.println("Error reading attendance data: " + e.getMessage());
    }

    return attendanceList;
}
    
    //Method to List Attendance Record of Employee by EmployeeId
    public static List<AttendanceRecord> getAttendanceByEmployeeId(int empId) {
        List<AttendanceRecord> filteredRecords = new ArrayList<>();
        for (AttendanceRecord record : readFromCSV()) {
            if (record.getEmployeeId() == empId) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }
}
