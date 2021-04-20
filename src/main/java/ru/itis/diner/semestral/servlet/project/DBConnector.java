package ru.itis.diner.semestral.servlet.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String USERS_DB_URL = "jdbc:postgresql://localhost:5432/registrationservletdb";
    static final String USER = "postgres";
    static final String PASS = "230401pAZ";
    static Connection conn = null;
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(USERS_DB_URL, USER, PASS);
        } catch (Exception e){
            throw new SQLException(e.getMessage());
        }
        return conn;
    }
}