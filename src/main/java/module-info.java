module com.example.gplapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;
    requires testng;

    opens com.example.gplapplication to javafx.fxml;
    exports com.example.gplapplication;
    exports com.example.gplapplication.service;
    opens com.example.gplapplication.service to javafx.fxml;
}