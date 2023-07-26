package com.joki.model;

public class Cliente extends Persona {

    private Empleado empleadoCliente;

    public Cliente(String nombre, String apellido, String id, Empleado empleadoCliente) {
        super(nombre, apellido, id);
        this.empleadoCliente = empleadoCliente;
    }

    public Cliente() {
    }

    public Empleado getEmpleadoCliente() {
        return empleadoCliente;
    }

    public void setEmpleadoCliente(Empleado empleadoCliente) {
        this.empleadoCliente = empleadoCliente;
    }
}
