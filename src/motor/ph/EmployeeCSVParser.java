/*
 * EmployeeCSVParser.java
 * 
 * This class is responsible for parsing employee data from a CSV file and creating Employee objects.
 */
package motor.ph;

/**
 * The EmployeeCSVParser class provides a method to parse employee data from a CSV file.
 */
public class EmployeeCSVParser {
    
    /**
     * Parses an employee record from a CSV file and returns an Employee object.
     * 
     * @param data An array of strings representing an employee's data.
     * @return An Employee object if parsing is successful; otherwise, null.
     */
    public static Employee parseEmployee(String[] data) {
        try {
            int employeeId = Integer.parseInt(data[0].trim());
            String lastName = data[1].trim();
            String firstName = data[2].trim();
            String birthday = data[3].trim();
            String address = data[4].trim();
            String phoneNumber = data[5].trim();
            String sss = data[6].trim();
            String philhealth = data[7].trim();
            String tin = data[8].trim();
            String pagibig = data[9].trim();
            String status = data[10].trim();
            String position = data[11].trim();
            String immediateSupervisor = data[12].trim();
            
            double basicSalary = Double.parseDouble(data[13].replace("\"", "").replace(",", "").trim());
            double riceSubsidy = Double.parseDouble(data[14].replace("\"", "").replace(",", "").trim());
            double phoneAllowance = Double.parseDouble(data[15].replace("\"", "").replace(",", "").trim());
            double clothingAllowance = Double.parseDouble(data[16].replace("\"", "").replace(",", "").trim());
            double grossSemiMonthlyRate = Double.parseDouble(data[17].replace("\"", "").replace(",", "").trim());
            double hourlyRate = Double.parseDouble(data[18].replace("\"", "").replace(",", "").trim());

            EmployeeFinancials financials = new EmployeeFinancials(basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate);
            return new Employee(employeeId, lastName, firstName, birthday, address, phoneNumber, sss, philhealth, tin, pagibig, status, position, immediateSupervisor, financials);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing employee data: " + e.getMessage());
            return null;
        }
    }
}
