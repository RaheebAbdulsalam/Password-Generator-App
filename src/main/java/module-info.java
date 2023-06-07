module com.example.passwordgenerator {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.passwordgenerator to javafx.fxml;
    exports com.example.passwordgenerator;
}