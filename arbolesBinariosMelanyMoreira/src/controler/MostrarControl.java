package controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import arboles.Arbol;
public class MostrarControl {
	Arbol arbol;
    public Arbol getArbol() {
		return arbol;
	}
	public void setArbol(Arbol arbol) {
		this.arbol = arbol;
	}

	@FXML
    private Button btMostrar;
    @FXML
    private Label mensajeError;

    @FXML
    void clickMostrar(MouseEvent event) {
    	mensajeError.setText("Mostrando xd");    	
    	if (arbol.ArbolVacio()) {
    		System.out.println("Árbol vacío");
    	}
    	else {
    		arbol.mostrarInOrden(arbol.getRaiz());
    	}
    }
    @FXML
    void pasarAgregar(MouseEvent event) {
        btMostrar.setStyle("-fx-background-color: #C21010;");
        btMostrar.setTextFill(Color.WHITE);
    }
    @FXML
    void quitarAgregar(MouseEvent event) {
        btMostrar.setStyle("-fx-background-color: black;");
        btMostrar.setTextFill(Color.WHITE);
    }
}
