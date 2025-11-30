package org.example.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBconnection {

        private static final String URL = "jdbc:mysql://localhost:3306/almacen";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        private static Connection connection;

        public static Connection getConnection() {
            if (connection == null) {
                try {
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                } catch (SQLException e) {
                    System.out.println(" Error al conectar: " + e.getMessage());
                }
            }
            return connection;
        }

        // Cerrar conexión
        public static void closeConnection() {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(" Error al cerrar: " + e.getMessage());
                }
            }
        }
    }
