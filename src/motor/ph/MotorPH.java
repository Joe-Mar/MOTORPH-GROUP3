/*
 * MotorPH.java
 * 
 * This class serves as the main entry point for the MotorPH Payroll System.
 * It provides an interactive menu for users to view employee details, 
 * attendance, work hours, and process payroll.
 */
package motor.ph;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The MotorPH class implements the main menu-driven system for the MotorPH Payroll System.
 * Users can interact with the system to view employee details, attendance, work hours,
 * and process payroll.
 */
public class MotorPH {
    
    /** Formatter for date input in MM/dd/yyyy format. */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * The main method starts the payroll system and displays a menu for user interaction.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Main program loop
        while (!exit) {
            System.out.println("\n===== MotorPH Payroll System =====");
            System.out.println("1. View Employee Details");
            System.out.println("2. View Attendance");
            System.out.println("3. View Work Hours");
            System.out.println("4. Process Payroll");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Validate user input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scanner.next(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Handle user choice
            switch (choice) {
                case 1:
                    viewEmployeeDetails(scanner);
                    break;
                case 2:
                    AttendanceService.viewAttendance(scanner);
                    break;
                case 3:
                    WorkHoursService.viewWorkHours(scanner, DATE_FORMATTER);
                    break;
                case 4:
                    processPayroll(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }

            // Ask user if they want to return to the main menu
            if (!exit && !askToReturn(scanner)) {
                exit = true;
            }
        }

        scanner.close();
    }

    /**
     * Handles viewing of employee details by prompting the user for an Employee ID.
     * 
     * @param scanner The Scanner object for user input.
     */
    private static void viewEmployeeDetails(Scanner scanner) {
        System.out.print("Enter Employee ID: ");

        // Validate Employee ID input
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.next(); // Consume invalid input
            return;
        }
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Call service to display employee details
        EmployeeService.viewEmployeeDetails(employeeId);
    }

    /**
     * Handles payroll processing by prompting the user for necessary payroll details.
     * 
     * @param scanner The Scanner object for user input.
     */
    private static void processPayroll(Scanner scanner) {
        System.out.print("Enter Employee ID: ");

        // Validate Employee ID input
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.next(); // Consume invalid input
            return;
        }
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Get start and end date inputs
        System.out.print("Enter Start Date (MM/dd/yyyy): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter End Date (MM/dd/yyyy): ");
        String endDate = scanner.nextLine();

        // Call payroll processing service
        PayrollService.processPayroll(employeeId, startDate, endDate);
    }

    /**
     * Asks the user if they want to return to the main menu.
     * 
     * @param scanner The Scanner object for user input.
     * @return true if the user chooses to return to the main menu, false otherwise.
     */
    private static boolean askToReturn(Scanner scanner) {
        System.out.println("\nWould you like to return to the main menu?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter choice: ");

        // Validate input
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Returning to main menu.");
            scanner.next(); // Consume invalid input
            return true;
        }

        int returnChoice = scanner.nextInt();
        return returnChoice == 1;
    }
}
