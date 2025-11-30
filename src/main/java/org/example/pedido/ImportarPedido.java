package org.example.pedido;

import org.example.db.DBconnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ImportarPedido {

        public static void insertarPedidos() {
            try {
                Connection conn = DBconnection.getConnection();
                Statement stmt = conn.createStatement();

                // IMPORTANTE: los id_producto deben existir en tu tabla productos
                stmt.executeUpdate("INSERT INTO pedidos (id_empleado, id_producto, cantidad) VALUES (1, 1, 2)");
                stmt.executeUpdate("INSERT INTO pedidos (id_empleado, id_producto, cantidad) VALUES (2, 5, 1)");
                stmt.executeUpdate("INSERT INTO pedidos (id_empleado, id_producto, cantidad) VALUES (3, 3, 4)");

            } catch (SQLException e) {
                System.out.println(" Error insertando pedidos: " + e.getMessage());
            }
        }
    }

