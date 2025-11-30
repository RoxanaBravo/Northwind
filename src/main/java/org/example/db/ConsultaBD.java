package org.example.db;
import org.example.db.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBD {

    public static void mostrarTodosLosProductos() {
        try {
            Connection con = DBconnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            System.out.println(" ");
            System.out.println("=== TODOS LOS PRODUCTOS ===");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("nombre") + " | " +
                                rs.getString("descripcion") + " | " +
                                rs.getInt("cantidad") + " | " +
                                rs.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error mostrando productos: " + e.getMessage());
        }
    }

    public static void insertarProductosFavoritos() {
        try {
            Connection con = DBconnection.getConnection();
            Statement stmt = con.createStatement();

            int filas = stmt.executeUpdate(
                    "INSERT INTO productos_fav (id_producto) " +
                            "SELECT id FROM productos WHERE precio > 1000"
            );

            System.out.println("Se han insertado " + filas + " productos favoritos.");
        } catch (SQLException e) {
            System.out.println("Error insertando favoritos: " + e.getMessage());
        }
    }

    public static void mostrarProductosFavoritos() {
        try {
            Connection con = DBconnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT pf.id, p.nombre, p.precio " +
                    "FROM productos_fav pf " +
                    "JOIN productos p ON pf.id_producto = p.id";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(" ");
            System.out.println("=== PRODUCTOS FAVORITOS ===");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("nombre") + " | " +
                                rs.getDouble("precio")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error mostrando favoritos: " + e.getMessage());
        }
    }

    public static void mostrarProductosMenor600() {
        try {
            Connection con = DBconnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM productos WHERE precio < 600"
            );

            System.out.println(" ");
            System.out.println("=== PRODUCTOS HASTA 600€ ===");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("nombre") + " | " +
                                rs.getDouble("precio")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error mostrando productos: " + e.getMessage());
        }
    }
    public static void insertarFavoritosMayor1000() {
        try {
            Connection conn = DBconnection.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                    "INSERT INTO productos_fav (id_producto) " +
                            "SELECT id FROM productos WHERE precio > 1000"
            );

        } catch (Exception e) {
            System.out.println("Error insertando favoritos > 1000: " + e.getMessage());
        }
    }



}

