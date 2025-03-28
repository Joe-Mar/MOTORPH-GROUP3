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
 * Manages attendance records, including reading from and writing to a CSV file
 */
public class AttendanceManager {
    // The file path where attendance records are stored.
    private static final String FILE_NAME = "C:\\Users\\lasic\\OneDrive\\Documents\\NetBeansProjects\\MOTOR-PH\\src\\motor\\resources\\attendance_data.csv";

    /**
     * Saves an attendance record to the CSV file.
     * This method appends a new entry to the existing file.
     *
     * @param attendance The attendance record to be saved.
     */
    public static void saveAttendanceToCSV(AttendanceRecord attendance) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            // Writes the attendance details as a new line in the CSV file.
            writer.println(attendance.getEmployeeId() + "," + attendance.getLastName() + "," + attendance.getFirstName() + "," +
                    attendance.getDate() + "," + attendance.getLogin() + "," + attendance.getLogout());
        } catch (IOException e) {
            System.out.println("Error saving attendance data: " + e.getMessage());
        }
    }

    /**
     * Reads attendance records from the CSV file and returns a list of AttendanceRecord objects.
     * If the file does not exist or is empty, it returns an empty list.
     *
     * @return A list of attendance records.
     */
    public static List<AttendanceRecord> readFromCSV() {
        List<AttendanceRecord> attendanceList = new ArrayList<>();
        File file = new File(FILE_NAME);

        // Check if the file exists before attempting to read it.
        if (!file.exists()) {
            System.out.println("File not found: Returning empty list.");
            return attendanceList;  // Return an empty list if the file doesn't exist.
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true; // This flag is used to skip the header row.
            boolean isEmpty = true; // This flag checks if the file contains any data.

            while ((line = reader.readLine()) != null) {
                if (firstLine) { 
                    firstLine = false; 
                    continue; // Skip the header row.
                }

                isEmpty = false; // If we read at least one line, the file isn't empty.

                String[] data = line.split(","); // Split the line into an array using commas.
                
                // Check if the row has exactly 6 values (ensuring valid data).
                if (data.length == 6) {
                    try {
                        // Create a new AttendanceRecord object and add it to the list.
                        AttendanceRecord attendance = new AttendanceRecord(
                            Integer.parseInt(data[0]), // Employee ID (integer)
                            data[1], // Last Name
                            data[2], // First Name
                            data[3], // Date
                            data[4], // Login Time
                            data[5]  // Logout Time
                        );
                        attendanceList.add(attendance);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid record: " + line);
                    }
                }
            }

            // If the file contains only the header row or is empty, return an empty list.
            if (isEmpty) {
                System.out.println("CSV file is empty: Returning empty list.");
                return new ArrayList<>(); // Explicitly return an empty list.
            }

        } catch (IOException e) {
            System.out.println("Error reading attendance data: " + e.getMessage());
        }

        return attendanceList; // Return the list of attendance records.
    }

    /**
     * Retrieves attendance records for a specific employee by their employee ID.
     *
     * @param empId The employee's ID.
     * @return A list of AttendanceRecord objects that belong to the specified employee.
     */
    public static List<AttendanceRecord> getAttendanceByEmployeeId(int empId) {
        List<AttendanceRecord> filteredRecords = new ArrayList<>();

        // Loop through the attendance list and filter records by employee ID.
        for (AttendanceRecord record : readFromCSV()) {
            if (record.getEmployeeId() == empId) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords; // Return the filtered list of attendance records.
    }
}
