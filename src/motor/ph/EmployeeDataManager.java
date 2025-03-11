/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lasic
 */
public class EmployeeDataManager {
    //Class That Handles EMPLOYEE CSV FILE & DATA
    private static final String FILE_NAME = "C:\\Users\\Nia\\Downloads\\MOTORPH-GROUP3-master\\MOTORPH-GROUP3-master\\src\\motor\\resources\\employee-data.csv";

    public static List<Employee> readFromCSV() {
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                Employee emp = EmployeeCSVParser.parseEmployee(data);
                if (emp != null) employeeList.add(emp);
            }
        } catch (IOException e) {
            System.out.println("Error reading employee data: " + e.getMessage());
        }
        return employeeList;
    }
}
