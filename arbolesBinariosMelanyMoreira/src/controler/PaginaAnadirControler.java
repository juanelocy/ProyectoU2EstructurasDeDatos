package controler;

import arboles.Arbol;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import arboles.Datos;
public class PaginaAnadirControler {
	Arbol arbol;
	public void setArbol(Arbol arbol) {
	    this.arbol= arbol;
	}
    @FXML
    private Button btAgregar;

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
    private Label lbUser221;


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
    private TextField txtPrecio;
    @FXML
    private Label mensajeError;
    @FXML
    void clickAgregar(MouseEvent event) {
    	String idString = txtId.getText();
    	String nombre = txtNombre.getText();
    	String apellido= txtApellido.getText();
    	String color = txtColor.getText();
    	String estado= txtModelo.getText();
    	if(idString==""||nombre==""||apellido==""|| color==""|| estado=="") {
    		mensajeError.setText("LLene todos los campos");
    	}
    	else {
    			Integer id = Integer.valueOf(idString);
    			Datos dato=new Datos(nombre,apellido,color,estado,id);	
    			arbol.insertar(dato);
    			mensajeError.setText("Se agregó correctamente");
    	}
    }
    @FXML
    void pasarAgregar(MouseEvent event) {
    	btAgregar.setStyle("-fx-background-color: #C21010;");
    	btAgregar.setTextFill(Color.WHITE);
    }
    @FXML
    void quitarAgregar(MouseEvent event) {
    	btAgregar.setStyle("-fx-background-color: black;");
    	btAgregar.setTextFill(Color.WHITE);
    }
    void pagAnadir(MouseEvent event) {
        //nose que porner aquí xd
    }

}