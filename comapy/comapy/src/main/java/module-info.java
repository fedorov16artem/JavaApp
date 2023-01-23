module com.example.comapy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.example.comapy to javafx.fxml;
    exports com.example.comapy;
    exports com.example.comapy.controllers;
    opens com.example.comapy.controllers to javafx.fxml;
}