package com.joki.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private List<Empleado> listaEmpleados;
    private List<Cliente> listaClientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<Empleado>();
        this.listaClientes = new ArrayList<Cliente>();
    }

    public Banco() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
