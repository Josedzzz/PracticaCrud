package com.joki.application;

import com.joki.controller.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        mostrarVentanaPrincipal();
    }

    private void mostrarVentanaPrincipal() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/com/joki/view/LoginView.fxml"));
            BorderPane borderPane = (BorderPane) loader.load();
            LoginController ventanaPrincipalController = loader.getController();
            ventanaPrincipalController.setApplication(this);

            Scene scene = new Scene(borderPane);
            primaryStage.setScene(scene);
            primaryStage.show();
            LoginController controller = loader.getController();
            controller.setStage(primaryStage);
        }catch(Exception e){

        }
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}