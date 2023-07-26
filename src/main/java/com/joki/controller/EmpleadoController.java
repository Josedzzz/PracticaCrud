package com.joki.controller;

import com.joki.application.Application;
import com.joki.exceptions.ClienteYaExistenteException;
import com.joki.model.Cliente;
import com.joki.model.Empleado;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadoController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

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
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TableColumn<Cliente, String> columnApellidoCliente;

    @FXML
    private TableColumn<Cliente, String> columnEmpleadoEncargadoCliente;

    @FXML
    private TableColumn<Cliente, String> columnIdCliente;

    @FXML
    private TableColumn<Cliente, String> columnNombreCliente;

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
    private Cliente clienteSeleccionado;
    ObservableList<Cliente> listadoCliente = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Datos de la tableView de clientes
        this.columnNombreCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
        this.columnApellidoCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getApellido()));
        this.columnIdCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getId()));
        this.columnEmpleadoEncargadoCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getEmpleadoCliente().getUsuario()));
        //Selecciono datos en la table
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null) {
                clienteSeleccionado = newSelection;
                mostrarInformacionCliente();
            }
        });
    }

    public void setAplicacion(Application application) {
        this.aplicacion = application;
        //Lista de clientes a mostrar
        tableViewClientes.getItems().clear();
        tableViewClientes.setItems(getClientes());
    }

    private ObservableList<Cliente> getClientes() {
        listadoCliente.addAll(mfm.getListaClientes());
        return listadoCliente;
    }

    public void init(Stage stage, LoginController loginController, Empleado empleadoLogin) {
        this.loginController = loginController;
        this.empleadoLogin = empleadoLogin;
        this.stage = stage;
    }

    /**
     * Mouestra la interfaz de un mensaje
     * @param title
     * @param header
     * @param content
     * @param alertType
     */
    public void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //--------------------------------------- FUNCIONES MANEJO CLIENTES -------------------------------------

    /**
     *
     * @param event
     * @throws ClienteYaExistenteException
     */
    @FXML
    void agregarCliente(ActionEvent event) throws ClienteYaExistenteException {
        String nombre = txtNombreCliente.getText();
        String apellido = txtApellidoCliente.getText();
        String id = txtIdCliente.getText();
        if(datosValidosClientes(nombre, apellido, id)) {
            crearCliente(nombre, apellido, id);
        }
    }

    private void crearCliente(String nombre, String apellido, String id) {

    }

    @FXML
    void btnActualzarCliente(ActionEvent event) {

    }

    @FXML
    void clienteNuevo(ActionEvent event) {
        txtNombreCliente.setText("");
        txtApellidoCliente.setText("");
        txtIdCliente.setText("");
        //Habilito campos
        txtIdCliente.setDisable(false);
    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

    /**
     * Muestra los datos de un cliente en los textFields
     */
    private void mostrarInformacionCliente() {
        txtNombreCliente.setText(clienteSeleccionado.getNombre());
        txtApellidoCliente.setText(clienteSeleccionado.getApellido());
        txtIdCliente.setText(clienteSeleccionado.getId());
        //Deshabilito campos
        txtIdCliente.setDisable(true);
    }

    /**
     * Verifica que los datos en los txt no esten vacios
     * @param nombre
     * @param apellido
     * @param id
     * @return
     */
    private boolean datosValidosClientes(String nombre, String apellido, String id) {
        String notificacion = "";
        if(nombre == null || nombre.equals("")) {
            notificacion += "Ingrese el nombre\n";
        }
        if(apellido == null || apellido.equals("")) {
            notificacion += "Ingrese el apellido\n";
        }
        if(id == null || id.equals("")) {
            notificacion += "Ingrese el id\n";
        }
        if(notificacion.equals("")) {
            return true;
        }
        mostrarMensaje("Notificación Empleado", "Información del cliente invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }

}
