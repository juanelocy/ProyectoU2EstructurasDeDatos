package controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import arboles.Arbol;
import arboles.Nodo;
public class ControlBuscar {
	Arbol arbol;
	public void setArbol(Arbol arbol) {
	    this.arbol= arbol;
	}
    @FXML
    private Button btBuscar;
    @FXML
    private Label lbUser;
    @FXML
    private Label lbUser1;
    @FXML
    private Label lbUser2;
    @FXML
    private Label lbUser21;
    @FXML
    private Label lbUser22;
    @FXML
    private Label mensajeError;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtColor;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtNombre;
    @FXML
    void clickAgregar(MouseEvent event) {
    	String cedula=txtId.getText();
    	Integer cedulaInteger = Integer.valueOf(cedula);
    	if(arbol.buscarNodoPorCedula(arbol.getRaiz(),cedulaInteger)==null) {
    		txtId.setText("");   
    		txtApellido.setText("");   
    		txtColor.setText("");   
    		txtModelo.setText("");  
    		mensajeError.setText(cedula+" no existe");
    	}
    	else {    		
    		mensajeError.setText("Persona Encontrada");    		
    		Nodo personaEncontrada;
    		personaEncontrada=arbol.buscarNodoPorCedula(arbol.getRaiz(),cedulaInteger); 		
    		String nombre=personaEncontrada.getNombre();
    		String apellido=personaEncontrada.getApellido();
    		String color=personaEncontrada.getColor();
    		String estado=personaEncontrada.getEstado();
    		
    		//muestro en las cajas de texto  
    		txtNombre.setText(nombre);   
    		txtApellido.setText(apellido);   
    		txtColor.setText(color);   
    		txtModelo.setText(estado);   
    	}
    }

    @FXML
    void pasarAgregar(MouseEvent event) {
    	btBuscar.setStyle("-fx-background-color: #C21010;");
    	btBuscar.setTextFill(Color.WHITE);
    }

    @FXML
    void quitarAgregar(MouseEvent event) {
    	btBuscar.setStyle("-fx-background-color: black;");
    	btBuscar.setTextFill(Color.WHITE);
    }

}