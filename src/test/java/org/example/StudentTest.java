package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student std = new Student("2020csb1101@iitrpr.ac.in");
    Instructor prof = new Instructor("gunturi@iitrpr.ac.in");

    StudentTest() throws SQLException {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void viewCourseOffering() throws SQLException {
        boolean ans = std.viewCourseOffering(std.con);
        assertEquals(true,ans);
    }
//
//    @Test
//    void changeProfileNumber() throws SQLException {
//        assertEquals(true,std.changeProfileNumber("99999999"));
//    }
//
//    @Test
//    void changeProfileName() throws SQLException {
//
//        assertEquals(true,std.changeProfileName("staff"));
//    }
//
//    @Test
//    void isCourseRegistraionActive() throws SQLException {
//
//        String query = "update current_session set status = 4";
//        PreparedStatement preparedStatement = std.con.prepareStatement(query);
//        preparedStatement.execute();
//
//        assertEquals(false,std.isCourseRegistraionActive());
//
//        query = "update current_session set status = 3";
//        preparedStatement = std.con.prepareStatement(query);
//        preparedStatement.execute();
//
//        assertEquals(true,std.isCourseRegistraionActive());
//    }
//
//    @Test
//    void checkIfFloated() throws SQLException {
//        String query = "update current_session set status = 1 ";
//        PreparedStatement preparedStatement = prof.con.prepareStatement(query);
//        preparedStatement.execute();
//        boolean ans = prof.floatCourse("DM102","CSE",5);
//        assertEquals(true,ans);
//
//        ans = std.checkIfFloated("DM102");
//        assertEquals(true,ans);
//
//        query = "update current_session set status = 1 ";
//        preparedStatement = prof.con.prepareStatement(query);
//        preparedStatement.execute();
//        ans = prof.deFloatCourse("DM102","CSE");
//
//        assertEquals(true,ans);
//
//        ans = std.checkIfFloated("DM102");
//        assertEquals(false,ans);
//
//    }
//
//    @Test
//    void satisfyCGPACriteria() throws SQLException {
//
//    }

    @Test
    void satisfyPrerequisite() {


    }

    @Test
    void satisfyRequiredSem() {
    }

    @Test
    void findCreditLimit() {
    }

    @Test
    void satisfyCreditLimitCUMUpdate() {
    }

    @Test
    void registerCourse() {

    }

    @Test
    void deRegisterCourse() {
    }

    @Test
    void printMainMenu() {
        std.printMainMenu();
    }

    @Test
    void logOut() {
    }

//    @Test
//    void runStudent() throws SQLException {
////        String input = "1\nexit\n"; // Provide input to the program
////        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
////
////        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////        PrintStream printStream = new PrintStream(outputStream);
////
////        // Save the original System.in and System.out streams
////        InputStream originalInputStream = System.in;
////        PrintStream originalPrintStream = System.out;
////        try{
////            System.setIn(inputStream);
////            System.setOut(printStream);
////
////            std.runStudent(std.student_id);
////            String output = outputStream.toString();
//////            assertEquals(output,"Exiting Faculty Menu..");
////
////        }finally {
////            // Reset the System.in and System.out streams to their original values
////            System.setIn(originalInputStream);
////            System.setOut(originalPrintStream);
////        }
//    }

}