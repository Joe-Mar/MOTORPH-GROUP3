/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lasic
 */
public class AttendanceServiceTest {
    
    public AttendanceServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of viewAttendance method, of class AttendanceService.
     */
    @Test
    public void testViewAttendance() {
    System.out.println("viewAttendance");

    // Provide a valid input format that matches what viewAttendance expects
    Scanner scanner = new Scanner(new ByteArrayInputStream("1\n".getBytes())); 

    AttendanceService.viewAttendance(scanner);

    scanner.close();
}


}
