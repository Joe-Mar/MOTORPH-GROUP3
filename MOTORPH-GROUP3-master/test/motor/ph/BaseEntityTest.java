/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lasic
 */
public class BaseEntityTest {
    
    private BaseEntity instance;

    public BaseEntityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //  Initialize a valid instance before each test
        instance = new BaseEntityImpl(10001, "Garcia", "Manuel");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEmployeeId method, of class BaseEntity.
     */
    @Test
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        int expResult = 10001;
        int result = instance.getEmployeeId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class BaseEntity.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Garcia";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class BaseEntity.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Manuel";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of printDetails method, of class BaseEntity.
     */
    @Test
    public void testPrintDetails() {
        System.out.println("printDetails");
        instance.printDetails();
    }

    //  Concrete subclass of BaseEntity (needed since BaseEntity is abstract)
    public class BaseEntityImpl extends BaseEntity {
        public BaseEntityImpl(int employeeId, String lastName, String firstName) {
            super(employeeId, lastName, firstName);
        }

        @Override
        public void printDetails() {
            System.out.println("Employee ID: " + getEmployeeId() + 
                               ", Name: " + getFirstName() + " " + getLastName());
        }
    }
}




