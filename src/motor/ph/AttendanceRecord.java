/*
 * AttendanceRecord.java
 * 
 * This class represents an attendance record for an employee, storing details such as
 * date, login time, and logout time. It extends BaseEntity, which provides basic employee information.
 */
package motor.ph;

/**
 * The AttendanceRecord class holds an employee's attendance details,
 * including date, login time, and logout time.
 */
public class AttendanceRecord extends BaseEntity {
    
    /** The date of the attendance record. */
    private String date;
    
    /** The login time of the employee. */
    private String logInTime;
    
    /** The logout time of the employee. */
    private String logOutTime;

    /**
     * Constructs an AttendanceRecord object with employee details and attendance information.
     * 
     * @param employeeId The employee's ID.
     * @param lastName The employee's last name.
     * @param firstName The employee's first name.
     * @param date The date of the attendance record.
     * @param logInTime The login time of the employee.
     * @param logOutTime The logout time of the employee.
     */
    public AttendanceRecord(int employeeId, String lastName, String firstName, String date, String logInTime, String logOutTime) {
        super(employeeId, lastName, firstName);
        this.date = date;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }

    /**
     * Gets the date of the attendance record.
     * 
     * @return The date as a string.
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the login time of the employee.
     * 
     * @return The login time as a string.
     */
    public String getLogin() {
        return logInTime;
    }

    /**
     * Gets the logout time of the employee.
     * 
     * @return The logout time as a string.
     */
    public String getLogout() {
        return logOutTime;
    }

    /**
     * Prints the attendance details of the employee to the system output.
     */
    public void printAttendanceDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Last Name: " + lastName);
        System.out.println("First Name: " + firstName);
        System.out.println("Date: " + date);
        System.out.println("Log In: " + logInTime);
        System.out.println("Log Out: " + logOutTime);
        System.out.println("----------------------------------");
    }

    /**
     * Overrides the printDetails method from BaseEntity to print attendance details.
     */
    @Override
    public void printDetails() {
        printAttendanceDetails();
    }
}
