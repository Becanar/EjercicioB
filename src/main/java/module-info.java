module org.example.ejerciciob {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejerciciob to javafx.fxml;
    exports org.example.ejerciciob.model;
    opens org.example.ejerciciob.model to javafx.fxml;
    exports org.example.ejerciciob.app;
    opens org.example.ejerciciob.app to javafx.fxml;
}