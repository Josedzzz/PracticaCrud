package com.joki.controller;

import com.joki.model.Banco;
import com.joki.model.Cliente;
import com.joki.model.Empleado;

import java.lang.module.Configuration;

public class ModelFactoryController {
    Banco banco = null;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    private static class SingletonHolder {
        //El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    //Método para obtener la instacia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocacion clase singleton");
        inicializarDatos();
    }

    private void inicializarDatos() {
        banco = new Banco("Joji");
        //Inicializar datos de empleados y clientes
        Empleado empleado1 = new Empleado("Camilo", "Albaran", "123", "Dark", "123");
        Cliente cliente1 = new Cliente("Jose", "Amaya", "777");
    }
}
