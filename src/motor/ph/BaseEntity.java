/*
 * BaseEntity.java
 * 
 * This abstract class serves as the base for all employee-related entities,
 * providing common properties such as employee ID, last name, and first name.
 */
package motor.ph;

/**
 * The BaseEntity class is an abstract class that defines common attributes and behavior
 * for all entities related to employees.
 */
public abstract class BaseEntity {
    
    /** The unique ID of the employee. */
    protected int employeeId;
    
    /** The last name of the employee. */
    protected String lastName;
    
    /** The first name of the employee. */
    protected String firstName;

    /**
     * Constructs a BaseEntity object with the specified employee details.
     * 
     * @param employeeId The unique ID of the employee.
     * @param lastName The last name of the employee.
     * @param firstName The first name of the employee.
     */
    public BaseEntity(int employeeId, String lastName, String firstName) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /**
     * Gets the employee ID.
     * 
     * @return The employee's ID.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets the last name of the employee.
     * 
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the first name of the employee.
     * 
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Abstract method that must be implemented by subclasses to print entity-specific details.
     */
    public abstract void printDetails();
}
