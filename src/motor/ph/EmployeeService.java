/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
public class EmployeeService {
    //Method on MainClass to Read Data of Employee
    public static Employee getEmployeeByEmployeeId(int empId) {
        return EmployeeDataManager.readFromCSV().stream()
                .filter(emp -> emp.getEmployeeId() == empId)
                .findFirst()
                .orElse(null);
    }
    //Method to View EmployeeDetails on MainClass
    public static void viewEmployeeDetails(int employeeId) {
        Employee employee = EmployeeService.getEmployeeByEmployeeId(employeeId);
        if (employee == null) {
            System.out.println("Error: Employee not found.");
            return;
        }
//PrintDetails once Generated
        EmployeeFinancials financials = employee.getFinancials();

        System.out.println("\n====================================");
        System.out.println("          EMPLOYEE DETAILS          ");
        System.out.println("====================================");
        System.out.printf("Employee ID          : %d%n", employee.getEmployeeId());
        System.out.printf("Name                : %s %s%n", employee.getFirstName(), employee.getLastName());
        System.out.printf("Birthday            : %s%n", employee.getBirthday());   // Make sure Employee class has getBirthday()
        System.out.printf("Address             : %s%n", employee.getAddress());    // Ensure Employee class has getAddress()
        System.out.printf("Phone Number        : %s%n", employee.getPhoneNumber());
        System.out.printf("SSS Number          : %s%n", employee.getSss());
        System.out.printf("PhilHealth Number   : %s%n", employee.getPhilhealth());
        System.out.printf("TIN Number          : %s%n", employee.getTin());
        System.out.printf("Pag-IBIG Number     : %s%n", employee.getPagibig());
        System.out.printf("Status             : %s%n", employee.getStatus());
        System.out.printf("Position            : %s%n", employee.getPosition());
        System.out.printf("Immediate Supervisor: %s%n", employee.getImmediateSupervisor());
        System.out.println("====================================");
        System.out.println("          FINANCIAL DETAILS         ");
        System.out.println("====================================");
        System.out.printf("Basic Salary        : %.2f%n", financials.getBasicSalary());
        System.out.printf("Rice Subsidy       : %.2f%n", financials.getRiceSubsidy());
        System.out.printf("Phone Allowance    : %.2f%n", financials.getPhoneAllowance());
        System.out.printf("Clothing Allowance : %.2f%n", financials.getClothingAllowance());
        System.out.printf("Gross Semi-Monthly Rate : %.2f%n", financials.getGrossSemiMonthlyRate());
        System.out.printf("Hourly Rate        : %.2f%n", financials.getHourlyRate());
        System.out.printf("Prorated Total Allowance: %.2f\n", employee.getFinancials().getProratedTotalAllowance(employeeId, employeeId));
        System.out.println("====================================\n");
    }
}





