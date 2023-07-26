package com.joki.controller;

import com.joki.application.Application;
import com.joki.model.Empleado;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadoController implements Initializable {

    //Variables auxiliares
    private Stage stage;
    private Application aplicacion;
    private LoginController loginController;
    private Empleado empleadoLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setAplicacion(Application application) {
        this.aplicacion = application;
    }

    public void init(Stage stage, LoginController loginController, Empleado empleadoLogin) {
        this.loginController = loginController;
        this.empleadoLogin = empleadoLogin;
        this.stage = stage;
    }

}
