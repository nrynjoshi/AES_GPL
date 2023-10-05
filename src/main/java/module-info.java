module com.example.gplapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;
    requires testng;

    opens com.narayanjoshi.gplapplication to javafx.fxml;
    exports com.narayanjoshi.gplapplication;
    exports com.narayanjoshi.gplapplication.service;
    opens com.narayanjoshi.gplapplication.service to javafx.fxml;
    exports com.narayanjoshi.gplapplication.service.command;
    opens com.narayanjoshi.gplapplication.service.command to javafx.fxml;
}