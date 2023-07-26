package com.joki.controller;

import com.joki.application.Application;
import com.joki.model.Empleado;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadoController implements Initializable {

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableView<?> tableViewClientes;

    @FXML
    private TableColumn<?, ?> columnApellidoCliente;

    @FXML
    private TableColumn<?, ?> columnEmpleadoEncargadoCliente;

    @FXML
    private TableColumn<?, ?> columnIdCliente;

    @FXML
    private TableColumn<?, ?> columnNombreCliente;

    @FXML
    private TextField txtApellidoCliente;

    @FXML
    private TextField txtIdCliente;

    @FXML
    private TextField txtNombreCliente;

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

    //--------------------------------------- FUNCIONES MANEJO CLIENTES -------------------------------------
    @FXML
    void agregarCliente(ActionEvent event) {

    }

    @FXML
    void btnActualzarCliente(ActionEvent event) {

    }

    @FXML
    void clienteNuevo(ActionEvent event) {

    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

}
