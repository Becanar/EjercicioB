package org.example.ejerciciob;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

import java.util.ArrayList;

public class tablaController {

    @FXML
    private Button btAgregar;

    @FXML
    private TableColumn<?, ?> columnaApellidos;

    @FXML
    private TableColumn<?, ?> columnaEdad;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblEdad;

    @FXML
    private Label lblNombre;

    @FXML
    private VBox panelDatos;

    @FXML
    private BorderPane panelRoot;

    @FXML
    private TableView<?> tablaVista;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    private void mostrarAlertError(Window win, ArrayList<String> lst) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(win);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        String error="";
        for(String str:lst) {
            error+=str+"\n";
        }
        alert.setContentText(error);
        alert.showAndWait();
    }

    private void mostrarVentanaOK() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Info");
        alerta.setContentText("Persona agregada correctamente.");
        alerta.showAndWait();
    }

    @FXML
    void agregarPersona(ActionEvent event) {
        boolean error=false;
        ArrayList<String> errores=new ArrayList<>();
        if(txtNombre.getText().equals("")){
            errores.add("El campo Nombre es obligatorio.");
            error=true;
        }
        if(txtApellidos.getText().equals("")){
            errores.add("El campo Apellidos es obligatorio.");
            error=true;
        }
        try{Integer.parseInt(txtEdad.getText());} catch (NumberFormatException e) {
            errores.add("El campo Edad debe ser numérico.");
            error=true;
        }
        if(error){
            mostrarAlertError(btAgregar.getScene().getWindow(),errores);
        }else {
            Persona p=new Persona(txtNombre.getText(),txtApellidos.getText(),Integer.parseInt(txtEdad.getText()));
            for (int i = 0; i < tablaVista.getItems().size(); i++) {
                String nombreTabla = tablaVista.getColumns().get(0).getCellData(i).toString();
                String apellidosTabla = tablaVista.getColumns().get(1).getCellData(i).toString();
                int edadTabla = Integer.parseInt(tablaVista.getColumns().get(2).getCellData(i).toString());

                if(p.equals(new Persona(nombreTabla,apellidosTabla,edadTabla))){
                    error=true;
                }
            }
            if(error){
                errores.add("La persona ya existe.");
                mostrarAlertError(btAgregar.getScene().getWindow(),errores);
            }else{
            mostrarVentanaOK();}
        }
    }


}
