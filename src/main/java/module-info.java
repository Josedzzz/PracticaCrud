module com.joki.crudj {
    requires javafx.controls;
    requires javafx.fxml;
            

    exports com.joki.application;
    opens com.joki.application to javafx.fxml;
    exports com.joki.controller;
    opens com.joki.controller to javafx.fxml;
}