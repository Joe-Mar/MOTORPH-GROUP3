/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor.ph;

/**
 *
 * @author lasic
 */
public abstract class BaseEntity {
    //Abstract Of All Class
    protected int employeeId;
    protected String lastName;
    protected String firstName;

    public BaseEntity(int employeeId, String lastName, String firstName) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
// Abstract method that must be implemented in subclasses
    public abstract void printDetails();
}

