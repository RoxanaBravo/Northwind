package org.example.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableInfo {

    public static void mostrarEstructura(String nombreTabla) {

        Connection conn = DBconnection.getConnection();

        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet columnas = meta.getColumns(null, null, nombreTabla, null);

            System.out.println("=== Estructura de la tabla: " + nombreTabla + " ===");

            while (columnas.next()) {
                String nombreCol = columnas.getString("COLUMN_NAME");
                String tipo = columnas.getString("TYPE_NAME");
                int tam = columnas.getInt("COLUMN_SIZE");

                System.out.println("- " + nombreCol + " | Tipo: " + tipo + " | Tamaño: " + tam);
            }

        } catch (SQLException e) {
            System.out.println(" Error leyendo estructura: " + e.getMessage());
        }
    }
}
