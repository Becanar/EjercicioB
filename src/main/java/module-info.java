module org.example.ejerciciob {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejerciciob to javafx.fxml;
    exports org.example.ejerciciob;
}