/*
 * EmployeeService.java
 * 
 * This class provides methods to retrieve and display employee details
 * from the employee data repository.
 */
package motor.ph;

/**
 * The EmployeeService class is responsible for retrieving employee details
 * from the CSV data source and displaying the information.
 */
public class EmployeeService {
    
    /**
     * Retrieves an employee by their unique employee ID.
     * 
     * @param empId The ID of the employee to retrieve.
     * @return The Employee object if found, otherwise null.
     */
    public static Employee getEmployeeByEmployeeId(int empId) {
        return EmployeeDataManager.readFromCSV().stream()
                .filter(emp -> emp.getEmployeeId() == empId)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Displays the details of an employee given their employee ID.
     * If the employee is not found, an error message is displayed.
     * 
     * @param employeeId The ID of the employee whose details are to be displayed.
     */
    public static void viewEmployeeDetails(int employeeId) {
        Employee employee = EmployeeService.getEmployeeByEmployeeId(employeeId);
        if (employee == null) {
            System.out.println("Error: Employee not found.");
            return;
        }

        // Retrieve financial details of the employee
        EmployeeFinancials financials = employee.getFinancials();

        // Display employee details
        System.out.println("\n====================================");
        System.out.println("          EMPLOYEE DETAILS          ");
        System.out.println("====================================");
        System.out.printf("Employee ID          : %d%n", employee.getEmployeeId());
        System.out.printf("Name                : %s %s%n", employee.getFirstName(), employee.getLastName());
        System.out.printf("Birthday            : %s%n", employee.getBirthday()); // Ensure Employee class has getBirthday()
        System.out.printf("Address             : %s%n", employee.getAddress());  // Ensure Employee class has getAddress()
        System.out.printf("Phone Number        : %s%n", employee.getPhoneNumber());
        System.out.printf("SSS Number          : %s%n", employee.getSss());
        System.out.printf("PhilHealth Number   : %s%n", employee.getPhilhealth());
        System.out.printf("TIN Number          : %s%n", employee.getTin());
        System.out.printf("Pag-IBIG Number     : %s%n", employee.getPagibig());
        System.out.printf("Status              : %s%n", employee.getStatus());
        System.out.printf("Position            : %s%n", employee.getPosition());
        System.out.printf("Immediate Supervisor: %s%n", employee.getImmediateSupervisor());
        
        // Display financial details
        System.out.println("====================================");
        System.out.println("          FINANCIAL DETAILS         ");
        System.out.println("====================================");
        System.out.printf("Basic Salary        : %.2f%n", financials.getBasicSalary());
        System.out.printf("Rice Subsidy       : %.2f%n", financials.getRiceSubsidy());
        System.out.printf("Phone Allowance    : %.2f%n", financials.getPhoneAllowance());
        System.out.printf("Clothing Allowance : %.2f%n", financials.getClothingAllowance());
        System.out.printf("Gross Semi-Monthly Rate : %.2f%n", financials.getGrossSemiMonthlyRate());
        System.out.printf("Hourly Rate        : %.2f%n", financials.getHourlyRate());
        System.out.printf("Prorated Total Allowance: %.2f%n", 
                          financials.getProratedTotalAllowance(employeeId, employeeId));
        System.out.println("====================================\n");
    }
}