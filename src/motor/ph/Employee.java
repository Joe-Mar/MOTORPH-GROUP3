/*
 * Employee.java
 * 
 * This class represents an Employee entity that extends the BaseEntity class.
 * It stores personal, employment, and financial information of an employee.
 */
package motor.ph;

import java.util.List;

/**
 * The Employee class encapsulates details of an employee, including personal,
 * employment, and financial information.
 */
public class Employee extends BaseEntity {
    
    /** The employee's birthdate. */
    private String birthday;
    
    /** The employee's residential address. */
    private String address;
    
    /** The employee's contact number. */
    private String phoneNumber;
    
    /** The employee's SSS (Social Security System) number. */
    private String sss;
    
    /** The employee's PhilHealth number. */
    private String philhealth;
    
    /** The employee's TIN (Tax Identification Number). */
    private String tin;
    
    /** The employee's Pag-IBIG membership number. */
    private String pagibig;
    
    /** The employment status of the employee (e.g., Regular, Probationary). */
    private String status;
    
    /** The employee's job position. */
    private String position;
    
    /** The name of the employee's immediate supervisor. */
    private String immediateSupervisor;
    
    /** Stores salary and financial-related details of the employee. */
    private EmployeeFinancials financials;

    /**
     * Constructs an Employee object with the specified details.
     *
     * @param employeeId The unique ID of the employee.
     * @param lastName The last name of the employee.
     * @param firstName The first name of the employee.
     * @param birthday The employee's birthdate.
     * @param address The employee's residential address.
     * @param phoneNumber The employee's contact number.
     * @param sss The employee's SSS number.
     * @param philhealth The employee's PhilHealth number.
     * @param tin The employee's TIN number.
     * @param pagibig The employee's Pag-IBIG number.
     * @param status The employment status of the employee.
     * @param position The job position of the employee.
     * @param immediateSupervisor The immediate supervisor of the employee.
     * @param financials The financial details of the employee.
     */
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
    
    /**
     * Prints the details of the employee, including personal and financial information.
     */
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