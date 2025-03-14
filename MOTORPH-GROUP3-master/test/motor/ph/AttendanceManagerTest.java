/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package motor.ph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
public class AttendanceManagerTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setting up class...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tearing down class...");
    }

    @Before
    public void setUp() {
        System.out.println("Setting up before each test...");
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up after each test...");
    }

    /**
     * Test of saveAttendanceToCSV method, of class AttendanceManager.
     */
    @Test
    public void testSaveAttendanceToCSV() {
        System.out.println("Running testSaveAttendanceToCSV");

        // Use Valid Data
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

AttendanceRecord attendance = new AttendanceRecord(
    10001, "Garcia", "Manuel III",
    LocalDate.of(2024, 3, 8).format(dateFormatter),  // Convert LocalDate to String
    LocalTime.of(8, 0).format(timeFormatter),        // Convert LocalTime to String
    LocalTime.of(17, 0).format(timeFormatter)        // Convert LocalTime to String
);

        // No exception should occur
        try {
            AttendanceManager.saveAttendanceToCSV(attendance);
        } catch (Exception e) {
            fail("Exception occurred while saving attendance: " + e.getMessage());
        }
    }

    /**
     * Test of readFromCSV method, of class AttendanceManager.
     */
    @Test
    public void testReadFromCSV_EmptyFile() {
    System.out.println("Running testReadFromCSV_EmptyFile");

    // Define test file path
    String testFileName = "C:\\Users\\lasic\\OneDrive\\Documents\\NetBeansProjects\\MOTOR-PH\\build\\classes\\motor\\resources\\attendance_data.csv";
    File file = new File(testFileName);

    try {
        // Ensure a fresh empty test file
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile(); // Create an empty file

        // Debugging: Confirm file exists but is empty
        System.out.println("Test CSV file created: " + file.getAbsolutePath());

    } catch (IOException e) {
        fail("Test setup failed: Unable to create an empty CSV file.");
    }

    // Read from the empty CSV file
    List<AttendanceRecord> result = AttendanceManager.readFromCSV();

    // Debugging: Print results
    System.out.println("Result from readFromCSV(): " + result.size() + " records found"); 

    // Assertions
    assertNotNull("readFromCSV() should not return null", result);
    assertTrue("readFromCSV() should return an empty list if CSV has no data", result.isEmpty());
}



    /**
     * Test of getAttendanceByEmployeeId method, of class AttendanceManager.
     */
    @Test
    public void testGetAttendanceByEmployeeId() {
    System.out.println("Running testGetAttendanceByEmployeeId");

    int empId = 99999;  // Employee ID that does not exist
    List<AttendanceRecord> result = AttendanceManager.getAttendanceByEmployeeId(empId);
    
    System.out.println("Result from getAttendanceByEmployeeId(" + empId + "): " + result);  //  Debugging line

    assertNotNull("getAttendanceByEmployeeId() should not return null", result);
    assertTrue("getAttendanceByEmployeeId() should return an empty list if no attendance", result.isEmpty());
}

}