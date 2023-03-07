package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AcademicOfficeTest2 {

    AcademicOffice officer = new AcademicOffice("staffdeanoffice@iitrpr.ac.in");
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }



    @Test
    void isAddCourseActive() {
        String query = "";
        try{
            query = "update current_session set status = 8";
            PreparedStatement preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.execute();

            assertEquals(false,officer.isAddCourseActive());

            query = "update current_session set status = 7";
            preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.execute();

            assertEquals(true,officer.isAddCourseActive());


        }catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }

    }

    @Test
    void addCourse() {
        try{
            String query = "update current_session set status = 8";
            PreparedStatement preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.execute();

            boolean ans = officer.addCourse("LAN101","LAN","CSE",1,3,3,3,3,"pc",2020);
            assertEquals(false,ans);

            query = "update current_session set status = 7";
            preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.execute();

            ans = officer.addCourse("LAN101","LAN","CSE",1,3,3,3,3,"pc",2020);
            assertEquals(true,ans);

            ans = officer.addCourse("CS305","software Engineering","CSE",6,3,3,3,3,"pc",2024);
            assertEquals(true,ans);

            query = "delete from course_catalogue where course_id = ?";
            preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.setString(1,"LAN101");
            preparedStatement.execute();

            query = "delete from course where course_id = ?";
            preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.setString(1,"LAN101");
            preparedStatement.execute();

            query = "delete from course_catalogue where course_id = ? and batch = ?";
            preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.setString(1,"CS305");
            preparedStatement.setInt(2,2024);
            preparedStatement.execute();


        }catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }
    }

    @Test
    void isGradesSubmissionEnded() {
        try{
            String query = "update current_session set status = 8";
            PreparedStatement preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.execute();

            assertEquals(false,officer.isGradesSubmissionEnded());

            query = "update current_session set status = 6";
            preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.execute();

            assertEquals(true,officer.isGradesSubmissionEnded());


        }catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }

    }
    @Test
    void promote(){
        try{
            String query = "update current_session set status = 6";
            PreparedStatement preparedStatement = officer.con.prepareStatement(query);
            preparedStatement.execute();

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        String path = "/home/ashish/hdd/study/java_proj/AIIMSPortal/src/main/java/org/example/seedData/promote.csv";
        boolean ans = officer.promote(path,2020);

        assertEquals(true,ans);

        ans = officer.demote(path,2020);
        assertEquals(true,ans);
    }

    @Test
    void generateTranscript() {

        boolean ans = officer.generateTranscript("2020csb1101@iitrpr.ac.in");
        assertEquals(true,ans);
        ans = officer.generateTranscript("2020lsb@iitrpr.ac.in");
        assertEquals(false,ans);
    }

    @Test
    void generateTranscriptForAll() {
        boolean ans = officer.generateTranscriptForAll(2020);
        assertEquals(true,ans);
    }

    @Test
    void logOut() throws SQLException {
        Connection con = officer.con;
        boolean ans = officer.logOut();
        assertEquals(ans,true);
        officer.con = con;
    }

    @Test
    void printMainMenu() {
        boolean ans = officer.printMainMenu();
        assertEquals(true,ans);
    }

    @Test
    void printActivityMenu() {
        boolean  ans = officer.printActivityMenu();
        assertEquals(true,ans);

    }

    @Test
    void printCourseTypeMenu() {
        boolean ans = officer.printCourseTypeMenu();
        assertEquals(true,ans);
    }

    @Test
    void printTranscriptMenu() {
        boolean ans = officer.printTranscriptMenu();
        assertEquals(true,ans);
    }

    @Test
    void runOffice() {

    }

}