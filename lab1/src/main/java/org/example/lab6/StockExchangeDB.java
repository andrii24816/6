//package org.example;
//
//import java.sql.*;
//
//public class StockExchangeDB {
//    // Блок объявления констант
//    public static final String DB_URL = "jdbc:mysql://localhost/store";
//    public static final String DB_Driver = "org.h2.Driver";
//
//    public static void main(String[] args) {
//        try {
//            Connection connection = DriverManager.getConnection();//соединениесБД
//            System.out.println("Соединение с СУБД выполнено.");
//            connection.close();       // отключение от БД
//            System.out.println("Отключение от СУБД выполнено.");
//        }  catch (SQLException e) {
//        e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
//        System.out.println("Ошибка SQL !");
//    }
//    }
//}