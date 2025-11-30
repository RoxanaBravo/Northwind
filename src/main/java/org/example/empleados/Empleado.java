package org.example.empleados;

public class Empleado {
    private int id;
    private String nombre;


    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
}
