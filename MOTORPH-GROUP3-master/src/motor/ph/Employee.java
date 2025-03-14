/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

import java.util.List;

public class Employee extends BaseEntity {
    //SubClass of BaseEntity
    private String birthday;
    private String address;
    private String phoneNumber;
    private String sss;
    private String philhealth;
    private String tin;
    private String pagibig;
    private String status;
    private String position;
    private String immediateSupervisor;
    private EmployeeFinancials financials; // Stores salary-related data

    public Employee(int employeeId, String lastName, String firstName, String birthday, String address,
                    String phoneNumber, String sss, String philhealth, String tin, String pagibig,
                    String status, String position, String immediateSupervisor, EmployeeFinancials financials) {
        super(employeeId, lastName, firstName);
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sss = sss;
        this.philhealth = philhealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.financials = financials;
    }

    // Getters
    public String getBirthday() { return birthday; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getSss() { return sss; }
    public String getPhilhealth() { return philhealth; }
    public String getTin() { return tin; }
    public String getPagibig() { return pagibig; }
    public String getStatus() { return status; }
    public String getPosition() { return position; }
    public String getImmediateSupervisor() { return immediateSupervisor; }
    public EmployeeFinancials getFinancials() { return financials; }
    
// This is How it Will Print on Main
    @Override
    public void printDetails() {
        System.out.println("\nEmployee ID: " + employeeId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Birthday: " + birthday);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("SSS: " + sss);
        System.out.println("PhilHealth: " + philhealth);
        System.out.println("TIN: " + tin);
        System.out.println("Pag-ibig: " + pagibig);
        System.out.println("Status: " + status);
        System.out.println("Position: " + position);
        System.out.println("Immediate Supervisor: " + immediateSupervisor);
        financials.printFinancialDetails(); // Prints salary details
    }
}
