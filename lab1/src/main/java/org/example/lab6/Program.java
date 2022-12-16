package org.example.lab6;

import java.sql.Connection;
import java.sql.DriverManager;

public class Program{

    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql:/store";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url)){

                System.out.println("Connection to Store DB succesfull!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}