/*
 * AttendanceManager.java
 * 
 * This class manages employee attendance records, allowing for the saving and retrieval 
 * of attendance data from a CSV file. It provides methods to store new attendance entries 
 * and filter attendance records by employee ID.
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
 * The AttendanceManager class provides functionality to save and retrieve employee attendance records.
 * It stores data in a CSV file and allows filtering by employee ID.
 */
public class AttendanceManager {
    
    /**
     * The file path where attendance records are stored.
     */
    private static final String FILE_NAME = "C:\\Users\\Nia\\Downloads\\MOTORPH-GROUP3-master\\MOTORPH-GROUP3-master\\src\\motor\\resources\\attendance_data.csv";
    
    /**
     * Saves an attendance record to the CSV file.
     *
     * @param attendance The AttendanceRecord object containing employee attendance data.
     */
    public static void saveAttendanceToCSV(AttendanceRecord attendance) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(attendance.getEmployeeId() + "," + attendance.getLastName() + "," + 
                    attendance.getFirstName() + "," + attendance.getDate() + "," + 
                    attendance.getLogin() + "," + attendance.getLogout());
        } catch (IOException e) {
            System.out.println("Error saving attendance data: " + e.getMessage());
        }
    }
    
    /**
     * Reads attendance records from the CSV file and returns them as a list.
     *
     * @return A list of AttendanceRecord objects containing attendance data.
     */
    public static List<AttendanceRecord> readFromCSV() {
        List<AttendanceRecord> attendanceList = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("File not found: Returning empty list.");
            return attendanceList;  // Return empty list if the file doesn't exist
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
                
                isEmpty = false; // If we read at least one line, file isn't empty
                
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
    
    /**
     * Retrieves attendance records for a specific employee based on their employee ID.
     *
     * @param empId The employee's ID.
     * @return A list of AttendanceRecord objects for the specified employee.
     */
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
