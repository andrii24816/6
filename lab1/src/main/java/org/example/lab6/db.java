package org.example.lab6;

import java.sql.Connection;
import java.sql.SQLException;


public class db {
    private final static String PEOPLE_DETAILS = "Name varchar(30) not null, Number long, Exp int, CodeP long";
    private final static String EMPLOYEE_DETAILS = "company varchar(30) not null, position varchar(30), salary int, ";

    private static void createTable(String tableName, String createTableDetails){
        try (Connection conn = Connector.getConnection();
             var statement = conn.createStatement();) {
            String sql = "CREATE TABLE " + tableName +
                    "(id varchar(50) default(uuid()) PRIMARY KEY, " +
                    createTableDetails + ")";
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createAllTables(){
        createTable("People", PEOPLE_DETAILS);
        createTable("Employee", EMPLOYEE_DETAILS);
    }

    private static void deleteTable(String tableName){
        try (Connection conn = Connector.getConnection();
             var statement = conn.createStatement();) {
            statement.executeUpdate("DROP TABLE " + tableName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dropAllTables(){
        deleteTable("People");
        deleteTable("Employee");
    }
}
