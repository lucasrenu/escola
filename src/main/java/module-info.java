module com.controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.controllers to javafx.fxml;
    exports com.controllers;
}
