/*
 * WorkHoursService.java
 * 
 * This class provides utility methods for reading work hours data from a CSV file,
 * validating date ranges, and displaying an employee's work hours summary.
 */

package motor.ph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The WorkHoursService class handles file reading, date validation, and work hours retrieval.
 * It reads attendance data from a CSV file and allows querying employee work hours.
 */
public class WorkHoursService {
    
    private static final String FILE_NAME = "C:\\Users\\Nia\\Downloads\\MOTORPH-GROUP3-master\\MOTORPH-GROUP3-master\\src\\motor\\resources\\attendance_data.csv";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * Reads work hours data from a CSV file and returns it as a list of string arrays.
     * 
     * @return A list of string arrays containing parsed CSV data.
     */
    public static List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean firstLine = true; // Skip the header row
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                data.add(line.split(",")); // Split CSV line into array
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
        return data;
    }

    /**
     * Checks if a given date string falls within the specified date range.
     * 
     * @param dateStr The date in string format (MM/dd/yyyy).
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @return True if the date is within the range, otherwise false.
     */
    public static boolean isDateInRange(String dateStr, LocalDate startDate, LocalDate endDate) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        return (date.isEqual(startDate) || date.isAfter(startDate)) && date.isBefore(endDate.plusDays(1));
    }

    /**
     * Prompts the user for an employee ID and date range, then displays a summary 
     * of the employee's total work hours, regular hours, overtime, and late minutes.
     * 
     * @param scanner The Scanner object for user input.
     * @param DATE_FORMATTER The date formatter to parse input dates.
     */
    public static void viewWorkHours(Scanner scanner, DateTimeFormatter DATE_FORMATTER) {
        System.out.print("Enter Employee ID: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.next(); // Consume invalid input
            return;
        }
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Start Date (MM/dd/yyyy): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Enter End Date (MM/dd/yyyy): ");
        String endDateStr = scanner.nextLine();

        try {
            // Parse user input into LocalDate objects
            LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
            LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);

            // Instance of WorkHoursManager to retrieve work hours
            WorkHoursManager workHoursManager = new WorkHoursManager();
            double totalWorkHours = workHoursManager.calculateTotalWorkHours(employeeId, startDate, endDate);
            double totalRegularHours = workHoursManager.calculateTotalRegularHours(employeeId, startDate, endDate);
            double totalOvertimeHours = workHoursManager.calculateTotalOvertimeHours(employeeId, startDate, endDate);
            double totalLateMinutes = workHoursManager.calculateTotalLateMinutes(employeeId, startDate, endDate);

            // Display work hours summary
            System.out.println("\n=== Work Hours Summary ===");
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Total Work Hours: " + totalWorkHours + " hours");
            System.out.println("Regular Hours: " + totalRegularHours + " hours");
            System.out.println("Overtime Hours: " + totalOvertimeHours + " hours");
            System.out.println("Late Minutes: " + totalLateMinutes + " minutes");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter dates in MM/dd/yyyy format.");
        }
    }
}
