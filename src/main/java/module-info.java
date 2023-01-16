module com.controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.controllers to javafx.fxml;
    opens com.classes to javafx.base;
    exports com.controllers;
}
