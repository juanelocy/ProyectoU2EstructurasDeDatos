
package controler;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import arboles.Arbol;
public class ContenidoControl {
	public  Arbol arbol;
    @FXML
    private AnchorPane ap;
    public void setArbol(Arbol arbol) {
        this.arbol= arbol;
    }    
    @FXML
    private Button btAnadir;

    @FXML
    private Button btBuscar;

    @FXML
    private Button btEditar;

    @FXML
    private Button btEliminar;

    @FXML
    private Button btInicio;

    @FXML
    private Button btMostrar;
    
    @FXML
    private BorderPane dp;
    @FXML
    void anadirEncima(MouseEvent event) {
    	btAnadir.setStyle("-fx-background-color: #C21010;");
    	btAnadir.setTextFill(Color.WHITE);
    }

    @FXML
    void anadirSalir(MouseEvent event) {
    	btAnadir.setStyle("-fx-background-color: transparent;");
    	btAnadir.setTextFill(Color.WHITE);
    }

    @FXML
    void buscarEncima(MouseEvent event) {
    	btBuscar.setStyle("-fx-background-color: #C21010;");
    	btBuscar.setTextFill(Color.WHITE);
    }

    @FXML
    void buscarSalir(MouseEvent event) {
    	btBuscar.setStyle("-fx-background-color: transparent;");
    	btBuscar.setTextFill(Color.WHITE);
    }

    @FXML
    void editarEncima(MouseEvent event) {
    	btEditar.setStyle("-fx-background-color: #C21010;");
    	btEditar.setTextFill(Color.WHITE);
    }

    @FXML
    void editarSalir(MouseEvent event) {
    	btEditar.setStyle("-fx-background-color: transparent;");
    	btEditar.setTextFill(Color.WHITE);
    }

    @FXML
    void eliminarEncima(MouseEvent event) {
    	btEliminar.setStyle("-fx-background-color: #C21010;");
    	btEliminar.setTextFill(Color.WHITE);
    }

    @FXML
    void eliminarSalir(MouseEvent event) {
    	btEliminar.setStyle("-fx-background-color: transparent;");
    	btEliminar.setTextFill(Color.WHITE);
    }

    @FXML
    void inicioEncima(MouseEvent event) {
    	btInicio.setStyle("-fx-background-color: #C21010;");
    	btInicio.setTextFill(Color.WHITE);
    }

    @FXML
    void inicioSalir(MouseEvent event) {
    	btInicio.setStyle("-fx-background-color: transparent;");
    	btInicio.setTextFill(Color.WHITE);
    }

    @FXML
    void mostrarEncima(MouseEvent event) {
    	btMostrar.setStyle("-fx-background-color: #C21010;");
    	btMostrar.setTextFill(Color.WHITE);
    }

    @FXML
    void mostrarSalir(MouseEvent event) {
    	btMostrar.setStyle("-fx-background-color: transparent;");
    	btMostrar.setTextFill(Color.WHITE);
    }
    //------------------------------------------------------------
    //Controladores cuando hace click en los botones
    //------------------------------------------------------------
    @FXML
    void pagAnadir(MouseEvent event) {
    	cargarPaginas("pagAnadir", arbol);    	
    }
    @FXML
    //-------------------------------------------------------------    
    //Ordenar lista al hacer click en ordenar desde contenido
    //-------------------------------------------------------------
    void pagEditar(MouseEvent event) {
    	cargarPaginas("pagInfo", arbol);
    }
    @FXML
    void pagEliminar(MouseEvent event) {
    }
    @FXML
    void pagInicio(MouseEvent event) {
    	dp.setCenter(ap);
    }
    @FXML
    void pagBuscar(MouseEvent event) {
    	cargarPaginas("pagBuscar", arbol);
    }
    @FXML
    void pagMostrar(MouseEvent event) {
    	cargarPaginas("pagMostrar", arbol);
    	System.out.println("------------------------------------------");
    	System.out.println("               In-orden");
    	System.out.println("------------------------------------------");
    	arbol.mostrarInOrden(arbol.getRaiz());
    	System.out.println("------------------------------------------");
    	System.out.println("               Pre-orden");
    	System.out.println("------------------------------------------");
    	arbol.mostrarPreOrden(arbol.getRaiz());
    	System.out.println("------------------------------------------");
    	System.out.println("               Post-orden");
    	System.out.println("------------------------------------------");
    	arbol.mostrarPostOrden(arbol.getRaiz());
    }
    
    private void cargarPaginas(String pagina, Arbol arbol) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + pagina + ".fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la página cargada
            Object controller = loader.getController();

            // Verificar el tipo de controlador y pasar la instancia de Lista
            if(pagina=="pagMostrar") {
                if (controller instanceof MostrarControl) {
                	MostrarControl mostrarControl = (MostrarControl) controller;
                	mostrarControl.setArbol(arbol);
                	arbol.mostrarInOrden(arbol.getRaiz());
                }
            }
            if(pagina=="pagAnadir") {
                if (controller instanceof PaginaAnadirControler) {
                    PaginaAnadirControler paginaAnadirControler = (PaginaAnadirControler) controller;
                    paginaAnadirControler.setArbol(arbol);
                }
            }
            if(pagina=="pagBuscar") {
                if (controller instanceof ControlBuscar) {
                	ControlBuscar paginaAnadirControler = (ControlBuscar) controller;
                    paginaAnadirControler.setArbol(arbol);
                }
            }
            if(pagina=="pagInfo") {
                if (controller instanceof InfoControl) {
                	InfoControl paginaAnadirControler = (InfoControl) controller;
                    paginaAnadirControler.setArbol(arbol);
                }
            }
            dp.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}