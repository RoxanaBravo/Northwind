package org.example;

import org.example.db.ConsultaBD;
import org.example.db.DBconnection;
import org.example.empleados.ImportarEmpleado;
import org.example.json.ImportarProducto;
import org.example.pedido.ImportarPedido;

public class Main {
    public static void main(String[] args) {
        ImportarProducto importer = new ImportarProducto();
        importer.importarProductos();
        ImportarEmpleado.insertarEmpleados();
        ImportarPedido.insertarPedidos();

        // CONSULTAS
        ConsultaBD.mostrarTodosLosProductos();
        ConsultaBD.mostrarProductosMenor600();
        ConsultaBD.insertarProductosFavoritos();
        ConsultaBD.mostrarProductosFavoritos();
        ConsultaBD.insertarFavoritosMayor1000();
        //cerrar base de daatos
        DBconnection.closeConnection();

    }
}