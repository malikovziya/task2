package com.servletconfigapp.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static public Connection con = null;
    public static Connection getCon() throws Exception
    {
        if(con == null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDatabase", "root", "password");

        }
        return con;
    }
}
