package com.joki.controller;


import com.joki.application.Application;
import com.joki.model.Empleado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtUsuario;

    private Application application;
    private Stage stage;
    private Empleado empleadoLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //-------------------------- FUNCIONES LOGIN ------------------------------------------------------------
    @FXML
    void loginEmpleado(ActionEvent event) throws IOException {
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        if(datosValidosEmpleado(usuario, contrasenia)) {
            empleadoLogin = mfm.darEmpleadoLogin(usuario, contrasenia);
            if(empleadoLogin == null) {
                mostrarMensaje("Notificación Login", "No existe el empleado", "No hay un empleado con esos datos", Alert.AlertType.WARNING);
            } else {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Application.class.getResource("/com/joki/view/EmpleadoView.fxml"));
                BorderPane borderPane = (BorderPane) loader.load();
                EmpleadoController controller = loader.getController();
                controller.setAplicacion(application);
                Scene scene = new Scene(borderPane);
                Stage stage = new Stage();
                stage.setTitle("Funcionalidad empleado");
                stage.setScene(scene);
                controller.init(stage, this, empleadoLogin);
                stage.show();
                this.stage.close();
            }
        }
    }

    /**
     * Verifica espacios en blanco
     * @param usuario
     * @param contrasenia
     * @return
     */
    private boolean datosValidosEmpleado(String usuario, String contrasenia) {
        String notificacion = "";
        if(usuario == null || usuario.equals("")) {
            notificacion += "El usuario está en blanco\n";
        }
        if(contrasenia == null || contrasenia.equals("")) {
            notificacion += "La contraseña está en blanco\n";
        }
        if(notificacion.equals("")) {
            return true;
        }
        mostrarMensaje("Notificación Login", "Información invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }


    /**
     * Muestra un mensaje por interfaz
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
}