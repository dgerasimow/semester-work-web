package com.gerasimov.net.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostgresConnectionHelper {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostgresConnectionHelper.class);
    private static Connection connection;
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/semesterWork";
    public static final String USER = "thw1zard";
    public static final String PASSWORD = "";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                LOGGER.error("Failed connect to db", e);
            }
        }
        return connection;
    }
}
