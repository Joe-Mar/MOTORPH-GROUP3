/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

public class AttendanceRecord extends BaseEntity {
     private String date;
    private String logInTime;
    private String logOutTime;

    public AttendanceRecord(int employeeId, String lastName, String firstName, String date, String logInTime, String logOutTime) {
        super(employeeId, lastName, firstName);
        this.date = date;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }

    public String getDate() {
        return date;
    }

    public String getLogin() {
        return logInTime;
    }

    public String getLogout() {
        return logOutTime;
    }

    // This method exists to Ensure it will Print on the System
    public void printAttendanceDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Last Name: " + lastName);
        System.out.println("First Name: " + firstName);
        System.out.println("Date: " + date);
        System.out.println("Log In: " + logInTime);
        System.out.println("Log Out: " + logOutTime);
        System.out.println("----------------------------------");
    }

    @Override
    public void printDetails() {
        printAttendanceDetails();
    }
}





