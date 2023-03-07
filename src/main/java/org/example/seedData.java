package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class seedData {

    public static void main()
    {
        GetConnection getCon = new GetConnection();
        Connection con = getCon.getConnection();
        try{
            Statement query;
            query = con.createStatement();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }


}
