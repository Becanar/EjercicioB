package org.example.ejerciciob.app;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.example.ejerciciob.model.Persona;

import java.util.ArrayList;

/**
 * Controlador de la vista de la tabla de personas.
 * Permite gestionar la adición de personas y la interacción con los componentes de la vista.
 */
public class tablaController {

    @FXML
    private Button btAgregar;

    @FXML
    private TableColumn<Persona,String> columnaApellidos;

    @FXML
    private TableColumn<Persona,Integer> columnaEdad;

    @FXML
    private TableColumn<Persona,String> columnaNombre;

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
    private TableView<Persona> tablaVista;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    private ObservableList<Persona> personas = FXCollections.observableArrayList();
    /**
     * Inicializa las columnas de la tabla con los valores de los atributos de la clase Persona.
     * Este método se ejecuta automáticamente al cargar la vista FXML.
     */
    public void initialize() {
        columnaNombre.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getNombre()));
        columnaApellidos.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getApellidos()));
        columnaEdad.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEdad()));
    }
    /**
     * Muestra una alerta de error con una lista de mensajes de error.
     * @param lst Lista de errores a mostrar en la alerta.
     */
    private void mostrarAlertError(ArrayList<String> lst) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(btAgregar.getScene().getWindow());
        alert.setHeaderText(null);
        alert.setTitle("Error");
        String error="";
        for(String str:lst) {
            error+=str+"\n";
        }
        alert.setContentText(error);
        alert.showAndWait();
    }
    /**
     * Muestra una ventana de confirmación indicando que la persona fue agregada correctamente.
     */
    private void mostrarVentanaOK() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.initOwner(btAgregar.getScene().getWindow());
        alerta.setHeaderText(null);
        alerta.setTitle("Info");
        alerta.setContentText("Persona agregada correctamente.");
        alerta.showAndWait();
    }
    /**
     * Método que se ejecuta al hacer clic en el botón para agregar una persona.
     * Verifica si los campos son válidos y, si lo son, añade la persona a la tabla.
     * @param event Evento de acción asociado al clic del botón.
     */
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
            mostrarAlertError(errores);
        }else {
            Persona p=new Persona(txtNombre.getText(),txtApellidos.getText(),Integer.parseInt(txtEdad.getText()));
            for(Persona persona:tablaVista.getItems()){
                if(p.equals(persona)){
                    error=true;
                }
            }
            if(error){
                errores.add("La persona ya existe.");
                mostrarAlertError(errores);
            }else{
               tablaVista.getItems().add(p);
                mostrarVentanaOK();}
            }
    }
}
