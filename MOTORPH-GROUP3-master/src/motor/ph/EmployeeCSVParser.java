/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
public class EmployeeCSVParser {
    //Class to Parse Employee Data from CSV
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


