package controler;

import arboles.Arbol;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class InfoControl {
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
    private TextField txtHojas;

    @FXML
    private TextField txtPersonas;

    @FXML
    void clickMostrar(MouseEvent event) {
    	int numeroPersonas=arbol.numNodos(arbol.getRaiz());
    	int numeroHojas=arbol.contarHojas();
    	txtPersonas.setText(numeroPersonas+"");
    	txtHojas.setText(numeroHojas+"");
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

