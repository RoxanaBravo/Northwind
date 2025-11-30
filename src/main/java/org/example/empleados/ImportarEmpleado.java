package org.example.empleados;

import org.example.db.DBconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ImportarEmpleado {

    public static void insertarEmpleados() {
        try {
            Connection conn = DBconnection.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO empleados (nombre) VALUES ('Carlos')");
            stmt.executeUpdate("INSERT INTO empleados (nombre) VALUES ('Ana')");
            stmt.executeUpdate("INSERT INTO empleados (nombre) VALUES ('Luis')");

        } catch (SQLException e) {
            System.out.println(" Error insertando empleados: " + e.getMessage());
        }
    }
}
