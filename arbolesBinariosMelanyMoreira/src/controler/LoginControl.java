package controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import arboles.Arbol;
public class LoginControl {
    @FXML
    private Button btAceptar;

    @FXML
    private Button btRegistrar;

    @FXML
    private Label lbContra;

    @FXML
    private Label lbUser;

    @FXML
    private Label lbUser1;

    @FXML
    private PasswordField txtContra;

    @FXML
    private TextField txtUser;

    @FXML
    void MouseAceptarEncima(MouseEvent event) {
    	//rosado
        btAceptar.setStyle("-fx-background-color: #c8398b;");
        btAceptar.setTextFill(Color.WHITE);
    }

    @FXML
    void MouseAceptarSalir(MouseEvent event) {
        btAceptar.setStyle("-fx-background-color: black;");
        btAceptar.setTextFill(Color.WHITE);
    }

    @FXML
    void btRegistrarEncima(MouseEvent event) {
        btRegistrar.setStyle("-fx-background-color: #c8398b;");
        btRegistrar.setTextFill(Color.WHITE);
    }

    @FXML
    void btRegistrarEncimaAbajo(MouseEvent event) {
        btRegistrar.setStyle("-fx-background-color: black;");
        btRegistrar.setTextFill(Color.WHITE);
    }

    @FXML
    //Al hacer click en el botón aceptar, valida si la contraseña y contraseña es igual a "admin"
    void clickAceptar(MouseEvent event) {
        abrirContenido();
    }
    @FXML
    void clickLimpiar(MouseEvent event) {
    	txtContra.setText("");
    	txtUser.setText("");
    	lbUser1.setText("");
    }
    private void abrirContenido() {
        try {
            Stage primaryStage = (Stage) btAceptar.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/contenido.fxml"));
            BorderPane root = loader.load();

            ContenidoControl contenidoControl = loader.getController();
            Arbol arbol= new Arbol();
            contenidoControl.setArbol(arbol);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
